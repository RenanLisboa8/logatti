package projetoControleCompraVenda.controller;

import projetoControleCompraVenda.constant.Constants;
import projetoControleCompraVenda.model.Produtos;
import projetoControleCompraVenda.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutosService produtoService;

    @PostMapping(Constants.API_PRODUTOS)
    public void save(@RequestBody Produtos produto){
        produtoService.sendProdutoRabbit(produto);
    }

    @PutMapping(Constants.API_PRODUTOS)
    public void update(@RequestBody Produtos produto){
        this.save(produto);
    }

    @GetMapping(Constants.API_PRODUTOS)
    public List<Produtos> findAll(){
        return produtoService.findAll();
    }

    @DeleteMapping(Constants.API_PRODUTOS+"/{id}")
    public void delete(@PathVariable("id") String id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTOS+"/{id}")
    public Optional<Produtos> findById(@PathVariable("id") String id){
        return produtoService.findById(id);
    }
}
