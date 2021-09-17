package com.techMahindra.prueba.service;

import com.techMahindra.prueba.domains.Rol;
import com.techMahindra.prueba.domains.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RolServiceImp implements  RolService{

    @Autowired
    private EntityManager entityManager;


    //Retorna el rol del usuario quien se logueo
    @Override
    public String getNombreRol(Usuario usuarioLogueado) {
        String query = "FROM Rol where id_usuario = :idUsuario";
        List<Rol> roles = entityManager.createQuery(query)
                .setParameter("idUsuario", usuarioLogueado.getId())
                .getResultList();

        return roles.get(0).getNombre();
    }
}
