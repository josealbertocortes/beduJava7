package org.bedu.java.javase2.postwork.persistence;

import org.bedu.java.javase2.postwork.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
