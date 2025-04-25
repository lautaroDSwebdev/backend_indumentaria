package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PedidoEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long id_pedido;
     private String fecha_pedido;

//     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private List<ProductosEntity> list_prods;
//
//     @OneToOne
//     @JoinColumn(name = "comprador_relacion_id_comprador", referencedColumnName = "id_comprador")
//     private CompradorEntity comprador_relacion;
}
