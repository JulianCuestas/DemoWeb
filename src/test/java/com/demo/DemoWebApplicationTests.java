package com.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.model.Usuario;
import com.demo.repository.IUsuarioRepo;

@SpringBootTest
class DemoWebApplicationTests {
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void crearUsuarioTest() {
		Usuario user = new Usuario();
		
		user.setNombre("admin"+Math.random()*9);
		user.setClave(encoder.encode("12345"));//Se codifica la cadena para que no sea legible a simple vista
		Usuario userReturn = usuarioRepo.save(user);
		
		//Validar el flujo de entrada y salida, en este caso clave que se inserta con la que retorna
		assertTrue(userReturn.getClave().equals(user.getClave()));
	}

}
