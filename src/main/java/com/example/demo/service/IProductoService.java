package com.example.demo.service;

import com.example.demo.entity.ProductosEntity;

import java.util.List;
import java.util.Optional;


public interface IProductoService {
    public List<ProductosEntity> getProductos();
    public Optional<ProductosEntity> getProductosByCode(Long id);
    public void DeleteProductos(Long id);
    public void PostProductos(ProductosEntity e);
    public void PutProductos(ProductosEntity e);
    public ProductosEntity findProductos(Long id);
    public ProductosEntity findProductoById(Long id);
}
