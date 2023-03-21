package org.dedu.java.agenda.poswork7.service;

import org.springframework.stereotype.Service;

@Service
public class FormateadorTelefono {
    private static final String formatoInicial = "(\\d{2})(\\d{4})(\\d+)";
    private static final String formatoFinal = "($1)-$2-$3";
    public String formatear(String tel) {
        return String.valueOf(tel).replaceFirst(formatoInicial,formatoFinal);
    }

}
