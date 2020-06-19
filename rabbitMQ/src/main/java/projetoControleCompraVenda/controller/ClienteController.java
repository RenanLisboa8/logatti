package projetoControleCompraVenda.controller;

import projetoControleCompraVenda.constant.Constants;
import projetoControleCompraVenda.model.Cliente;
import projetoControleCompraVenda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(Constants.API_CLIENTE)
    public void save(@RequestBody Cliente cliente){
        clienteService.sendClienteRabbit(cliente);
    }

    @PutMapping(Constants.API_CLIENTE)
    public void update(@RequestBody Cliente cliente){
        this.save(cliente);
    }

    @GetMapping(Constants.API_CLIENTE)
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @DeleteMapping(Constants.API_CLIENTE+"/{id}")
    public void delete(@PathVariable("id") String id){
        clienteService.delete(id);
    }

    @GetMapping(Constants.API_CLIENTE+"/{id}")
    public Optional<Cliente> findById(@PathVariable("id") String id){
        return clienteService.findById(id);
    }
}
