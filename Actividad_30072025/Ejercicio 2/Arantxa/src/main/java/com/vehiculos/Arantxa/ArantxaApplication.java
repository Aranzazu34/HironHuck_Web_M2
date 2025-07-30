package com.vehiculos.Arantxa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArantxaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArantxaApplication.class, args);


		GestorVehiculos consulta1 = new GestorVehiculos();

		consulta1.gestorVehiculos();		
	}

}
