package br.com.finance.controlefinanceiro.repository;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Scope("gastos")
@Collection("testes")
public interface ControleFinanceiroRepository extends CrudRepository<ControleFinanceiro, String> {

    @Query("#{#n1ql.selectEntity}")
    List<ControleFinanceiro> findAll();

}
