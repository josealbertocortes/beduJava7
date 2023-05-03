package org.bedu.java.javase2.postwork.reactive;


import org.bedu.java.javase2.postwork.model.Curso;
import org.bedu.java.javase2.postwork.model.Estudiante;
import org.bedu.java.javase2.postwork.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class CalcularPromedioCursoRxTest {
    private static final Curso CURSO = new Curso();

    static {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombreCompleto("Estudiante Uno");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombreCompleto("Estudiante Dos");

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombreCompleto("Estudiante Tres");

        Materia materia = new Materia();
        materia.setNombre("Materia");

        CURSO.setCiclo("2023");
        CURSO.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante1, 4);
        calificaciones.put(estudiante2, 7);
        calificaciones.put(estudiante3, 8);

        CURSO.setCalificaciones(calificaciones);
    }

    @Test
    @DisplayName("Postwork 5")
    void calculaPromedio(){
        CalcularPromedioCursoRx sut = new CalcularPromedioCursoRx();

        sut.calcularPromedio(CURSO)
                .subscribe(v -> assertThat(v).isEqualTo(7.66, within(0.1)));

    }

}