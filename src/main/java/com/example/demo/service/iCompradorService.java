package com.example.demo.service;

import com.example.demo.entity.CompradorEntity;

import java.util.List;
import java.util.Optional;

public interface iCompradorService {
    public List<CompradorEntity> getComprador();
    public void DeleteComprador(Long id);
    public void PostComprador(CompradorEntity e);
    public void PutComprador(CompradorEntity e);
    public CompradorEntity findComprador(Long id);
}
