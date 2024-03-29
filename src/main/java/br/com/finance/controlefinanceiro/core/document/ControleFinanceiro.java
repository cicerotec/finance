package br.com.finance.controlefinanceiro.core.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class ControleFinanceiro {

    @Id
    private String id;
    private LocalDate data_de_referencia;
    private LocalDate data_do_evento;
    private LocalDate data_do_pagamento;
    private String descricao;
    private String nota;
    private Double renda;
    private Double gastos;
    private List<String> grupo;
    private String instituicao_financeira;
    private String status;
    private String tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData_de_referencia() {
        return data_de_referencia;
    }

    public void setData_de_referencia(LocalDate data_de_referencia) {
        this.data_de_referencia = data_de_referencia;
    }

    public LocalDate getData_do_evento() {
        return data_do_evento;
    }

    public void setData_do_evento(LocalDate data_do_evento) {
        this.data_do_evento = data_do_evento;
    }

    public LocalDate getData_do_pagamento() {
        return data_do_pagamento;
    }

    public void setData_do_pagamento(LocalDate data_do_pagamento) {
        this.data_do_pagamento = data_do_pagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public List<String> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<String> grupo) {
        this.grupo = grupo;
    }

    public String getInstituicao_financeira() {
        return instituicao_financeira;
    }

    public void setInstituicao_financeira(String instituicao_financeira) {
        this.instituicao_financeira = instituicao_financeira;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
