package com.example.proyecto2;

public class Cuestionario {
    private String pin;
    private String nombre;
    private String descripcion;

    public Cuestionario(String pin, String nombre, String descripcion) {
        this.pin = pin;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
