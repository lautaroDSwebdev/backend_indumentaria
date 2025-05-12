package com.example.demo.controller;

import com.example.demo.entity.PedidoEntity;
import com.example.demo.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private IPedidoService ipedido_serv;

    @GetMapping
    public List<PedidoEntity> GetPedidos(){
        return ipedido_serv.getPedido();
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
