package com.example.demo.controller;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.IProductoRepo;
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
//@CrossOrigin
@RequestMapping("/prod")
public class ProductosController {

    @Autowired
    private IProductoService iprod_service;

    @Autowired
    private ProductosServiceImp prod_service_imp;

    @PostMapping
    public ResponseEntity<ProductosEntity> PostProductos(@RequestPart("prod") ProductosEntity body,
                                                         @RequestPart("file") MultipartFile file) {
        try {
            ProductosEntity postProd = prod_service_imp.saveProductos(body, file);
            return new ResponseEntity<>(postProd, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteProductos(@PathVariable Long id) throws IOException {
        Optional<ProductosEntity> prod = prod_service_imp.getProductosById(id);
        if(prod.isPresent()){
            prod_service_imp.DeleteProductos(prod.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

//    entidad imagen
//    pide el id del producto
    @PutMapping("/{id}/image")
    public ResponseEntity<ProductosEntity> PutImageProd(@PathVariable Long id, @RequestPart("file")MultipartFile file) throws IOException{
        Optional<ProductosEntity> prod = prod_service_imp.getProductosById(id);
        if(prod.isPresent()){
            ProductosEntity putProd = prod_service_imp.updateProductoImage(file, prod.get());
            return new ResponseEntity<>(putProd, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    entidad producto
    @PutMapping
    public ResponseEntity<?> PutProducto(@RequestBody ProductosEntity body){
        try{
            ProductosEntity putProd = prod_service_imp.PutProductos(body);
            return new ResponseEntity<>(putProd,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        if(body.getId_producto() == null){
//            return ResponseEntity.badRequest().body("El id_producto no se esta detectando");
//        }
//        iprod_service.PutProductos(body);
//        return ResponseEntity.ok(iprod_service.findProductos(body.getId_producto()));
    }



    @GetMapping
    public ResponseEntity<List<ProductosEntity>>   GetProductos(){
        return new ResponseEntity<>(iprod_service.getProductos(), HttpStatus.OK)  ;
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

}
