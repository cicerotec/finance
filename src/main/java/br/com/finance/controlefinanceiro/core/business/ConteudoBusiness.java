package br.com.finance.controlefinanceiro.core.business;

import br.com.finance.controlefinanceiro.core.document.Conteudo;
import br.com.finance.controlefinanceiro.repository.ConteudoRepository;
import br.com.finance.controlefinanceiro.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ConteudoBusiness {

    @Autowired
    private ConteudoRepository repository;

    public Conteudo buscarPorId(String id) {
        return Optional.ofNullable(repository.findById(id)).get().orElseThrow(NotFoundException::new);
    }

    public List<Conteudo> buscarPorTipo(String tipo) {
        return Optional.ofNullable(repository.findByTipo(tipo)).get().orElseThrow(NotFoundException::new);
    }

    public List<Conteudo> buscarTodos() {
        return repository.findAll();
    }

    public Conteudo adicionar(Conteudo conteudo) {
        List<Conteudo> result = this.adicionarTodos(Arrays.asList(conteudo));
        return result.stream().findFirst().get();
    }

    public List<Conteudo> adicionarTodos(List<Conteudo> listaConteudo) {
        return (List<Conteudo>) repository.saveAll(listaConteudo);
    }

    public Conteudo atualizar(Conteudo conteudo) {
        return repository.save(conteudo);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

}
