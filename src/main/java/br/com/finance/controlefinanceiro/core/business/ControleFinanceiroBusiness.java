package br.com.finance.controlefinanceiro.core.business;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.core.document.Saldo;
import br.com.finance.controlefinanceiro.repository.ControleFinanceiroRepository;
import br.com.finance.controlefinanceiro.repository.nativequery.ControleFinanceiroRepositoryNQ;
import br.com.finance.controlefinanceiro.repository.nativequery.SaldoRepositoryNQ;
import br.com.finance.controlefinanceiro.util.DataTimeFormatUtil;
import br.com.finance.controlefinanceiro.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static br.com.finance.controlefinanceiro.util.Constants.*;

@Component
public class ControleFinanceiroBusiness {

    @Autowired
    private ControleFinanceiroRepository repoControleFinanceiro;

    @Autowired
    private SaldoRepositoryNQ repoSaldoNQ;

    @Autowired
    private ControleFinanceiroRepositoryNQ repoControleFinanceiroNQ;

    @Autowired
    DataTimeFormatUtil dataTimeFormatUtil;

    public ControleFinanceiro buscarPorId(String id) {
        return Optional.ofNullable(repoControleFinanceiro.findById(id)).get().orElseThrow(NotFoundException::new);
    }

    public List<ControleFinanceiro> buscarTodos() {
        return repoControleFinanceiro.findAll();
    }

    public List<Saldo> buscarSaldo(ControleFinanceiro document) {
        List<Saldo> result = new ArrayList<>();
        //buscar saldo por data de referencia
        if (Objects.nonNull(document.getDataReferencia()) && Objects.nonNull(document.getDataReferenciaFinal())) {
            result = repoSaldoNQ.findSaldo(
                    document.getDataReferencia(),
                    document.getDataReferenciaFinal());
        }

        if (result.isEmpty()) {
            throw new NotFoundException();
        }

        return result;
    }

    public List<ControleFinanceiro> buscarPorParametros(ControleFinanceiro document) {
        List<ControleFinanceiro> result = new ArrayList<>();
        String statements = "";
        //grupos
        if (Objects.nonNull(document.getGrupos())) {
            statements = statements + BUSCA_GRUPOS.concat(AND).replace("$$",document.getGrupos().toString());
            statements = statements.replace("[","['").replaceAll(",","','").replace("]","']");
        }
        //tags
        if (Objects.nonNull(document.getTags())) {
            statements = statements + BUSCA_TAGS.concat(AND).replace("$$",document.getTags().toString());
            statements = statements.replace("[","['").replaceAll(",","','").replace("]","']");
        }
        //status
        if (Objects.nonNull(document.getStatus())) {
            statements = statements + BUSCA_STATUS.concat(AND)
                    .replace("$$",document.getGrupos().toString());
        }
        //data_referencia
        if (Objects.nonNull(document.getDataReferencia()) && Objects.nonNull(document.getDataReferenciaFinal())) {
            statements = statements + BUSCA_DATA_REFERENCIA.concat(AND)
                    .replace("$$",document.getDataReferencia().format(dataTimeFormatUtil.getFormatter()))
                    .replace("&&",document.getDataReferenciaFinal().format(dataTimeFormatUtil.getFormatter()));
        }
        //data_pagamento
        if (Objects.nonNull(document.getDataPagamento()) && Objects.nonNull(document.getDataPagamentoFinal())) {
            statements = statements + BUSCA_DATA_PAGAMENTO.concat(AND)
                    .replace("$$",document.getDataPagamento().toString())
                    .replace("&&",document.getDataPagamentoFinal().toString());
        }
        //data_evento
        if (Objects.nonNull(document.getDataEvento()) && Objects.nonNull(document.getDataEventoFinal())) {
            statements = statements + BUSCA_DATA_EVENTO.concat(AND)
                    .replace("$$",document.getDataEvento().toString())
                    .replace("&&",document.getDataEventoFinal().toString());
        }
        //instituicao_financeira
        if (Objects.nonNull(document.getInstituicaoFinanceira())) {
            statements = statements + BUSCA_INSTITUICAO_FINANCEIRA.concat(AND)
                    .replace("$$",document.getInstituicaoFinanceira());
        }
        //descricao
        if (Objects.nonNull(document.getDescricao())) {
            statements = statements + BUSCA_DESCRICAO.concat(AND)
                    .replace("$$",document.getDescricao());
        }
        //nota
        if (Objects.nonNull(document.getNota())) {
            statements = statements + BUSCA_NOTA.concat(AND)
                    .replace("$$",document.getNota());
        }

        if(!statements.isBlank()) {
            statements = WHERE.concat(statements);
            statements = statements.substring(0, statements.length() - AND.length());
            statements = statements.concat(ORDER_BY_DATA_REFERENCIA);
            result = repoControleFinanceiroNQ.findControleFinanceiroByStatements(statements);
        }

        if (result.isEmpty()) {
            throw new NotFoundException();
        }

        return result;
    }

    public ControleFinanceiro adicionar(ControleFinanceiro controleFinanceiro) {
        List<ControleFinanceiro> result = this.adicionarTodos(Arrays.asList(controleFinanceiro));
        return result.stream().findFirst().get();
    }

    public List<ControleFinanceiro> adicionarTodos(List<ControleFinanceiro> listaControleFinanceiro) {
        return (List<ControleFinanceiro>) repoControleFinanceiro.saveAll(listaControleFinanceiro);
    }

    public ControleFinanceiro atualizar(ControleFinanceiro controleFinanceiro) {
        return repoControleFinanceiro.save(controleFinanceiro);
    }

    public void deletar(String id) {
        repoControleFinanceiro.deleteById(id);
    }

}
