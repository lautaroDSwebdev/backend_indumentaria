package com.example.demo.service;

import com.example.demo.entity.ProductosEntity;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;


public interface IProductoService {
    public Page<ProductosEntity> getProductos(int page, int size);
    public void DeleteProductos(Long id) ;
    public void PostProductos(ProductosEntity prod) ;
    public void PutProductos(ProductosEntity e);
    public ProductosEntity findProductos(Long id);
}
