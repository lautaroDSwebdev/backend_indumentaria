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
    private String proveedor;
    private int precio;
    private int stock;
    private int numberoTalle;
    private String color;


    @OneToOne
    @JoinColumn(name = "tabla_categoria_prod", referencedColumnName = "id_categoria")
    private CategoriaProductoEntity categoria_prod;

    @OneToOne
    @JoinColumn(name = "tabla_producto_proveedor", referencedColumnName = "id_proveedor")
    private ProveedorEntity proveedorRelacion;


}
