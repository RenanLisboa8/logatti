package br.com.p2.controller;

import br.com.p2.constant.Constants;
import br.com.p2.model.Categorias;
import br.com.p2.model.Categorias;
import br.com.p2.service.CategoriasService;
import br.com.p2.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriasController {
    @Autowired
    private CategoriasService categoriaService;

    @PostMapping(Constants.API_CATEGORIAS)
    public void save(@RequestBody Categorias categorias){
        categoriaService.sendCategoriasRabbit(categorias);
    }

    @PutMapping(Constants.API_CATEGORIAS)
    public void update(@RequestBody Categorias categoria){
        this.save(categoria);
    }

    @GetMapping(Constants.API_CATEGORIAS)
    public List<Categorias> findAll(){
        return categoriaService.findAll();
    }

    @DeleteMapping(Constants.API_CATEGORIAS+"/{id}")
    public void delete(@PathVariable("id") String id){
        categoriaService.delete(id);
    }

    @GetMapping(Constants.API_CATEGORIAS+"/{id}")
    public Optional<Categorias> findById(@PathVariable("id") String id){
        return categoriaService.findById(id);
    }
}
