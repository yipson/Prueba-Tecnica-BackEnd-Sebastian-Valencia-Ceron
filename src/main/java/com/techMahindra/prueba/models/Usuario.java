package com.techMahindra.prueba.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;


    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "numero")
    @Getter @Setter
    private String numero;
}
