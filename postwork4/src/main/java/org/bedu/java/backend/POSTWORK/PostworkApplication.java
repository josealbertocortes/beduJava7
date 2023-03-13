package org.bedu.java.backend.POSTWORK;

import org.bedu.java.backend.POSTWORK.model.Persona;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostworkApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(PostworkApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce el nombre: ");
		String nombre = lector.nextLine();

		System.out.println("Introduce el telefono: ");
		String tel = lector.nextLine();

		Persona persona = new Persona(nombre,tel);

		System.out.println(persona);
	}
}
