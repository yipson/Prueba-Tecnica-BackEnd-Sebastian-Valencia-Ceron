package com.techMahindra.prueba.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "email")
    private String email;


    @Getter @Setter
    @Column(name = "password")
    private String password;

    //Foreign Key a entidad Rol
    @Getter @Setter
    @OneToMany(targetEntity = Rol.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private List<Rol> roles;


    //Foreign Key a entidad Mesa
    @Getter @Setter
    @OneToMany(targetEntity = Mesa.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jugador", referencedColumnName = "id")
    private List<Mesa> mesas;

}
