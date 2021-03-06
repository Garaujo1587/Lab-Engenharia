package com.p2engenharia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.p2engenharia.model.Hamburguer;
import com.p2engenharia.repository.HamburguerRepository;

@RestController
@RequestMapping("/burger")
@CrossOrigin(origins = {"http://localhost:3001"})
public class HamburguerController {

	@Autowired
	private HamburguerRepository burgerRepository;
	
	@GetMapping
	public List<Hamburguer> listar() {
		return burgerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Hamburguer buscarPeloID(@PathVariable Long id) {
		return burgerRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Hamburguer adicionar(@RequestBody Hamburguer burger) {
		return burgerRepository.save(burger);
	}
	
}
