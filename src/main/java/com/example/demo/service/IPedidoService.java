package com.example.demo.service;


import com.example.demo.entity.PedidoEntity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PUBLIC)
 public interface IPedidoService {

     List<PedidoEntity>  getPedido();
     Optional<PedidoEntity> getPedidoByCode(Long id);
     void DeletePedido(Long id);
     void PostPedido(PedidoEntity e);
     PedidoEntity findPedido(Long id);
     void PutPedido(PedidoEntity e);
}
