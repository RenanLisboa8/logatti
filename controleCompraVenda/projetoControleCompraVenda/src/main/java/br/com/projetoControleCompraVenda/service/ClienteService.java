package br.com.projetoControleCompraVenda.service;

import br.com.projetoControleCompraVenda.interfaces.IClienteRepository;
import br.com.projetoControleCompraVenda.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(int id){
        return clienteRepository.findById(id);
    }

    public void delete(int id){
        clienteRepository.deleteById(id);
    }
}
