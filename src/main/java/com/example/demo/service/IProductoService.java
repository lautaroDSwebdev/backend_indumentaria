package com.example.demo.service;

import com.example.demo.entity.ProductosEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface IProductoService {
    public List<ProductosEntity> getProductos();
    public Optional<ProductosEntity> getProductosById(Long id);
    public void DeleteProductos(ProductosEntity prod)throws IOException;
    public ProductosEntity saveProductos(ProductosEntity prod, MultipartFile file) throws IOException;
    public ProductosEntity PutProductos(ProductosEntity e);
    public ProductosEntity findProductos(Long id);
    public ProductosEntity findProductoById(Long id);
    public ProductosEntity updateProductoImage(MultipartFile file, ProductosEntity prod) throws IOException;
}
