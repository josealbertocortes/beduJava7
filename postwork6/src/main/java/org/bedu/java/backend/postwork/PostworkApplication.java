package org.bedu.java.backend.postwork;

import org.bedu.java.backend.postwork.model.Persona;
import org.bedu.java.backend.postwork.service.FormateadorTelefono;
import org.bedu.java.backend.postwork.service.ValidadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostworkApplication implements CommandLineRunner {

	private final ValidadorTelefono validadorTelefono;
	private final FormateadorTelefono formateadorTelefono;

	@Autowired
	public PostworkApplication(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
		this.validadorTelefono = validadorTelefono;
		this.formateadorTelefono = formateadorTelefono;
	}

	@Override
	public void run(String... args) throws Exception {
		//Scanner lector = new Scanner(System.in);

		//System.out.println("Introduce un nombre: ");
		//String nombre = lector.nextLine();

		//System.out.println("El telefono de " + nombre + " es: ");
		//String tel = lector.nextLine();

		/*if(validadorTelefono.isValido(tel)) {
			tel = validadorTelefono.limpiaNumero(tel);
			tel = formateadorTelefono.formatear(tel);

			Persona persona = new Persona(nombre,tel);
			System.out.println(persona);
		}
		else {
			System.out.println("ERROR, por favor introduce un numero de telefono valido");
		}*/
	}

	public static void main(String[] args) {
		SpringApplication.run(PostworkApplication.class, args);
	}

}
