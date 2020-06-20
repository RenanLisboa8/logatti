package br.com.p2.interfaces;

import br.com.p2.model.Categorias;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasRepository extends MongoRepository<Categorias, String> {
}
