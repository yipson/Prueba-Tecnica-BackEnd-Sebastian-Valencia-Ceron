package com.techMahindra.prueba.service;

import com.techMahindra.prueba.dao.UsuarioDao;
import com.techMahindra.prueba.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    EntityManager entityManager;

    //Retorna los usuarios
    @Override
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    //Almacena el Usuario y encripta la contraseña
    @Override
    public void save(Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.save(usuario);
    }

    //Obtener Usuario con las credenciales para hacer login
    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        //Recuperamos usuarios de la base de datos
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> usuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        //Captura excepcion si el registro no fue encontrado
        if (usuarios.isEmpty()){
            return null;
        }

        String passwordHashed = usuarios.get(0).getPassword();

        //Compara hash con password y retornamos usuario
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())){
            return usuarios.get(0);
        }
        return null;
    }




}
