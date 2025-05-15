package com.example.demo.service;

import com.example.demo.entity.CategoriaProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ICategoriaProdService {
    public List<CategoriaProductoEntity> getCategoria();

    public Optional<CategoriaProductoEntity> getCategoriaByCode(Long id);

    public void DeleteCategoria(Long id);

    public void PostCategoria(CategoriaProductoEntity e);

    public void PutCategoria(CategoriaProductoEntity e);

    public CategoriaProductoEntity findCategoria(Long id);
}
