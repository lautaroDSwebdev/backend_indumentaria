package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImp implements IProductoService{


    @Autowired
    private IProductoRepo iprod_repo;

    @Autowired
    private IFotoService image_service;


    public ProductosServiceImp(IFotoService image_service, IProductoRepo iprod_repo) {
        this.image_service = image_service;
        this.iprod_repo = iprod_repo;
    }



    @Override
    public List<ProductosEntity> getProductos() {
        List<ProductosEntity> get_prod = iprod_repo.findAll();
        return get_prod;
    }

    @Override
    public Optional<ProductosEntity> getProductosById(Long id) {
        return Optional.empty();
    }
    @Override
    public ProductosEntity saveProductos(ProductosEntity prod, MultipartFile file) throws IOException {
        if(file != null & !file.isEmpty()){
            ImageEntity img  = image_service.uploadImage(file);
            prod.setImagen_producto(img);
        }
        return iprod_repo.save(prod);
    }

    @Override
    public void DeleteProductos(ProductosEntity prod) throws IOException {
        if(prod.getImagen_producto() != null ){
            image_service.deleteImage(prod.getImagen_producto());
        }
        iprod_repo.deleteById(prod.getId_producto());
    }


    @Override
    public ProductosEntity PutProductos(ProductosEntity e) {
        return iprod_repo.save(e);
    }


    @Override
    public ProductosEntity findProductos(Long id) {
        ProductosEntity find_prod = iprod_repo.findById(id).orElse(null);
        return find_prod;

    }

    @Override
    public ProductosEntity findProductoById(Long id) {
        return iprod_repo.findById(id).orElse(null);
    }


    @Override
    public ProductosEntity updateProductoImage(MultipartFile file, ProductosEntity prod) throws IOException {
        if(prod.getImagen_producto() != null ){
            image_service.deleteImage(prod.getImagen_producto());
        }
        ImageEntity new_image = image_service.uploadImage(file);
        prod.setImagen_producto(new_image);
        return iprod_repo.save(prod);
    }

}
