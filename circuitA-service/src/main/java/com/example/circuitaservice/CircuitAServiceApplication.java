package com.example.circuitaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CircuitAServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitAServiceApplication.class, args);
	}

}
