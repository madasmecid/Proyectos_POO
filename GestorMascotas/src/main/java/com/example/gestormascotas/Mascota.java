package com.example.gestormascotas;

public class Mascota {

    private String  chip;
    private String nombre;
    private String especie;

    public Mascota() {
    }

    public Mascota(String chip, String nombre, String especie) {
        this.chip = chip;
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
