package com.example.demo.service;

import com.example.demo.entity.CompradorEntity;
import com.example.demo.repo.iCompradorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorServiceImp implements iCompradorService{

    @Autowired
    private iCompradorRepo i_comprarepo;

    @Override
    public List<CompradorEntity> getComprador() {
        List<CompradorEntity> get_comprador = i_comprarepo.findAll();
        return get_comprador;
    }

    @Override
    public void PostComprador(CompradorEntity e) {
        i_comprarepo.save(e);
    }


    @Override
    public Optional<CompradorEntity> getCompradorByCode(Long id) {
        return Optional.empty();
    }

    @Override
    public void DeleteComprador(Long id) {
        i_comprarepo.deleteById(id);
    }

    @Override
    public CompradorEntity findComprador(Long id) {
        CompradorEntity find_comprador = i_comprarepo.findById(id).orElse(null);
        return find_comprador;
    }

    @Override
    public void PutComprador(CompradorEntity e) {
        this.PostComprador(e);
    }
}
