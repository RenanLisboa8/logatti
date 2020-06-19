package projetoControleCompraVenda.service;

import projetoControleCompraVenda.interfaces.IComprasRepository;
import projetoControleCompraVenda.model.Cliente;
import projetoControleCompraVenda.model.Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoControleCompraVenda.rabbit.producer.ClienteProducer;
import projetoControleCompraVenda.rabbit.producer.ComprasProducer;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private IComprasRepository comprasRepository;

    @Autowired
    private ComprasProducer comprasProducer;

    public void sendComprasRabbit(Compras compras){
        comprasProducer.send(compras);
    }

    public Compras save(Compras compras) {
        return comprasRepository.save(compras);
    }

    public List<Compras> findAll() {
        return comprasRepository.findAll();
    }

    public Optional<Compras> findById(String id) {
        return comprasRepository.findById(id);
    }

    public void delete(String id) {
        comprasRepository.deleteById(id);
    }
}
