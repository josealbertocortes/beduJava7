package org.bedu.java.backend.postwork.persistence;
import org.bedu.java.backend.postwork.model.Persona;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
