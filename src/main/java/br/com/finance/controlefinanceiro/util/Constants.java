package br.com.finance.controlefinanceiro.util;

public class Constants {

    public static final String ALIAS_CONTROLE_FINANCEIRO_COMMONS =
            " meta().id as __id, " +
                    " meta().cas as __cas, " +
                    " MILLIS_TO_STR(dataReferencia) as data_de_referencia," +
                    " MILLIS_TO_STR(dataEvento) as data_do_evento," +
                    " MILLIS_TO_STR(dataPagamento) as data_do_pagamento," +
                    " descricao," +
                    " nota," +
                    " renda," +
                    " gastos," +
                    " grupos," +
                    " instituicaoFinanceira as instituicao_financeira," +
                    " status," +
                    " tags";

    public static final String WHERE = " WHERE ";

    public static final String AND = " AND ";

    public static final String BUSCA_GRUPOS = "ANY grupo IN grupos SATISFIES grupo IN $$ END";

    public static final String BUSCA_TAGS = "ANY tag IN tags SATISFIES tag IN $$ END";

    public static final String BUSCA_STATUS = "status IN ['$$']";

    public static final String BUSCA_DATA_REFERENCIA = "dataReferencia BETWEEN STR_TO_MILLIS('$$') AND STR_TO_MILLIS('&&')";

    public static final String BUSCA_DATA_PAGAMENTO = "dataPagamento BETWEEN STR_TO_MILLIS('$$') AND STR_TO_MILLIS('&&')";

    public static final String BUSCA_DATA_EVENTO = "dataEvento BETWEEN STR_TO_MILLIS('$$') AND STR_TO_MILLIS('$$')";

    public static final String BUSCA_INSTITUICAO_FINANCEIRA = "instituicaoFinanceira = '$$'";

    public static final String BUSCA_DESCRICAO = "default:diacritics_upper(descricao) LIKE default:diacritics_upper('%$$%')";

    public static final String BUSCA_NOTA = "default:diacritics_upper(nota) LIKE default:diacritics_upper('%$$%')";

    public static final String ORDER_BY_DATA_REFERENCIA = " ORDER BY dataReferencia";

}
