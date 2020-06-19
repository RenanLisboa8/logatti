package projetoControleCompraVenda.controller;

import projetoControleCompraVenda.constant.Constants;
import projetoControleCompraVenda.model.Fornecedor;
import projetoControleCompraVenda.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping(Constants.API_FORNECEDOR)
    public void save(@RequestBody Fornecedor fornecedor){
        fornecedorService.sendFornecedorRabbit(fornecedor);
    }

    @PutMapping(Constants.API_FORNECEDOR)
    public void update(@RequestBody Fornecedor fornecedor){
        this.save(fornecedor);
    }

    @GetMapping(Constants.API_FORNECEDOR)
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();
    }

    @DeleteMapping(Constants.API_FORNECEDOR+"/{id}")
    public void delete(@PathVariable("id") String id){
        fornecedorService.delete(id);
    }

    @GetMapping(Constants.API_FORNECEDOR+"/{id}")
    public Optional<Fornecedor> findById(@PathVariable("id") String id){
        return fornecedorService.findById(id);
    }
}
