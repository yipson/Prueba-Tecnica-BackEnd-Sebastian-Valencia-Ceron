package com.techMahindra.prueba.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "disponible")
    private Character disponible;


    @Getter @Setter
    @Column(name = "apuesta")
    private Double apuesta;

    @Getter @Setter
    @Column(name = "resultado_usuario")
    private String resultadoUsuario;

    @Getter @Setter
    @Column(name = "resultado_final")
    private String resultadoFinal;

    @Getter @Setter
    @Column(name = "recaudo_mesa")
    private Double recaudoMesa;

    @Getter @Setter
    @Column(name = "recaudo_usuario")
    private Double recauUsuario;

    @Getter @Setter
    @Column(name = "usuario_gano")
    private Character usuarioGano;
}
