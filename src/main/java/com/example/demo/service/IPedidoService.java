package com.example.demo.service;


import com.example.demo.entity.PedidoEntity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {

     public Page<PedidoEntity> getPedido(int page, int size);
    public void DeletePedido(Long id);
    public void PostPedido(PedidoEntity e);
    public void PutPedido(PedidoEntity e);
    public PedidoEntity findPedido(Long id);
}
