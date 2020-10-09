package com.springboot.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.models.entity.Cliente;
import com.springboot.backend.models.services.IClienteService;

@SpringBootApplication
@RestController
public class SprintBootBackendApiRestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SprintBootBackendApiRestApplication.class, args);
	}
	
	@RequestMapping("saludar")
	public String saludo() {
		return "Hola mundo";
	}	

}
