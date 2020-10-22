package com.spring.boot.backend.client.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.boot.backend.client.entity.Cliente;
import com.spring.boot.backend.client.entity.Curso;

public interface ICursoService {
	
	public Curso getById(Long id);

	public Curso agregarcurso(Curso curso);
	
	public  Cliente[] getclientes();
}
