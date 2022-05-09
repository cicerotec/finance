package br.com.finance.controlefinanceiro.repository.nativequery;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;

import java.util.List;

public interface ControleFinanceiroRepositoryNQCustom {
    List<ControleFinanceiro> findControleFinanceiroByStatements(String statements);
}
