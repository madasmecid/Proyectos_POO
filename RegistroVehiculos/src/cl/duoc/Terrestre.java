/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Terrestre extends Vehiculo {
    private int numeroRuedas;

    public Terrestre(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }
    
    
 
    public Terrestre(String nombre, String marca, String modelo, String matricula, int numeroRuedas) {
        super(nombre, marca, modelo, matricula);
        this.numeroRuedas = numeroRuedas;
    }
    
    public int getNumeroRuedas(){
        return numeroRuedas;
    }
    
    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    @Override
    public String toString() {
        return "Terrestre{"+super.toString() + " numeroRuedas=" + numeroRuedas + '}';
    }
    
    public void detenerSemaforo(){
        System.out.println("Vehiculo " + super.getNombre()+ " se detiene en el semaforo correctamente");
    }    
    

    @Override
    public void mantenimiento() {
        System.out.println("Vehiculo " + super.getNombre()+ " entro en mantenimiento de ruedas.");
    }
    
    
}
