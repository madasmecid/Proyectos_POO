/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SB-Alumno
 */
public abstract class Persona {
    private String nombre; 
    private int edad;
    private ArrayList<Pokemon> pokemones;

    public Persona() {
    }

    public Persona(String nombre, int edad, ArrayList<Pokemon> pokemones) {
        this.nombre = nombre;
        this.edad = edad;
        this.pokemones = pokemones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setPokemones(ArrayList<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", pokemones=" + pokemones + '}';
    }

    public boolean atrapar(Pokemon poke){
       
                System.out.println("Pokemones vacios...");
                System.out.println("insertando....");
                pokemones.add(poke);
                return true;
           
    }
    
    public boolean buscarPokemon(String nombrePokemon){
        if (pokemones.isEmpty()) {
            System.out.println("No tengo pokemones...");
            return false;
        }else{
            for (Pokemon poke:pokemones) {
            if (poke.getNombre().equals(nombrePokemon)) {
                return true;
                }
            }
        }
        
        return false;
    }
    
    // TAREA PARA LA CASA... 
    public boolean liberarPokemon(String nombrePokemon){
        if (pokemones.isEmpty()){
            System.out.println("No hay pokemones para liberar");
            return false;
        }
        for (int i = 0; i < pokemones.size(); i++ ){
            if(pokemones.get(i).getNombre().equals(nombrePokemon)){
                System.out.println("Se libera pokemon: " + pokemones.get(i));
                pokemones.remove(i);
                return true;
                
            }
            
        }
        return false;
    }
}
    


    
            
        
    

