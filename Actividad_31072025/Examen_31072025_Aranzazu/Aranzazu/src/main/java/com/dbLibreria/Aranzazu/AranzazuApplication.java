package com.dbLibreria.Aranzazu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AranzazuApplication {

	public static void main(String[] args) {
		SpringApplication.run(AranzazuApplication.class, args);

		GestorLibreria gLibreria = new GestorLibreria();

		gLibreria.gestorLibreria();
	}

}
