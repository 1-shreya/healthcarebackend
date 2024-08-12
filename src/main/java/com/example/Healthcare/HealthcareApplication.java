package com.example.Healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.Healthcare.Entity")
public class HealthcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);
	}

}
