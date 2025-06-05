package com.example.demo.service;

import com.example.demo.entity.CompradorEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface iCompradorService {
    public Page<CompradorEntity> getComprador(int page, int size );
    public void DeleteComprador(Long id);
    public void PostComprador(CompradorEntity e);
    public void PutComprador(CompradorEntity e);
    public CompradorEntity findComprador(Long id);
}
