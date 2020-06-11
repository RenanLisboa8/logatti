package br.com.projetoaula1.service;

import br.com.projetoaula1.model.Produto;
import br.com.projetoaula1.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(int id){
        return produtoRepository.findById(id);
    }

    public void delete(int id){
        produtoRepository.deleteById(id);
    }
}
