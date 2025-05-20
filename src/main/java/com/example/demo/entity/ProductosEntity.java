package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    @JoinColumn(name = "categoria_productos")
    private CategoriaProductoEntity categoriaProds;




}
