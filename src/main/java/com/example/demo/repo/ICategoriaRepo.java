package com.example.demo.repo;

import com.example.demo.entity.CategoriaProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends JpaRepository<CategoriaProductoEntity, Long> {
}
