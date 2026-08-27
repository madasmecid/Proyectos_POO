/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public abstract class  Vehiculo {
    
    private String nombre, marca, modelo, matricula;
    
    public Vehiculo (){
        
    }

    public Vehiculo(String nombre, String marca, String modelo, String matricula) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
    
    
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + '}';
    }
    
    
    
   abstract public void mantenimiento();
    
}
