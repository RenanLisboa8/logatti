package br.com.projetoControleCompraVenda.interfaces;

import br.com.projetoControleCompraVenda.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, Integer> {
}
