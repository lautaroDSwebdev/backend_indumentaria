package com.example.demo.controller;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService ipedido_serv;

    @GetMapping
    public  ResponseEntity<Page<PedidoEntity>> GetPedidos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<PedidoEntity> pedidos_get = ipedido_serv.getPedido(page, size);
        return ResponseEntity.ok(pedidos_get);
    }

    @PostMapping
    public String PostPedidos(@RequestBody PedidoEntity e){
        ipedido_serv.PostPedido(e);
        return "Pedido creado 👍";
    }
    @DeleteMapping("/{id}")
    public String DeletePedidos(@PathVariable Long id){
        ipedido_serv.DeletePedido(id);
        return "Pedido eliminado 🚮";
    }
    @PutMapping
    public ResponseEntity<?>  PutPedidos(@RequestBody PedidoEntity body){
        if(body.getIdPedido() == null){
            return ResponseEntity.badRequest().body("El id_pedido no se esta detectando");
        }
        ipedido_serv.PutPedido(body);
        return ResponseEntity.ok(ipedido_serv.findPedido(body.getIdPedido()));
    }

}
