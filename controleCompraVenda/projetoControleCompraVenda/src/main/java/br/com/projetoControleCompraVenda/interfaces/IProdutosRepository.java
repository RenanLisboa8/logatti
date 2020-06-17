package br.com.projetoControleCompraVenda.interfaces;

import br.com.projetoControleCompraVenda.model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutosRepository extends MongoRepository<Produtos, Integer> {

}
