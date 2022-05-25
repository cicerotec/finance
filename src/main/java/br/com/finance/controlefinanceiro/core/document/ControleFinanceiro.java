package br.com.finance.controlefinanceiro.core.document;

import br.com.finance.controlefinanceiro.util.OffsetDateTimeOptionalZoneDeserializer;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Document
public class ControleFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = UNIQUE)
    @JsonProperty("id")
    @JsonAlias({"__id"})
    private String id;

    @JsonProperty("data_de_referencia")
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    private OffsetDateTime dataReferencia;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    @JsonProperty("data_de_referencia_final")
    private OffsetDateTime  dataReferenciaFinal;

    @JsonProperty("data_do_evento")
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    private OffsetDateTime  dataEvento;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    @JsonProperty("data_do_evento_final")
    private OffsetDateTime  dataEventoFinal;

    @JsonProperty("data_do_pagamento")
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    private OffsetDateTime  dataPagamento;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(using = OffsetDateTimeOptionalZoneDeserializer.class)
    @JsonProperty("data_do_pagamento_final")
    private OffsetDateTime  dataPagamentoFinal;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("nota")
    private String nota;

    @JsonProperty("renda")
    private Double renda;

    @JsonProperty("gastos")
    private Double gastos;

    @JsonProperty("grupos")
    private List<String> grupos;

    @JsonProperty("instituicao_financeira")
    private String instituicaoFinanceira;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tags")
    private List<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OffsetDateTime getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(OffsetDateTime dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public OffsetDateTime getDataReferenciaFinal() {
        return dataReferenciaFinal;
    }

    public void setDataReferenciaFinal(OffsetDateTime dataReferenciaFinal) {
        this.dataReferenciaFinal = dataReferenciaFinal;
    }

    public OffsetDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(OffsetDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public OffsetDateTime getDataEventoFinal() {
        return dataEventoFinal;
    }

    public void setDataEventoFinal(OffsetDateTime dataEventoFinal) {
        this.dataEventoFinal = dataEventoFinal;
    }

    public OffsetDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(OffsetDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public OffsetDateTime getDataPagamentoFinal() {
        return dataPagamentoFinal;
    }

    public void setDataPagamentoFinal(OffsetDateTime dataPagamentoFinal) {
        this.dataPagamentoFinal = dataPagamentoFinal;
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

    public List<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
