package com.example.fichamedica;

public class Paciente {

    private String rut;
    private String nombre;
    private int edad;
    private double pesoKg;

    public Paciente(String rut, String nombre, int edad, double pesoKg) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.pesoKg = pesoKg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("el nombre no puede ser vacio.");
        }
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
}
