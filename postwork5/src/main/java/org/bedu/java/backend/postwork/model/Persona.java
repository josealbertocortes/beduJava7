package org.bedu.java.backend.postwork.model;

public class Persona {
    private String nombre;
    private String tel;

    public Persona() {

    }

    public Persona(String nombre, String tel) {
        this.nombre = nombre;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Persona{" + nombre + '\'' + ", telefono='" + tel + '\'' + '}';
    }
}
