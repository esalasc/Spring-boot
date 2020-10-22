package com.springboot.backend.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	
	private Map<String,Object> respuesta;
	
	@Autowired
	IClienteService iClienteService;
	
	@Value("${server.port}")
	private String puerto;

	@RequestMapping("/listaClientes")
	public List<Cliente> listaClientes() {
		
		return iClienteService.findAll().stream().map(cliente->{
			cliente.setPuerto(puerto);
			return cliente;}).collect(Collectors.toList());
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return iClienteService.findAll();
	}
	
	@PostMapping("/agregarCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> agregarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
		respuesta =  new HashMap<>();
		try {
			if(result.hasErrors()) {
//				List<String> errors = new ArrayList<String>();
//				for(FieldError err: result.getFieldErrors()) {
//					errors.add(err.getField()+"-"+err.getDefaultMessage());
//				}
				List<String> errors =  result.getFieldErrors().stream().map(err ->{
					return "El campo: "+err.getField()+" "+err.getDefaultMessage();
				}).collect(Collectors.toList());
				respuesta.put("errores", errors);
				
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.BAD_REQUEST);
			}
			Cliente clienteNuevo = iClienteService.save(cliente);
			if(clienteNuevo!=null) {
				respuesta.put("mensaje", "Cliente creado con exito");
				respuesta.put("cliente",clienteNuevo);
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
			}else {
				respuesta.put("mensaje", "Error al agregar cliente nuevo."); 
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			}	
		}catch(DataAccessException dEx) {
			respuesta.put("mensaje", "Error al agregar cliente nuevo, "+dEx.getMessage()+", "+dEx.getMostSpecificCause());
			respuesta.put("error", dEx.getMessage());
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> mostrarCliente(@PathVariable Long id) {
		respuesta =  new HashMap<>();
		try {
			Cliente cliente = iClienteService.findById(id);
			if(cliente!=null) {
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);	
			}else {
				respuesta.put("mensaje", "Cliente con ID: "+id+" no encontrado.");			
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);
			}
		}catch(DataAccessException dEx) {
			respuesta.put("mensaje", "Error al consultar cliente.");
			respuesta.put("error", dEx.getMessage());
			return new ResponseEntity<String>("asasas", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificarCliente/{id}")
	public ResponseEntity<?> modificarcliente(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
		respuesta =  new HashMap<>();
		try {
			if(result.hasErrors()) {
				List<String> errors =  result.getFieldErrors().stream().map(err ->{
					return "El campo: "+err.getField()+" "+err.getDefaultMessage();
				}).collect(Collectors.toList());
				respuesta.put("errores", errors);
				
				return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.BAD_REQUEST);
			}
			
			Cliente cActual =  iClienteService.findById(id);
			cActual.setApellido(cliente.getApellido());
			cActual.setEmail(cliente.getEmail());
			cActual.setNombre(cliente.getNombre());
			Cliente  cModif = iClienteService.save(cActual);
			if(cModif!=null) {
				respuesta.put("mensaje", "Cliente actualizado con exito!");
				respuesta.put("cliente", cliente);
				return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.OK);
			}else {
				respuesta.put("mensaje", "Error al actualizar cliente "+id+".");
				return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.OK);
			}
		}catch(DataAccessException dEx) {
			respuesta.put("mensaje", "Error al modificar cliente nuevo, "+dEx.getMessage()+", "+dEx.getMostSpecificCause());
			respuesta.put("error", dEx.getMessage());
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@DeleteMapping("/eliminarCliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
		respuesta =  new HashMap<>();
		try {
			iClienteService.delete(id);
			respuesta.put("mensaje", "cliente eliminado exitosamente!"+id+".");
			return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.OK);
		}catch(DataAccessException dEx) {
			respuesta.put("mensaje", "Error al eliminar cliente.");
			respuesta.put("error", dEx.getMessage());
			return new ResponseEntity<Map<String,Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
