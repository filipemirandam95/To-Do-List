package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

/**
 * Projeto Spring Boot gerado via Spring Initializr. Os seguintes módulos foram
 * selecionados: - Spring Data JPA - Spring Web - H2 Database - OpenFeign
 * 
 * @author Filipe Miranda
 */

@EnableFeignClients
@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
