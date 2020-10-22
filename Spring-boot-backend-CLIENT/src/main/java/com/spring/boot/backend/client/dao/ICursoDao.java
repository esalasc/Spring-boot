package com.spring.boot.backend.client.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.backend.client.entity.Cliente;
import com.spring.boot.backend.client.entity.Curso;


public interface ICursoDao extends CrudRepository<Curso, Long> {

	
}
