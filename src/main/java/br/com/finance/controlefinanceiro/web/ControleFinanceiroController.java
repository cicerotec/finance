package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.service.ControleFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controle-financeiro")
public class ControleFinanceiroController {

    @Autowired
    private ControleFinanceiroService service;

    @GetMapping("/{id}")
    public ResponseEntity<ControleFinanceiro> getControleFinanceiroById(@PathVariable String id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/all")
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

    @PostMapping
    public ResponseEntity<List<ControleFinanceiro>> postControleFinanceiroLista(
            @RequestBody List<ControleFinanceiro> request) {
        return new ResponseEntity<>(service.adicionarTodos(request), HttpStatus.CREATED);
    }

}
