package br.com.finance.controlefinanceiro.repository;

import br.com.finance.controlefinanceiro.core.document.Saldo;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Scope("gastos")
public interface SaldoNativeQueryRepository extends CrudRepository<Saldo, String> {

    @Query("SELECT " +
            " a.instituicaoFinanceira as __id, " +
            " 0 as __cas, " +
            " SUM(NVL(a.renda,0)) - SUM(NVL(a.gastos,0)) AS saldo," +
            " a.instituicaoFinanceira" +
            " FROM testes a" +
            " WHERE EVERY grupo IN grupos SATISFIES grupo NOT IN ['CREDITO'] END" +
            " AND status NOT IN ['PREVISTO']" +
            " AND a.dataReferencia BETWEEN $1 AND $2" +
            " GROUP BY a.instituicaoFinanceira" +
            " ORDER BY a.instituicaoFinanceira")
    List<Saldo> findSaldo(
            LocalDateTime dataReferenciaInicial,
            LocalDateTime dataReferenciaFinal);

}
