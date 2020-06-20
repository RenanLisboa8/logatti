package br.com.p2.service;


import br.com.p2.interfaces.IProdutosRepository;
import br.com.p2.model.Produtos;
import br.com.p2.rabbit.producer.ProdutosProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired
    private IProdutosRepository produtosRepository;

    @Autowired
    private ProdutosProducer produtosProducer;

    public void sendProdutosRabbit(Produtos produtos){
        produtosProducer.send(produtos);
    }

    public Produtos save(Produtos produtos){
        return produtosRepository.save(produtos);
    }

    public List<Produtos> findAll(){
        return produtosRepository.findAll();
    }

    public Optional<Produtos> findById(String id){
        return produtosRepository.findById(id);
    }

    public void delete(String id){
        produtosRepository.deleteById(id);
    }
}
