package com.example.demo.controller;

import com.example.demo.entity.CompradorEntity;
import com.example.demo.entity.PedidoEntity;
import com.example.demo.service.iCompradorService;
import com.example.demo.service.IPedidoService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comprador")
public class CompradorController {

    @Autowired
    private iCompradorService i_compraservice;

    @GetMapping
    public  ResponseEntity<Page<CompradorEntity>> GetComprador(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<CompradorEntity> comprador_get = i_compraservice.getComprador(page, size);
        return ResponseEntity.ok(comprador_get);
    }

    @PostMapping
    public String PostCpmpra(@RequestBody CompradorEntity e){
        i_compraservice.PostComprador(e);
        return "Comprador creado 👍";
    }
    @DeleteMapping("/{id}")
    public String DeleteComprador(@PathVariable Long id){
        i_compraservice.DeleteComprador(id);
        return "Comprador eliminado 🚮";
    }
    @PutMapping
    public CompradorEntity PutComprador(@RequestBody CompradorEntity body){
        i_compraservice.PutComprador(body);
        return i_compraservice.findComprador(body.getIdComprador());
    }

}
