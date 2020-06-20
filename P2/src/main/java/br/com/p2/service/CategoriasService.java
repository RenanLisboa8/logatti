package br.com.p2.service;


import br.com.p2.interfaces.ICategoriasRepository;
import br.com.p2.model.Categorias;
import br.com.p2.rabbit.producer.CategoriasProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {
    @Autowired
    private ICategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasProducer categoriasProducer;

    public void sendCategoriasRabbit(Categorias categorias){
        categoriasProducer.send(categorias);
    }

    public Categorias save(Categorias categorias){
        return categoriasRepository.save(categorias);
    }

    public List<Categorias> findAll(){
        return categoriasRepository.findAll();
    }

    public Optional<Categorias> findById(String id){
        return categoriasRepository.findById(id);
    }

    public void delete(String id){
        categoriasRepository.deleteById(id);
    }
}
