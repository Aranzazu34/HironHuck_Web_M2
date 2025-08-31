package com.toyota.coches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.toyota")
public class CochesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CochesApiApplication.class, args);
	}

}
