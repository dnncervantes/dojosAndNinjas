package com.dannielcervantes.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dannielcervantes.dojosandninjas.models.Dojo;
import com.dannielcervantes.dojosandninjas.models.Ninja;
import com.dannielcervantes.dojosandninjas.services.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	//Create new Dojo 1. Render Form 2. Process Form
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo")Dojo dojo) {
		return "newDojoForm.jsp";
	}
	
	//Process Dojo Form
	@PostMapping("/dojos/new")
	public String processDojoForm(@Valid @ModelAttribute("dojo")Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDojoForm.jsp";
		} else {
			mainService.createDojo(dojo);
			return "redirect:/";
		}
	}
	//====================================
	// Create a new Ninja. Render Form
	@GetMapping("/ninjas/new")
	public String NinjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> allDojos = mainService.allDojos();
		model.addAttribute("dojos", allDojos);
		return "newNinjaForm.jsp";
	}

	//Process Ninja Form
	@PostMapping("/ninjas/new")
	public String precessNinjaForm(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", mainService.allDojos());
			return "newNinjaForm.jsp";
		} else {
			mainService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	//===============SHOW PAGE===================
	// Find one dojo
	@GetMapping("/dojos/{id}")
	public String showOneDojo(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", mainService.findOneDojo(id));
		return "showNinjas.jsp";
	}
	
	//
	
}
