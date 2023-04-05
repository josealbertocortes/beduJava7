package org.bedu.java.javase2.postwork.persistence;

import org.bedu.java.javase2.postwork.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
