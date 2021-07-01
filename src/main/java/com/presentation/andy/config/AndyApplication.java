package com.presentation.andy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan("com.presentation.andy.repository")
//
//@EnableJpaRepositories(basePackages = "com.presentation.andy.repository")
//@EntityScan("com.presentation.andy.model")

public class AndyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndyApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(AndyApplication.class);
//        UserRepo userRepo = context.getBean(UserRepo.class);
	}

}
