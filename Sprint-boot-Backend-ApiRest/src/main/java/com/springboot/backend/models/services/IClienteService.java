package com.springboot.backend.models.services;

import java.util.List;

import com.springboot.backend.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public Cliente findById(Long id);
}
