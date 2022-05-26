package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.core.document.Saldo;
import br.com.finance.controlefinanceiro.service.ControleFinanceiroService;
import br.com.finance.controlefinanceiro.util.ParamsToDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Autowired
    private ControleFinanceiroService service;

    @Autowired
    private ParamsToDocument paramsToDocument;

    @GetMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> getControleFinanceiroById(@PathVariable String id) throws JsonProcessingException {
        ControleFinanceiro response = service.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroAll() throws JsonProcessingException {
        List<ControleFinanceiro> response = service.buscarTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroByParam(
            @RequestParam Map<String, Object> params) throws JsonProcessingException {
        ControleFinanceiro document = paramsToDocument.transform(params, ControleFinanceiro.class);
        List<ControleFinanceiro> response = service.buscarPorParametros(document);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/saldos")
    public ResponseEntity<List<Saldo>> getControleFinanceiroSaldoByParam(
            @RequestParam Map<String, Object> params) throws JsonProcessingException {
        ControleFinanceiro document = paramsToDocument.transform(params, ControleFinanceiro.class);
        List<Saldo> response = service.buscarSaldo(document);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/lista")
    public ResponseEntity<List<ControleFinanceiro>> postListaControleFinanceiro(
            @RequestBody List<ControleFinanceiro> request) throws JsonProcessingException {
        List<ControleFinanceiro> response = service.adicionarTodos(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ControleFinanceiro> postControleFinanceiro(
            @RequestBody ControleFinanceiro request) throws JsonProcessingException {
        ControleFinanceiro response = service.adicionar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> putControleFinanceiro(
            @PathVariable String id,
            @RequestBody ControleFinanceiro request) throws JsonProcessingException {
        request.setId(id);
        ControleFinanceiro response = service.atualizar(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteControleFinanceiro(
            @PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
