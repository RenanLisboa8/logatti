package br.com.projetoControleCompraVenda.service;

import br.com.projetoControleCompraVenda.interfaces.IProdutosRepository;
import br.com.projetoControleCompraVenda.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private IProdutosRepository produtoRepository;

    public Produtos save(Produtos produto){
        return produtoRepository.save(produto);
    }

    public List<Produtos> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produtos> findById(int id){
        return produtoRepository.findById(id);
    }

    public void delete(int id){
        produtoRepository.deleteById(id);
    }
}
