package com.example.demo.service;

import com.example.demo.entity.ProductosEntity;

import java.io.IOException;
import java.util.List;


public interface IProductoService {
    public List<ProductosEntity> getProductos();
    public void DeleteProductos(Long id) ;
    public void PostProductos(ProductosEntity prod) ;
    public void PutProductos(ProductosEntity e);
    public ProductosEntity findProductos(Long id);
}
