/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public abstract class Mascota {
    
    private String nombre;
    private String duenio;
    private String ciudad;
    
    public Mascota(){
        
    }

    public Mascota(String nombre, String duenio, String ciudad) {
        this.nombre = nombre;
        this.duenio = duenio;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", duenio=" + duenio + ", ciudad=" + ciudad + '}';
    }
    
    
    abstract void hacerSonido();

    
    
    

   
    
    
   

    
    
    
    
   
    
}
