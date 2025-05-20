package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedidos")
public class PedidoEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long idPedido;
     private String fechaPedido;
     private boolean seniaPagada;
     private String horaDespacho;
     private String horaLlegada;
     private String locacionTienda;

     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<ProductosEntity> listProds;

//     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private List<ProveedorEntity> listProveedor;

     @OneToOne
     @JoinColumn(name = "comprador_relacion_id_comprador", referencedColumnName = "idComprador")
     private CompradorEntity compradorRelacion;
}
