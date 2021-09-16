package com.techMahindra.prueba.service;

import com.techMahindra.prueba.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    void save(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
