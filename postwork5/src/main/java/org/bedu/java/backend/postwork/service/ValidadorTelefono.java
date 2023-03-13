package org.bedu.java.backend.postwork.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidadorTelefono {

    private static final Pattern patronTel = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");
    public boolean esValido(String tel) {
        return patronTel.matcher(tel).matches();
    }

    public String limpiarTelefono(String tel) {
        return tel.replaceAll("[^0-9]","");
    }
}
