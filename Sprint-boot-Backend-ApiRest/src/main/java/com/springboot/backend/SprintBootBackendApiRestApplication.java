package com.springboot.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
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
