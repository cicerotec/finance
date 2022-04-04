package br.com.finance.controlefinanceiro.web;

import br.com.finance.controlefinanceiro.service.ControleFinanceiroService;
import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControleFinanceiroController {

    @Autowired
    private ControleFinanceiroService service;

    @GetMapping("/controle-financeiro/{id}")
    public ResponseEntity<ControleFinanceiro> getControleFinanceiroById(@PathVariable String id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/controle-financeiro/all")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroAll() {
        return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/controle-financeiro/renda-gastos/ano/{ano}/mes/{mes}")
    public ResponseEntity<List<ControleFinanceiro>> getControleFinanceiroRendaGastosAnoMes(
            @PathVariable Integer ano,
            @PathVariable Integer mes) {
        return new ResponseEntity<>(service.buscarRendaGastosAnoMes(ano, mes), HttpStatus.OK);
    }

}
