package com.techMahindra.prueba.dao;

import com.techMahindra.prueba.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {


}
