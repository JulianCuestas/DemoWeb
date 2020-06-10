package com.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Persona;
import com.demo.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class RestDemoController {
	
	private Logger LOGGER = LoggerFactory.getLogger(RestDemoController.class);
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public List<Persona> listar() {
		return personaService.listarPersonas();
	}
	
	@PostMapping
	public void insertar(@RequestBody Persona persona) {
		personaService.guardarEditarPersona(persona);
	}
	
	@PutMapping
	public void actualizar(@RequestBody Persona persona) {
		if(persona.getId() != null) {
			personaService.guardarEditarPersona(persona);
		} else {
			LOGGER.error("El id persona no puede ser null.");
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id ) {
		personaService.eliminarPersona(id);
	}
	
}
