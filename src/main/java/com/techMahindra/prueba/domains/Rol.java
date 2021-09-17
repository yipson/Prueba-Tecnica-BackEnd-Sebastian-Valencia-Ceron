package com.techMahindra.prueba.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "nombre")
    private String nombre;
}
