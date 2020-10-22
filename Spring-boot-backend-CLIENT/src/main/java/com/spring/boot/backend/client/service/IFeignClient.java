package com.spring.boot.backend.client.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.backend.client.entity.Cliente;

@FeignClient(name = "springboot-clientes")
public interface IFeignClient {

	@GetMapping("api/listaClientes")
	public Cliente[] obtenerClientes();
			
}
