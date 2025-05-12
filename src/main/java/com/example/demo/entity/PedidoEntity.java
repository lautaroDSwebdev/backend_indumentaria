package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PedidoEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long idPedido;
     private String fechaPedido;
     private boolean seniaPagada;
     private String horaAbre;
     private String horaAierre;
     private String locacionTienda;

     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<ProductosEntity> listProds;

     @OneToOne
     @JoinColumn(name = "comprador_relacion_id_comprador", referencedColumnName = "idComprador")
     private CompradorEntity compradorRelacion;
}
