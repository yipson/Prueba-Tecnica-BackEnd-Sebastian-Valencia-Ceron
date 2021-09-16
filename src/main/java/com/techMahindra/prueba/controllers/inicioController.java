package com.techMahindra.prueba.controllers;

import com.techMahindra.prueba.dao.UsuarioDao;
import com.techMahindra.prueba.models.Rol;
import com.techMahindra.prueba.models.Usuario;
import com.techMahindra.prueba.service.RolService;
import com.techMahindra.prueba.service.UsuarioService;
import com.techMahindra.prueba.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RestController
public class inicioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JWTUtil jwtUtil;


    //Realiza el inicio de sesion PATH: localhost:8008/api_login
    //y se retorna el token, id y rol para ser guardados en el navegador
    @RequestMapping(value = "api_login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        String resultado = "";

        Usuario usuarioLogueado =usuarioService.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado != null){
            
            String rolNombre = rolService.getNombreRol(usuarioLogueado);
            String token = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            //Armando respuesta a enviar {Token - Id usuario - Rol usuario}
            resultado = token;
            resultado += "," + String.valueOf(usuarioLogueado.getId());
            resultado += "," + String.valueOf(rolNombre);

            return resultado;
        }
        return "FAIL";
    }
}
