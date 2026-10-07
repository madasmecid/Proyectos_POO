package com.example.gestorflotafx;

public class Auto extends Vehiculo {

    private int cantidadPuertas;

    public Auto() {
    }

    @Override
    public String getDetalleEspecifico() {
        return "Auto - " + cantidadPuertas + " puertas";
    }

    public Auto(String patente, String marca, String anio, int cantidadPuertas) {
        super(patente, marca, anio);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
}
