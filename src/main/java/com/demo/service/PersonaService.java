package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Persona;
import com.demo.repository.IPersonaRepo;

@Service
public class PersonaService {
	
	@Autowired
	private IPersonaRepo personaRepo;
	
	public List<Persona> listarPersonas() {
		return personaRepo.findAll();
	}
	
	public void guardarEditarPersona(Persona persona) {
		personaRepo.save(persona);
	}
	
	public void eliminarPersona(Integer id) {
		personaRepo.deleteById(id);
	}
}
