package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
