package com.presentation.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan("com.presentation.andy.service")
//@EntityScan("com.presentation.andy.repository")
public class AndyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndyApplication.class, args);
	}

}
