package com.example.demo.controller;

import com.example.demo.service.FileUploadServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagesprod")
public class FileUploadProductoController {

    @Autowired
    private FileUploadServiceImp file_service;

    @PutMapping("/prod/{id_producto}")
    public ResponseEntity<?> upload(@PathVariable Long id_producto, @RequestParam("fotoProducto") MultipartFile file){
        return ResponseEntity.ok(file_service.upload(id_producto, file));
    }
}
