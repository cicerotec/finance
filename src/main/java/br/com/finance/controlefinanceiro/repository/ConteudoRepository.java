package br.com.finance.controlefinanceiro.repository;

import br.com.finance.controlefinanceiro.core.document.Conteudo;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Scope("gastos")
@Collection("conteudo")
public interface ConteudoRepository extends CrudRepository<Conteudo, String> {

    @Query("#{#n1ql.selectEntity}")
    List<Conteudo> findAll();

    Optional<List<Conteudo>> findByTipo(String tipo);

}
