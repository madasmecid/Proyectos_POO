/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallermecanicoautofix;

/**
 *
 * @author SB-Alumno
 */
public abstract class Vehiculo {
    private String marca;
    private int annioFabricacion;
    private double kilometraje;
    private double costoBase;

    public Vehiculo() {
    }

    public Vehiculo(String marca, int annioFabricacion, double kilometraje) {
        setMarca(marca);
        setAnnioFabricacion(annioFabricacion);
        setKilometraje(kilometraje);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if(marca == null || marca.trim().isEmpty()){
            throw new IllegalArgumentException("Marca no puede ser nula ni vacía.");
        }
        this.marca = marca;
    }

    public int getAnnioFabricacion() {
        return annioFabricacion;
    }

    public void setAnnioFabricacion(int annioFabricacion) {
        if(annioFabricacion < 1990 || annioFabricacion > 2026){
            throw new IllegalArgumentException("Annio de fabricación debe encontrarse entre 1990 y 2026");
        }
        this.annioFabricacion = annioFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        if(kilometraje <= 0){
            throw new IllegalArgumentException("Kilometraje debe ser un valor mayor que 0");
        }
        this.kilometraje = kilometraje;
    }
    
    @Override
    public String toString() {
        return "marca: " + marca + " | anio=" + annioFabricacion;
    }
    
    
    
    abstract public double calcularCosto(); 
    
    
    
}
