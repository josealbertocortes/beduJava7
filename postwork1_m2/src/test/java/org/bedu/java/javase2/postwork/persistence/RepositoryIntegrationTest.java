package org.bedu.java.javase2.postwork.persistence;

import org.bedu.java.javase2.postwork.model.Curso;
import org.bedu.java.javase2.postwork.model.Estudiante;
import org.bedu.java.javase2.postwork.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.java.javase2.postwork")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryIntegrationTest {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @BeforeAll
    void cleanDatabases() {
        cursoRepository.deleteAll();
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();
    }

    @Test
    @DisplayName("Pruebas unitarias")
    void pruebasUnitarias() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Pedro Pascal");
        estudianteRepository.save(estudiante);

        Materia materia = new Materia();
        materia.setNombre("Matematicas");
        materiaRepository.save(materia);

        Curso curso = new Curso();
        curso.setCiclo("2023");
        curso.setMateria(materia);
        Map<Estudiante,Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante, Curso.NO_CALIFICADO);
        curso.setCalificaciones(calificaciones);
        cursoRepository.save(curso);

        assertNotNull(estudiante.getId());
        assertNotNull(materia.getId());
        assertNotNull(curso.getId());
    }
}