package org.bedu.java.backend.postwork.persistence;

import org.bedu.java.backend.postwork.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
