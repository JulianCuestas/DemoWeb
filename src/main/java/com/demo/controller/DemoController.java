package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.PersonaService;

@Controller
public class DemoController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/home")
	public String home(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("listaPersonas", personaService.listarPersonas());
		model.addAttribute("name", name);
		return "index";
	}
	
}
