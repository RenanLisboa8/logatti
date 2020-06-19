package projetoControleCompraVenda.interfaces;

import projetoControleCompraVenda.model.Vendas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendasRepository extends MongoRepository<Vendas, String> {
}
