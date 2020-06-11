package br.com.projetoaula1.controller;

import br.com.projetoaula1.constant.Constants;
import br.com.projetoaula1.model.Produto;
import br.com.projetoaula1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoContoller {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(Constants.API_PRODUTO)
    public Produto save(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @PutMapping(Constants.API_PRODUTO)
    public Produto update(@RequestBody Produto produto){
        return this.save(produto);
    }

    @GetMapping(Constants.API_PRODUTO)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @DeleteMapping(Constants.API_PRODUTO+"/{id}")
    public void delete(@PathVariable("id") int id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTO+"/{id}")
    public Optional<Produto> findById(@PathVariable("id") int id){
        return produtoService.findById(id);
    }
}
