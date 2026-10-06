package com.example.fichamedica;

public class Paciente {

    private String rut;
    private String nombre;
    private int edad;
    private double pesoKg;
    private int numHijos;

    public Paciente(String nombre, String rut, int edad, double pesoKg, int numHijos) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.pesoKg = pesoKg;
        this.numHijos = numHijos;
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

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
}
