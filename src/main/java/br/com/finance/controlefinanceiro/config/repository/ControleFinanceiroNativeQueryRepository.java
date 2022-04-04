package br.com.finance.controlefinanceiro.config.repository;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static br.com.finance.controlefinanceiro.util.Constants.ALIAS_CONTROLE_FINANCEIRO_COMMONS;


@Repository
@Scope("gastos")
public interface ControleFinanceiroNativeQueryRepository extends CrudRepository<ControleFinanceiro, String> {

    @Query("SELECT " + ALIAS_CONTROLE_FINANCEIRO_COMMONS +
            " FROM testes " +
            " WHERE ANY grupos IN grupo SATISFIES grupos IN ['RENDA','GASTOS'] END" +
            " AND DATE_PART_STR(data_de_referencia, 'year') = $1" +
            " AND DATE_PART_STR(data_de_referencia, 'month') = $2" +
            " ORDER BY data_de_referencia," +
            "          data_do_pagamento," +
            "          data_do_evento ")
    List<ControleFinanceiro> findRendaGastosAnoMes(Integer ano, Integer mes);

}
