package br.com.projetoControleCompraVenda.controller;

import br.com.projetoControleCompraVenda.constant.Constants;
import br.com.projetoControleCompraVenda.model.Compras;
import br.com.projetoControleCompraVenda.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping(Constants.API_COMPRAS)
    public Compras save(@RequestBody Compras compra){
        return comprasService.save(compra);
    }

    @PutMapping(Constants.API_COMPRAS)
    public Compras update(@RequestBody Compras compra){
        return this.save(compra);
    }

    @GetMapping(Constants.API_COMPRAS)
    public List<Compras> findAll(){
        return comprasService.findAll();
    }

    @DeleteMapping(Constants.API_COMPRAS+"/{id}")
    public void delete(@PathVariable("id") int id){
        comprasService.delete(id);
    }

    @GetMapping(Constants.API_COMPRAS+"/{id}")
    public Optional<Compras> findById(@PathVariable("id") int id){
        return comprasService.findById(id);
    }
}
