package br.com.finance.controlefinanceiro.config.repository;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Scope("gastos")
@Collection("testes")
public interface ControleFinanceiroRepository extends JpaRepository<ControleFinanceiro, String>, JpaSpecificationExecutor<ControleFinanceiro> {

    @Query("#{#n1ql.selectEntity}")
    List<ControleFinanceiro> findAll();

}
