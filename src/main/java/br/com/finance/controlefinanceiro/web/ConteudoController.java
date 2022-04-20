package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.core.document.Conteudo;
import br.com.finance.controlefinanceiro.service.ConteudoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    Logger logger = LoggerFactory.getLogger(ConteudoController.class);
    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Autowired
    private ConteudoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> getConteudoById(@PathVariable String id) throws JsonProcessingException {
        logger.info("Request: GET id[" + id + "]");
        Conteudo response = service.buscarPorId(id);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Conteudo>> getConteudoByTipo(@PathVariable String tipo) throws JsonProcessingException {
        String upperTipo = tipo.toUpperCase();
        logger.info("Request: GET tipo[" + upperTipo + "]");
        List<Conteudo> response = service.buscarPorTipo(upperTipo);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Conteudo>> getConteudoAll() throws JsonProcessingException {
        logger.info("Request: GET todos");
        List<Conteudo> response = service.buscarTodos();
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<Conteudo>> postListaConteudo(
            @RequestBody List<Conteudo> request) throws JsonProcessingException {
        logger.info("Request: POST lista " + objectWriter.writeValueAsString(request));
        List<Conteudo> response = service.adicionarTodos(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Conteudo> postConteudo(
            @RequestBody Conteudo request) throws JsonProcessingException {
        logger.info("Request: POST " + objectWriter.writeValueAsString(request));
        Conteudo response = service.adicionar(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteudo> putConteudo(
            @PathVariable String id,
            @RequestBody Conteudo request) throws JsonProcessingException {
        request.setId(id);
        logger.info("Request: PUT " + objectWriter.writeValueAsString(request));
        Conteudo response = service.atualizar(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteConteudo(
            @PathVariable String id) {
        logger.info("Request: DELETE id[" + id + "]");
        service.deletar(id);
        logger.info("Response: DELETE id[" + id + "]");
        return ResponseEntity.noContent().build();
    }

}
