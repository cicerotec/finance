package br.com.finance.controlefinanceiro.service;

import br.com.finance.controlefinanceiro.core.business.ConteudoBusiness;
import br.com.finance.controlefinanceiro.core.document.Conteudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoService {

    @Autowired
    private ConteudoBusiness business;

    public Conteudo buscarPorId(String id) {
        return business.buscarPorId(id);
    }

    public List<Conteudo> buscarPorTipo(String tipo) {
        return business.buscarPorTipo(tipo);
    }

    public List<Conteudo> buscarTodos() {
        return business.buscarTodos();
    }

    public Conteudo adicionar(Conteudo conteudo) {
        return business.adicionar(conteudo);
    }

    public List<Conteudo> adicionarTodos(List<Conteudo> listaConteudo) {
        return business.adicionarTodos(listaConteudo);
    }

    public Conteudo atualizar(Conteudo conteudo) {
        return business.atualizar(conteudo);
    }

    public void deletar(String id) {
        business.deletar(id);
    }

}
