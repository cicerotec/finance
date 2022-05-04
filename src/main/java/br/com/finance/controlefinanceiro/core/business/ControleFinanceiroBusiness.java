package br.com.finance.controlefinanceiro.core.business;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.core.document.Saldo;
import br.com.finance.controlefinanceiro.repository.ControleFinanceiroRepository;
import br.com.finance.controlefinanceiro.repository.SaldoNativeQueryRepository;
import br.com.finance.controlefinanceiro.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ControleFinanceiroBusiness {

    @Autowired
    private ControleFinanceiroRepository repoControleFinanceiro;

    @Autowired
    private SaldoNativeQueryRepository repoSaldo;

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
            result = repoSaldo.findSaldo(
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
        //Data de referencia
        if (Objects.nonNull(document.getDataReferencia()) && Objects.nonNull(document.getDataReferenciaFinal())) {
            result = repoControleFinanceiro.findByDataReferenciaBetween(
                    document.getDataReferencia(),
                    document.getDataReferenciaFinal());
        }
        //Data do evento
        if (Objects.nonNull(document.getDataEvento()) && Objects.nonNull(document.getDataEventoFinal())) {
            result = repoControleFinanceiro.findByDataEventoBetween(
                    document.getDataEvento(),
                    document.getDataEventoFinal());
        }
        //Data do pagamento
        if (Objects.nonNull(document.getDataPagamento()) && Objects.nonNull(document.getDataPagamentoFinal())) {
            result = repoControleFinanceiro.findByDataPagamentoBetween(
                    document.getDataPagamento(),
                    document.getDataPagamentoFinal());
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
