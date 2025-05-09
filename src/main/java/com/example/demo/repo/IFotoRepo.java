package com.example.demo.repo;


import com.example.demo.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoRepo extends JpaRepository<ImageEntity, Long> {
}
