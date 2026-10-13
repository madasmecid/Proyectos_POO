package com.example.gestorflotafx;

public class Auto extends Vehiculo {

    private int cantidadPuertas;

    public Auto() {
    }

    public Auto(String patente, String marca, int anio, int cantidadPuertas) {
        super(patente, marca, anio);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String getDetalleEspecifico() {
        return "Auto - " + cantidadPuertas + " puertas";
    }
}