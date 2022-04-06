package br.com.finance.controlefinanceiro.core.business;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.repository.ControleFinanceiroNativeQueryRepository;
import br.com.finance.controlefinanceiro.repository.ControleFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ControleFinanceiroBusiness {

    @Autowired
    private ControleFinanceiroRepository repository;

    @Autowired
    private ControleFinanceiroNativeQueryRepository nativeQueryRepository;

    public ControleFinanceiro buscarPorId(String id) {
        return Optional.ofNullable(repository.findById(id)).get().orElse(null);
    }

    public List<ControleFinanceiro> buscarTodos() {
        return repository.findAll();
    }

    public List<ControleFinanceiro> buscarRendaGastosAnoMes(Integer ano, Integer mes) {
        return nativeQueryRepository.findRendaGastosAnoMes(ano, mes);
    }

    public List<ControleFinanceiro> buscarTodosAnoMes(Integer ano, Integer mes) {
        return nativeQueryRepository.findAllAnoMes(ano, mes);
    }

    public List<ControleFinanceiro> adicionarTodos(List<ControleFinanceiro> listaControleFinanceiro) {
        return (List<ControleFinanceiro>) repository.saveAll(listaControleFinanceiro);
    }

}
