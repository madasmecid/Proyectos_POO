/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionvehiculos;

/**
 *
 * @author Compu
 */
public abstract class Vehiculo {
    
    private String patente;
    private double precioBase;
    
    abstract public double calcularPrecioFinal();
    
    
    public void mostrarDatos(){
        System.out.println(getPatente() + " -- " + getPrecioBase());
    }

    public Vehiculo() {
    }

    public Vehiculo(String patente, double precioBase) {
        setPatente(patente);
        setPrecioBase(precioBase);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if(patente == null || patente.trim().isEmpty()){
            throw new IllegalArgumentException("Patente no puede ser nulo ni quedar vacio");
        }
        this.patente = patente;
    }

    public double getPrecioBase() {
        if(precioBase < 0){
            throw new IllegalArgumentException("El precio base no puede ser menor a 0");
        }
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    
    
}
