package com.example.demo.controller;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.IProductoRepo;
import com.example.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductosController {

    @Autowired
    private IProductoService iprod_service;

    @GetMapping
    public List<ProductosEntity>  GetProductos(){
        return  iprod_service.getProductos();

    }


    @GetMapping("/{id_prod}")
    public ResponseEntity<?>  GetProductos(@PathVariable Long id_prod){
        for(ProductosEntity e: iprod_service.getProductos()){
            if(e.getId_producto().equals(id_prod)){
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la data");
    }

    @PostMapping
    public String PostProductos(@RequestBody ProductosEntity e){
        iprod_service.PostProductos(e);
        return "Producto creado 👍";
    }
    @DeleteMapping("/del/{id}")
    public String DeleteProductos(@PathVariable Long id){
        iprod_service.DeleteProductos(id);
        return "Producto eliminado";
    }
    @PutMapping
    public ResponseEntity<?> PutProducto(@RequestBody ProductosEntity body){
        if(body.getId_producto() == null){
            return ResponseEntity.badRequest().body("El id_producto no se esta detectando");
        }
        iprod_service.PutProductos(body);
        return ResponseEntity.ok(iprod_service.findProductos(body.getId_producto()));
    }
}
