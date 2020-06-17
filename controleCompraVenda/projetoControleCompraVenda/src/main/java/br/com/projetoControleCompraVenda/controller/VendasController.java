package br.com.projetoControleCompraVenda.controller;

import br.com.projetoControleCompraVenda.constant.Constants;
import br.com.projetoControleCompraVenda.model.Vendas;
import br.com.projetoControleCompraVenda.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @PostMapping(Constants.API_VENDAS)
    public Vendas save(@RequestBody Vendas vendas){
        return vendasService.save(vendas);
    }

    @PutMapping(Constants.API_VENDAS)
    public Vendas update(@RequestBody Vendas vendas){
        return this.save(vendas);
    }

    @GetMapping(Constants.API_VENDAS)
    public List<Vendas> findAll(){
        return vendasService.findAll();
    }

    @DeleteMapping(Constants.API_VENDAS+"/{id}")
    public void delete(@PathVariable("id") int id){
        vendasService.delete(id);
    }

    @GetMapping(Constants.API_VENDAS+"/{id}")
    public Optional<Vendas> findById(@PathVariable("id") int id){
        return vendasService.findById(id);
    }
}
