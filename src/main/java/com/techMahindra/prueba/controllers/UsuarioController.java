package com.techMahindra.prueba.controllers;

import com.techMahindra.prueba.dao.UsuarioDao;
import com.techMahindra.prueba.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;


    //Retorna listado de usuarios
    @RequestMapping(value="{listado}")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = usuarioDao.findAll();
        return usuarios;
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioDao.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}
