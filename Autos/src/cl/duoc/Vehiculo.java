/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Vehiculo {
    //atributos protetigos
    private String marca;
    private String modelo;
    private int kilometros;
    
    
    //constructor vacio
    
    public Vehiculo (){
        
    }
    
    public Vehiculo (String marca, String modelo, int kilometros){
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public int getKilometros(){
        return kilometros;
    }
    
    public void setKilometros(int kilometros){
        this.kilometros = kilometros;
    }
    
    public void avanzar(int km) {
        if (km > 0) {
            kilometros += km;
            System.out.println("El vehiculo avanza " + km + " kilometros sumando un total de "+ kilometros+ " kilometros.");
    }else {
            System.out.println("El kilometro que debe recorrer debe ser mayor a 0");
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", kilometros=" + kilometros + '}';
    }
    
    
}
