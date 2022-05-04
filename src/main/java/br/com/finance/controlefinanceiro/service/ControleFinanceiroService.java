package br.com.finance.controlefinanceiro.service;

import br.com.finance.controlefinanceiro.core.business.ControleFinanceiroBusiness;
import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.core.document.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
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

    public List<Saldo> buscarSaldo(ControleFinanceiro document) {
        return business.buscarSaldo(document);
    }

    public List<ControleFinanceiro> buscarPorParametros(ControleFinanceiro document) {
        return business.buscarPorParametros(document);
    }

    public ControleFinanceiro adicionar(ControleFinanceiro controleFinanceiro) {
        return business.adicionar(controleFinanceiro);
    }

    public List<ControleFinanceiro> adicionarTodos(List<ControleFinanceiro> listaControleFinanceiro) {
        return business.adicionarTodos(listaControleFinanceiro);
    }

    public ControleFinanceiro atualizar(ControleFinanceiro controleFinanceiro) {
        return business.atualizar(controleFinanceiro);
    }

    public void deletar(String id) {
        business.deletar(id);
    }

}
