/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Aereo extends Vehiculo {
    private double distanciaVuelo;

    public Aereo(double distanciaVuelo) {
        this.distanciaVuelo = distanciaVuelo;
    }
    
    

    public Aereo(String nombre, String marca, String modelo, String matricula, double distanciaVuelo) {
        super(nombre, marca, modelo, matricula);
        this.distanciaVuelo = distanciaVuelo;
    }

    public double getDistanciaVuelo() {
        return distanciaVuelo;
    }

    public void setDistanciaVuelo(double distanciaVuelo) {
        this.distanciaVuelo = distanciaVuelo;
    }

    @Override
    public String toString() {
        return "Aereo{"+super.toString()+ " distanciaVuelo=" + distanciaVuelo + '}';
    }
    
    
    public void despegar(){
        System.out.println("Vehiculo " + super.getNombre()+ " "+super.getMarca()+ " despega!!");
    }
    
   
    @Override
    public void mantenimiento() {
        System.out.println("Vehiculo " + super.getNombre()+ " entra en mantenimiento de tren de alas");
    }
    
    
    
}
