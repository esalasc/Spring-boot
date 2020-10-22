package com.spring.boot.backend.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.backend.client.dao.ICursoDao;
import com.spring.boot.backend.client.entity.Cliente;
import com.spring.boot.backend.client.entity.Curso;

@Service
public class CursoService implements ICursoService {

	@Autowired
	ICursoDao iCursoDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Curso getById(Long id) {
		
		return iCursoDao.findById(id).orElse(null);
	}

	@Override
	public Curso agregarcurso(Curso curso) {
		return iCursoDao.save(curso);
	}

	@Override
	public Cliente[] getclientes() {
//		RestTemplate restTemplate =  new RestTemplate();
		System.out.println("--------------CLIENT RESTTEMPLATE");
		ResponseEntity<Cliente[]> lista = restTemplate.getForEntity("http://localhost:8086/api/listaClientes",Cliente[].class);
		return lista.getBody();
	}
	
}
