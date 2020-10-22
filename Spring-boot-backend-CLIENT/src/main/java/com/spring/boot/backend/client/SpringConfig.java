package com.spring.boot.backend.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

	@Bean(name = "RestTemplate")
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		System.out.println("Generando Resttemplate.--------------------------...");
		return new RestTemplate();
	}
}
