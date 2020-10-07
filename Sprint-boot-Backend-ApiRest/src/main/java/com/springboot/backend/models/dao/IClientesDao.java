package com.springboot.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.models.entity.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> {

	
}
