package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.service.ControleFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/controles-financeiros")
public class ControleFinanceiroController {

    @Autowired
    private ControleFinanceiroService service;

    @GetMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> getControleFinanceiroById(@PathVariable String id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroAll() {
        return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/renda-gastos/ano/{ano}/mes/{mes}")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroRendaGastosAnoMes(
            @PathVariable Integer ano,
            @PathVariable Integer mes) {
        return new ResponseEntity<>(service.buscarRendaGastosAnoMes(ano, mes), HttpStatus.OK);
    }

    @GetMapping("/todos/ano/{ano}/mes/{mes}")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroTodosAnoMes(
            @PathVariable Integer ano,
            @PathVariable Integer mes) {
        return new ResponseEntity<>(service.buscarTodosAnoMes(ano, mes), HttpStatus.OK);
    }

/*    @PostMapping
    public ResponseEntity<List<ControleFinanceiro>> postListaControleFinanceiro(
            @RequestBody List<ControleFinanceiro> request) {
        return new ResponseEntity<>(service.adicionarTodos(request), HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<ControleFinanceiro> postControleFinanceiro(
            @RequestBody ControleFinanceiro request) {
        return new ResponseEntity<>(service.adicionar(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> putControleFinanceiro(
            @PathVariable String id,
            @RequestBody ControleFinanceiro request) {
        request.setId(id);
        return new ResponseEntity<>(service.atualizar(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteControleFinanceiro(
            @PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
