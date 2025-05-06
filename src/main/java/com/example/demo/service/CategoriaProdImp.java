package com.example.demo.service;

import com.example.demo.entity.CategoriaProductoEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.repo.ICategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProdImp implements ICategoriaProdService{

    @Autowired
    private ICategoriaRepo i_categRepo;

    @Override
    public List<CategoriaProductoEntity> getCategoria() {
        List<CategoriaProductoEntity> getCateg = i_categRepo.findAll();
        return getCateg;
    }

    @Override
    public Optional<CategoriaProductoEntity> getCategoriaByCode(Long id) {
        return Optional.empty();
    }

    @Override
    public void DeleteCategoria(Long id) {
        i_categRepo.deleteById(id);
    }

    @Override
    public void PostCategoria(CategoriaProductoEntity e) {
        i_categRepo.save(e);
    }

    @Override
    public void PutCategoria(CategoriaProductoEntity e) {
        this.PostCategoria(e);
    }

    @Override
    public CategoriaProductoEntity findCategoria(Long id) {
        CategoriaProductoEntity find_categ = i_categRepo.findById(id).orElse(null);
        return find_categ;
    }
}
