package com.techMahindra.prueba.service;

import com.techMahindra.prueba.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
