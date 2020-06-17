package br.com.projetoControleCompraVenda.service;

import br.com.projetoControleCompraVenda.interfaces.IComprasRepository;
import br.com.projetoControleCompraVenda.model.Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private IComprasRepository comprasRepository;

    public Compras save(Compras compras) {
        return comprasRepository.save(compras);
    }

    public List<Compras> findAll() {
        return comprasRepository.findAll();
    }

    public Optional<Compras> findById(int id) {
        return comprasRepository.findById(id);
    }

    public void delete(int id) {
        comprasRepository.deleteById(id);
    }
}
