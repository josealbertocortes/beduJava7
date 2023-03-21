package org.dedu.java.agenda.poswork7.controller;

import org.dedu.java.agenda.poswork7.model.Persona;
import org.dedu.java.agenda.poswork7.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class AgendaControler {
    private final AgendaService agendaService;

    @Autowired
    public AgendaControler(AgendaService agendaService) {
        this.agendaService = agendaService;
    }
    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
        return ResponseEntity.ok(agendaService.getPersonas());
    }
    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = agendaService.guardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }
    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("listado", agendaService.getPersonas());
        return "index";
    }
    @PostMapping("/registro")
    public ModelAndView registro(@Valid Persona persona, Errors errors){
        String vistaResultado = "index";
        if (errors.hasErrors()){
            vistaResultado = "index";
        }else{
            agendaService.guardaPersona(persona);
        }
        ModelAndView mav = new ModelAndView(vistaResultado);
        mav.addObject("listado", agendaService.getPersonas());
        return mav;
    }
}
