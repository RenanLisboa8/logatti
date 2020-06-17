package br.com.projetoControleCompraVenda.controller;

import br.com.projetoControleCompraVenda.constant.Constants;
import br.com.projetoControleCompraVenda.model.Produtos;
import br.com.projetoControleCompraVenda.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutosService produtoService;

    @PostMapping(Constants.API_PRODUTOS)
    public Produtos save(@RequestBody Produtos produto){
        return produtoService.save(produto);
    }

    @PutMapping(Constants.API_PRODUTOS)
    public Produtos update(@RequestBody Produtos produto){
        return this.save(produto);
    }

    @GetMapping(Constants.API_PRODUTOS)
    public List<Produtos> findAll(){
        return produtoService.findAll();
    }

    @DeleteMapping(Constants.API_PRODUTOS+"/{id}")
    public void delete(@PathVariable("id") int id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTOS+"/{id}")
    public Optional<Produtos> findById(@PathVariable("id") int id){
        return produtoService.findById(id);
    }
}
