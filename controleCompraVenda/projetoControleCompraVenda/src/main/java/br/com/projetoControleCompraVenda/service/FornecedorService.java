package br.com.projetoControleCompraVenda.service;

import br.com.projetoControleCompraVenda.interfaces.IFornecedorRepository;
import br.com.projetoControleCompraVenda.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(int id) {
        return fornecedorRepository.findById(id);
    }

    public void delete(int id) {
        fornecedorRepository.deleteById(id);
    }
}
