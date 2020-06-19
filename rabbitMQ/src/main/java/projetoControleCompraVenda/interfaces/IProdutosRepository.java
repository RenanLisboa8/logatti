package projetoControleCompraVenda.interfaces;

import projetoControleCompraVenda.model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutosRepository extends MongoRepository<Produtos, String> {

}
