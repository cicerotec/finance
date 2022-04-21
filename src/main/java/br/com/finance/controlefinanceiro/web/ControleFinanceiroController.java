package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.service.ControleFinanceiroService;
import br.com.finance.controlefinanceiro.util.ParamsToDocument;
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
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/controles-financeiros")
public class ControleFinanceiroController {

    Logger logger = LoggerFactory.getLogger(ControleFinanceiroController.class);
    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Autowired
    private ControleFinanceiroService service;

    @Autowired
    private ParamsToDocument paramsToDocument;

    @GetMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> getControleFinanceiroById(@PathVariable String id) throws JsonProcessingException {
        logger.info("Request: GET id[" + id + "]");
        ControleFinanceiro response = service.buscarPorId(id);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroAll() throws JsonProcessingException {
        logger.info("Request: GET todos");
        List<ControleFinanceiro> response = service.buscarTodos();
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/renda-gastos/ano/{ano}/mes/{mes}")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroRendaGastosAnoMes(
            @PathVariable Integer ano,
            @PathVariable Integer mes) throws JsonProcessingException {
        logger.info("Request: GET renda-gastos, ano[" + ano + "] mes[" + mes + "]");
        List<ControleFinanceiro> response = service.buscarRendaGastosAnoMes(ano, mes);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/todos/ano/{ano}/mes/{mes}")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroTodosAnoMes(
            @PathVariable Integer ano,
            @PathVariable Integer mes) throws JsonProcessingException {
        logger.info("Request: GET todos, ano[" + ano + "] mes[" + mes + "]");
        List<ControleFinanceiro> response = service.buscarTodosAnoMes(ano, mes);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroByParam(
            @RequestParam Map<String, String> params) throws JsonProcessingException {

        ControleFinanceiro document = paramsToDocument.transform(params, ControleFinanceiro.class);

        logger.info("Request: GET params " + objectWriter.writeValueAsString(document));
        List<ControleFinanceiro> response = service.buscarPorParametros(document);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<ControleFinanceiro>> postListaControleFinanceiro(
            @RequestBody List<ControleFinanceiro> request) throws JsonProcessingException {
        logger.info("Request: POST lista " + objectWriter.writeValueAsString(request));
        List<ControleFinanceiro> response = service.adicionarTodos(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ControleFinanceiro> postControleFinanceiro(
            @RequestBody ControleFinanceiro request) throws JsonProcessingException {
        logger.info("Request: POST " + objectWriter.writeValueAsString(request));
        ControleFinanceiro response = service.adicionar(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> putControleFinanceiro(
            @PathVariable String id,
            @RequestBody ControleFinanceiro request) throws JsonProcessingException {
        request.setId(id);
        logger.info("Request: PUT " + objectWriter.writeValueAsString(request));
        ControleFinanceiro response = service.atualizar(request);
        logger.info("Response: " + objectWriter.writeValueAsString(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteControleFinanceiro(
            @PathVariable String id) {
        logger.info("Request: DELETE id[" + id + "]");
        service.deletar(id);
        logger.info("Response: DELETE id[" + id + "]");
        return ResponseEntity.noContent().build();
    }

}
