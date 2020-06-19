package projetoControleCompraVenda.interfaces;

import projetoControleCompraVenda.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprasRepository extends MongoRepository<Compras, String> {
}
