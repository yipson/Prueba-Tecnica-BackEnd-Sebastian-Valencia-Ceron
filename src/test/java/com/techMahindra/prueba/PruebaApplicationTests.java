package com.techMahindra.prueba;

import com.techMahindra.prueba.domains.Rol;
import com.techMahindra.prueba.domains.Ruleta;
import com.techMahindra.prueba.domains.Usuario;
import com.techMahindra.prueba.service.MesaService;
import com.techMahindra.prueba.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@SpringBootTest
class PruebaApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MesaService mesaService;

	@Test
	public void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		List<Rol> roles = new ArrayList<>();

		rol.setNombre("ROLE_ADMIN");
		roles.add(rol);

		usuario.setNombre("Natalia");
		usuario.setEmail("natalia@mail.com");
		usuario.setPassword("1234");
		usuario.setRoles(roles);

		Usuario usuarioRetorno = usuarioService.save(usuario);

		assertTrue(usuarioRetorno.getPassword().equalsIgnoreCase(usuario.getPassword()));

	}


	@Test
	public void generarResultadoRuleta(){

		Ruleta resultado1 = mesaService.getResultado();
		Ruleta resultado2 = mesaService.getResultado();

		assertFalse(resultado1.toString().equals(resultado2.toString()));
	}

}
