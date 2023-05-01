package com.acme.sprocket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition
@EnableJpaRepositories(basePackages = {"com.acme.sprocket.*"})
public class AcmeSprocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeSprocketApplication.class, args);
	}

}
