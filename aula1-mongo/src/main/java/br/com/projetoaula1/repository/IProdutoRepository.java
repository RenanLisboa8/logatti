package br.com.projetoaula1.repository;

import br.com.projetoaula1.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, Integer> {
}
