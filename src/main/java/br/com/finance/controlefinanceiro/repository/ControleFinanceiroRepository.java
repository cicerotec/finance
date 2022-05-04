package br.com.finance.controlefinanceiro.repository;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
@Scope("gastos")
@Collection("testes")
public interface ControleFinanceiroRepository extends CrudRepository<ControleFinanceiro, String> {

    @Query("#{#n1ql.selectEntity}")
    List<ControleFinanceiro> findAll();

    List<ControleFinanceiro> findByDataReferenciaBetween(
            LocalDateTime dataReferenciaInicial, LocalDateTime dataReferenciaFinal);

    List<ControleFinanceiro> findByDataEventoBetween(
            LocalDateTime dataEventoInicial, LocalDateTime dataEventoFinal);

    List<ControleFinanceiro> findByDataPagamentoBetween(
            LocalDateTime dataPagamentoInicial, LocalDateTime dataPagamentoFinal);

    List<ControleFinanceiro> findByDataReferenciaBetweenAndStatusNotContainsAndGruposNotIn(
            LocalDateTime dataReferenciaInicial, LocalDateTime dataReferenciaFinal, String status, List<String> grupos);

}
