package com.example.demo.repo;

import com.example.demo.entity.CompradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCompradorRepo extends JpaRepository<CompradorEntity, Long> {
}
