package com.example.demo.repo;

import com.example.demo.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends JpaRepository<ProductosEntity, Long> {

}
