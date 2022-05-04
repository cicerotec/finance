package br.com.finance.controlefinanceiro.core.document;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Saldo implements Serializable  {

    private static final long serialVersionUID = 1L;

    @JsonProperty("nome")
    private String instituicaoFinanceira;

    @JsonProperty("valor")
    private Double saldo;

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}