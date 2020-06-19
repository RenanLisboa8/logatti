package projetoControleCompraVenda.service;

import projetoControleCompraVenda.interfaces.IVendasRepository;
import projetoControleCompraVenda.model.Vendas;
import projetoControleCompraVenda.model.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoControleCompraVenda.rabbit.producer.VendasProducer;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    private IVendasRepository vendaRepository;

    @Autowired
    private VendasProducer vendasProducer;

    public void sendVendasRabbit(Vendas vendas){
        vendasProducer.send(vendas);
    }
    public Vendas save(Vendas vendas){
        return vendaRepository.save(vendas);
    }

    public List<Vendas> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Vendas> findById(String id){
        return vendaRepository.findById(id);
    }

    public void delete(String id){
        vendaRepository.deleteById(id);
    }
}
