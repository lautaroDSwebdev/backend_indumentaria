package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Productos")
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;
    private String marca;
    private int precio;
    private int stock;
    private int numberoTalle;
    private String color;


    @ManyToOne
    @JoinColumn(name = "categorias_id_producto")
    private CategoriaProductoEntity categorias;
}
