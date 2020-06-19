package projetoControleCompraVenda.interfaces;

import projetoControleCompraVenda.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFornecedorRepository extends MongoRepository<Fornecedor, String> {

}
