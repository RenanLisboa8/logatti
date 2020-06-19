package projetoControleCompraVenda.service;

import projetoControleCompraVenda.interfaces.IClienteRepository;
import projetoControleCompraVenda.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoControleCompraVenda.rabbit.producer.ClienteProducer;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteProducer clienteProducer;

    public void sendClienteRabbit(Cliente cliente){
        clienteProducer.send(cliente);
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(String id){
        return clienteRepository.findById(id);
    }

    public void delete(String id){
        clienteRepository.deleteById(id);
    }
}
