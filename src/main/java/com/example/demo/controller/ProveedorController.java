package com.example.demo.controller;

import com.example.demo.entity.CompradorEntity;
import com.example.demo.entity.ProductosEntity;
import com.example.demo.entity.ProveedorEntity;
import com.example.demo.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {


    @Autowired
    private IProveedorService iprov_serv;

    @PostMapping
    public String PostProductos(@RequestBody ProveedorEntity body) {
        iprov_serv.PostProveedor(body);
        return "Proveedor creado ✅";

    }

    @DeleteMapping("/{id}")
    public String DeleteProveedor(@PathVariable Long id) {
        iprov_serv.DeleteProveedor(id);
        return "Proveedor eliminado 🗑";
    }

    @PutMapping
    public ProveedorEntity PutProveedor(@RequestBody ProveedorEntity body) {
        iprov_serv.PutProveedor(body);
        return iprov_serv.findProveedor(body.getId_proveedor());
    }

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> GetProveedor() {
        return new ResponseEntity<>(iprov_serv.getProveedor(), HttpStatus.OK);
    }

    @GetMapping("/{id_prov}")
    public ResponseEntity<?> GetProveedor(@PathVariable Long id_prov) {
        for (ProveedorEntity e : iprov_serv.getProveedor()) {
            if (e.getId_proveedor().equals(id_prod)) {
                return ResponseEntity.ok(e);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la data");
    }
}
