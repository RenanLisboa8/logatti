package br.com.projetoControleCompraVenda.interfaces;

import br.com.projetoControleCompraVenda.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFornecedorRepository extends MongoRepository<Fornecedor, Integer> {

}
