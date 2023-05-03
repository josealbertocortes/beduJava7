package org.bedu.java.javase2.postwork.multithreading;

import org.bedu.java.javase2.postwork.model.Curso;

public class CalculadorPromedioCurso implements Runnable{
    private Curso curso;
    private double promedio;
    public CalculadorPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        int numAlumnos = 0;
        for(Integer i : curso.getCalificaciones().values()) {
            promedio += i;
            numAlumnos++;
        }
        promedio /= numAlumnos;

        System.out.println("Promedio del curso: " + curso.getId() + " " + curso.getMateria().getNombre() + " = " + promedio);
    }
}
