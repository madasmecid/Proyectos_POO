package com.example.gestorflotafx;

public class Furgon extends Vehiculo {

    private double capacidadCargaKg;

    public Furgon() {
    }

    public Furgon(String patente, String marca, String anio, double capacidadCargaKg) {
        super(patente, marca, anio);
        this.capacidadCargaKg = capacidadCargaKg;
    }


    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    @Override
    public String getDetalleEspecifico() {
        return "furgom -- carga: "+ capacidadCargaKg + " kg";
    }
}
