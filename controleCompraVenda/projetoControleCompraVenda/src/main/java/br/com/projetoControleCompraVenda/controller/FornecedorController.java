package br.com.projetoControleCompraVenda.controller;

import br.com.projetoControleCompraVenda.constant.Constants;
import br.com.projetoControleCompraVenda.model.Fornecedor;
import br.com.projetoControleCompraVenda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping(Constants.API_FORNECEDOR)
    public Fornecedor save(@RequestBody Fornecedor fornecedor){
        return fornecedorService.save(fornecedor);
    }

    @PutMapping(Constants.API_FORNECEDOR)
    public Fornecedor update(@RequestBody Fornecedor fornecedor){
        return this.save(fornecedor);
    }

    @GetMapping(Constants.API_FORNECEDOR)
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();
    }

    @DeleteMapping(Constants.API_FORNECEDOR+"/{id}")
    public void delete(@PathVariable("id") int id){
        fornecedorService.delete(id);
    }

    @GetMapping(Constants.API_FORNECEDOR+"/{id}")
    public Optional<Fornecedor> findById(@PathVariable("id") int id){
        return fornecedorService.findById(id);
    }
}
