package projetoControleCompraVenda.controller;

import projetoControleCompraVenda.constant.Constants;
import projetoControleCompraVenda.model.Vendas;
import projetoControleCompraVenda.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @PostMapping(Constants.API_VENDAS)
    public void save(@RequestBody Vendas vendas){
        vendasService.sendVendasRabbit(vendas);
    }

    @PutMapping(Constants.API_VENDAS)
    public void update(@RequestBody Vendas vendas){
        this.save(vendas);
    }

    @GetMapping(Constants.API_VENDAS)
    public List<Vendas> findAll(){
        return vendasService.findAll();
    }

    @DeleteMapping(Constants.API_VENDAS+"/{id}")
    public void delete(@PathVariable("id") String id){
        vendasService.delete(id);
    }

    @GetMapping(Constants.API_VENDAS+"/{id}")
    public Optional<Vendas> findById(@PathVariable("id") String id){
        return vendasService.findById(id);
    }
}
