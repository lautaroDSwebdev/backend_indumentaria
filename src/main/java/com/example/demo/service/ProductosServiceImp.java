package com.example.demo.service;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImp implements IProductoService {


    @Autowired
    private IProductoRepo iprod_repo;


    @Override
    public void PostProductos(ProductosEntity prod) {
         iprod_repo.save(prod);
    }

    @Override
    public Page<ProductosEntity> getProductos(int page, int size) {
        Pageable pagin_prod = PageRequest.of(page, size);
        return iprod_repo.findAll(pagin_prod);
    }

    @Override
    public void DeleteProductos(Long id) {
        iprod_repo.deleteById(id);
    }


    @Override
    public void PutProductos(ProductosEntity e)  {
        this.PostProductos(e);
    }


    @Override
    public ProductosEntity findProductos(Long id) {
        ProductosEntity find_prod = iprod_repo.findById(id).orElse(null);
        return find_prod;
    }


}
