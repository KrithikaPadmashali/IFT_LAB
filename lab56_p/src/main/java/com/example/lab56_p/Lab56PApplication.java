package com.example.lab56_p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class Lab56PApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab56PApplication.class, args);
	}

}
