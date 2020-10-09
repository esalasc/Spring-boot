package com.springboot.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.backend.models.entity.Cliente;
import com.springboot.backend.models.services.IClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClienteController {
	
	@Autowired
	IClienteService iClienteService;

	@RequestMapping("/listaClientes")
	public List<Cliente> listaClientes() {
		return iClienteService.findAll();
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return iClienteService.findAll();
	}
	
	@PostMapping("/agregarCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente agregarCliente(@RequestBody Cliente cliente) {
		return iClienteService.save(cliente);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente mostrarCliente(@PathVariable Long id) {
		return iClienteService.findById(id);
	}
	
	@PutMapping("/modificarCliente/{id}")
	public Cliente modificarcliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente cActual =  iClienteService.findById(id);
		cActual.setApellido(cliente.getApellido());
		cActual.setEmail(cliente.getEmail());
		cActual.setNombre(cliente.getNombre());
		return iClienteService.save(cActual);
	}
	
	@DeleteMapping("/eliminarCliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminarCliente(@PathVariable Long id) {
		iClienteService.delete(id);
	}
	

}
