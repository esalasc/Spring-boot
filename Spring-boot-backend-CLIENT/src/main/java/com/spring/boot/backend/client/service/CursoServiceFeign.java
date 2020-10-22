package com.spring.boot.backend.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring.boot.backend.client.entity.Cliente;
import com.spring.boot.backend.client.entity.Curso;

@Service
@Primary
public class CursoServiceFeign implements ICursoService {

	@Autowired
	private IFeignClient clienteFeign;
	
	@Override
	public Curso getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso agregarcurso(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente[] getclientes() {
		System.out.println("--------------CLIENT FEIGN");
		return clienteFeign.obtenerClientes();
	}

}
