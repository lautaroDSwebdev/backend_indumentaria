package com.example.demo.controller;

import com.example.demo.entity.CategoriaProductoEntity;
import com.example.demo.entity.CompradorEntity;
import com.example.demo.service.ICategoriaProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaProdController {

    @Autowired
    private ICategoriaProdService i_categService;


    @GetMapping
    public List<CategoriaProductoEntity> getCategoria(){
        return i_categService.getCategoria();
    }

    @PostMapping
    public String PostCategoria(@RequestBody CategoriaProductoEntity e){
        i_categService.PostCategoria(e);
        return "Categoria creada 👍";
    }
    @DeleteMapping("/{id}")
    public String DeleteCategoria(@PathVariable Long id){
        i_categService.DeleteCategoria(id);
        return "Categoria eliminada 🚮";
    }
    @PutMapping
    public CategoriaProductoEntity PutCategoria(@RequestBody CategoriaProductoEntity body){
        i_categService.PutCategoria(body);
        return i_categService.findCategoria(body.getId_categoria());
    }
}
