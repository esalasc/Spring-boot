package com.spring.boot.backend.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.backend.client.entity.Cliente;
import com.spring.boot.backend.client.entity.Curso;
import com.spring.boot.backend.client.service.ICursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

	@Autowired
	ICursoService iCursoService;
	
	@GetMapping("/{id}")
	public Curso consultaCursos(@PathVariable Long id) {
		Curso c =  iCursoService.getById(id);
		return c;
	}
	
	@PostMapping("/agregar")
	public Curso agregaCurso(@RequestBody Curso curso) {
		return iCursoService.agregarcurso(curso);
	}
	
	@GetMapping("/clientes")
	public Cliente[] consultaclientes() {
		return iCursoService.getclientes();
	}
	
}
