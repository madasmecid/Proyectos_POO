/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Mascota {
    
    private String nombre;
    private String duenio;
    private int numeroPatas;
    
    
    public Mascota(){
        
    }

    public Mascota(String nombre, String dueño, int numeroPatas) {
       this.nombre = nombre;
       this.duenio = duenio;
       this.numeroPatas = numeroPatas;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDuenio(){
        return duenio;
    }
    
    public void setDuenio(String duenio){
        this.duenio = duenio;
    }
    
    public int getNumeroPatas(){
        return numeroPatas;
    }
    
    public void setNumeroPatas(int numeroPatas){
        this.numeroPatas = numeroPatas;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", duenio=" + duenio + ", numeroPatas=" + numeroPatas + '}';
    }
    
    
    
    
   
    
}
