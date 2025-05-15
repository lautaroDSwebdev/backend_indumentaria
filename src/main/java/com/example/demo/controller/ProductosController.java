package com.example.demo.controller;

import com.example.demo.entity.ProductosEntity;
import com.example.demo.service.IProductoService;
import com.example.demo.service.ProductosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prod")
public class ProductosController {

    @Autowired
    private IProductoService iprod_service;

    @Autowired
    private ProductosServiceImp prod_service_imp;

    @PostMapping
    public String PostProductos(@RequestBody ProductosEntity body) {
        iprod_service.PostProductos(body);
        return "Producto creado";
    }


    @DeleteMapping("/{id}")
    public String DeleteProductos(@PathVariable Long id) {
        iprod_service.DeleteProductos(id);
        return "Producto eliminado";
    }

    @PutMapping
    public ProductosEntity PutProducto(@RequestBody ProductosEntity body) {
        iprod_service.PutProductos(body);
        return iprod_service.findProductos(body.getId_producto());
    }


    @GetMapping
    public ResponseEntity<List<ProductosEntity>> GetProductos() {
        return new ResponseEntity<>(iprod_service.getProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id_prod}")
    public ResponseEntity<?> GetProductos(@PathVariable Long id_prod) {
        for (ProductosEntity e : iprod_service.getProductos()) {
            if (e.getId_producto().equals(id_prod)) {
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la data");
    }

}
