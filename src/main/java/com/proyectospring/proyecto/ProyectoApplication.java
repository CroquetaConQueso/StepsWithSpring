package com.proyectospring.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		/*
		 * Esto hace que:
		 * Arranca el contenedor de Spring (carga beans y dependencias).
		 * 
		 * Procesa configuraciones (application.properties, variables, etc.).
		 * 
		 * Inicia el servidor web (Tomcat por defecto, puerto 8080).
		 * 
		 * Ejecuta tareas iniciales (CommandLineRunner, etc.).
		 * 
		 * Mantiene la app viva hasta que la detengas.
		 * 
		 */
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
