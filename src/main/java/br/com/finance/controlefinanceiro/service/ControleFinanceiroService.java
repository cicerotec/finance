package br.com.finance.controlefinanceiro.service;

import br.com.finance.controlefinanceiro.core.business.ControleFinanceiroBusiness;
import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleFinanceiroService {

    @Autowired
    private ControleFinanceiroBusiness business;

    public ControleFinanceiro buscarPorId(String id) {
        return business.buscarPorId(id);
    }

    public List<ControleFinanceiro> buscarTodos() {
        return business.buscarTodos();
    }

    public List<ControleFinanceiro> buscarRendaGastosAnoMes(Integer ano, Integer mes) {
        return business.buscarRendaGastosAnoMes(ano, mes);
    }

    public List<ControleFinanceiro> buscarTodosAnoMes(Integer ano, Integer mes) {
        return business.buscarTodosAnoMes(ano, mes);
    }

    public ControleFinanceiro adicionar(ControleFinanceiro controleFinanceiro) {
        return business.adicionar(controleFinanceiro);
    }

}
