package com.example.demo.repo;

import com.example.demo.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepo extends JpaRepository<PedidoEntity, Long> {
}
