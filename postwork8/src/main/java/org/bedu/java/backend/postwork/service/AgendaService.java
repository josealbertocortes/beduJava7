package org.bedu.java.backend.postwork.service;

import org.bedu.java.backend.postwork.model.Persona;
import org.bedu.java.backend.postwork.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final ValidadorTelefono validadorTelefono;

    private final FormateadorTelefono formateadorTelefono;
    private final PersonaRepository personaRepository;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono, PersonaRepository personaRepository) {
        this.validadorTelefono = validadorTelefono;
        this.formateadorTelefono = formateadorTelefono;
        this.personaRepository = personaRepository;
    }

    public Persona guardaPersona(Persona persona) {
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());
        persona.setTelefono(telefono);
        return personaRepository.save(persona);
    }

    public List<Persona> getPersonas() {

        //List<Persona> lista = personaRepository.findAll(Sort.by("nombre"));

        return personaRepository.findAll(Sort.by("nombre"));
    }
}
