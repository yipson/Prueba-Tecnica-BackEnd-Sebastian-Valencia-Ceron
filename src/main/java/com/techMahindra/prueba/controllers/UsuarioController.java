package com.techMahindra.prueba.controllers;

import com.techMahindra.prueba.domains.Usuario;
import com.techMahindra.prueba.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Retorna listado de usuarios PATH: localhost:8080/api_usuario/listado
    @RequestMapping(value="{listado}", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    //Inserta usuario PATH: http://localhost:8080/api_usuario/create
    @RequestMapping(value = "{create}", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

}
