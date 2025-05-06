package com.example.demo.service;

import com.example.demo.entity.CompradorEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImp implements IProductoService{


    @Autowired
    private IProductoRepo iprod_repo;

    @Override
    public List<ProductosEntity> getProductos() {
        List<ProductosEntity> get_prod = iprod_repo.findAll();
        return get_prod;
    }

    @Override
    public Optional<ProductosEntity> getProductosByCode(Long id) {
        return Optional.empty();
    }

    @Override
    public void DeleteProductos(Long id) {
        iprod_repo.deleteById(id);
    }

    @Override
    public void PostProductos(ProductosEntity e) {
        iprod_repo.save(e);
    }

    @Override
    public void PutProductos(ProductosEntity e) {
        this.PostProductos(e);
    }

    @Override
    public ProductosEntity findProductos(Long id) {
        ProductosEntity find_prod = iprod_repo.findById(id).orElse(null);
        return find_prod;

    }
}
