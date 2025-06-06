package com.example.demo.service;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.repo.IPedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private IPedidoRepo ipedido_repo;

    @Override
    public Page<PedidoEntity> getPedido(int page, int size) {
        Pageable pagin_pedido = PageRequest.of(page, size);
        return ipedido_repo.findAll(pagin_pedido);
    }
//    @Override
//    public Page<PedidoEntity> getPedido() {
//        List<PedidoEntity> get_pedido = ipedido_repo.findAll();
//        return get_pedido;
//    }

    @Override
    public void DeletePedido(Long id) {
        ipedido_repo.deleteById(id);
    }

    @Override
    public void PostPedido(PedidoEntity e) {
        ipedido_repo.save(e);
    }

    @Override
    public PedidoEntity findPedido(Long id) {
        PedidoEntity pedido_find = ipedido_repo.findById(id).orElse(null);
        return pedido_find;
    }

    @Override
    public void PutPedido(PedidoEntity e) {
        this.PostPedido(e);
    }
}
