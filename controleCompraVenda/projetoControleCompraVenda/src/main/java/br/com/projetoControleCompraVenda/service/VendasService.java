package br.com.projetoControleCompraVenda.service;

import br.com.projetoControleCompraVenda.interfaces.IVendasRepository;
import br.com.projetoControleCompraVenda.model.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    private IVendasRepository vendaRepository;

    public Vendas save(Vendas vendas){
        return vendaRepository.save(vendas);
    }

    public List<Vendas> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Vendas> findById(int id){
        return vendaRepository.findById(id);
    }

    public void delete(int id){
        vendaRepository.deleteById(id);
    }
}
