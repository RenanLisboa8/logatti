package projetoControleCompraVenda.controller;

import projetoControleCompraVenda.constant.Constants;
import projetoControleCompraVenda.model.Compras;
import projetoControleCompraVenda.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping(Constants.API_COMPRAS)
    public void save(@RequestBody Compras compra){
        comprasService.sendComprasRabbit(compra);
    }

    @PutMapping(Constants.API_COMPRAS)
    public void update(@RequestBody Compras compra){
        this.save(compra);
    }

    @GetMapping(Constants.API_COMPRAS)
    public List<Compras> findAll(){
        return comprasService.findAll();
    }

    @DeleteMapping(Constants.API_COMPRAS+"/{id}")
    public void delete(@PathVariable("id") String id){
        comprasService.delete(id);
    }

    @GetMapping(Constants.API_COMPRAS+"/{id}")
    public Optional<Compras> findById(@PathVariable("id") String id){
        return comprasService.findById(id);
    }
}
