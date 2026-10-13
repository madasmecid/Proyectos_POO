package com.example.gestorflotafx;

public abstract class Vehiculo {

    private String patente;
    private String marca;
    private int anio;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String marca, int anio) {
        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public abstract String getDetalleEspecifico();
}