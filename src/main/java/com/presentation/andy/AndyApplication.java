package com.presentation.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan("com.presentation.andy")
//@EnableJpaRepositories(basePackages = "com.presentation.andy.repository")
//@EntityScan("com.presentation.andy.model")

public class AndyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndyApplication.class, args);
	}
}
