package br.com.finance.controlefinanceiro.core.business;

import br.com.finance.controlefinanceiro.config.repository.ControleFinanceiroNativeQueryRepository;
import br.com.finance.controlefinanceiro.config.repository.ControleFinanceiroRepository;
import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
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

}
