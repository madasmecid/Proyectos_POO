package com.example.gestorflotafx;


public abstract class Vehiculo {

    private String patente;
    private String marca;
    private String anio;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String marca, String anio) {
        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public abstract String getDetalleEspecifico();
}
