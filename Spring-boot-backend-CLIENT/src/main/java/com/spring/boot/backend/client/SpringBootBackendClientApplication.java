package com.spring.boot.backend.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
//@RibbonClient(name="springboot-clientes")
@EnableFeignClients
@SpringBootApplication
public class SpringBootBackendClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendClientApplication.class, args);
	}

}
