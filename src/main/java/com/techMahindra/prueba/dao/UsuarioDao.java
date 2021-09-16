package com.techMahindra.prueba.dao;

import com.techMahindra.prueba.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {


}
