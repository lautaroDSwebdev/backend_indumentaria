package com.example.demo.controller;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService ipedido_serv;

    @GetMapping("/get")
    public List<PedidoEntity> GetPedidos(){
        return ipedido_serv.getPedido();
    }
    @PostMapping("/post")
    public String PostPedidos(@RequestBody PedidoEntity e){
        ipedido_serv.PostPedido(e);
        return "Pedido creado 👍";
    }
    @DeleteMapping("/del")
    public String DeletePedidos(Long id){
        ipedido_serv.DeletePedido(id);
        return "Pedido eliminado 🚮";
    }
//    @PutMapping("/put")
//    public PedidoEntity PutPedidos(@RequestBody PedidoEntity e){
//        ipedido_serv.PutPedido(e);
//        return ipedido_serv.findPedido(e.getId());
//    }

}
