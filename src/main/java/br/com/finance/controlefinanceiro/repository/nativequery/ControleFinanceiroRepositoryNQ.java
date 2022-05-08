package br.com.finance.controlefinanceiro.repository.nativequery;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope("gastos")
public interface ControleFinanceiroRepositoryNQ extends CrudRepository<ControleFinanceiro, String>, ControleFinanceiroRepositoryNQCustom {
}
