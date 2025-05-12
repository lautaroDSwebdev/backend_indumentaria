package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idComprador;
    private String nombreComprador;
    private String apellidoComprador;
    private Number dniComprador;
    private Number numTarjeta;
    private String fotoComprador;
}
