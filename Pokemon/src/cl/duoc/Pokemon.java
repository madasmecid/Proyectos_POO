/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.duoc;

import java.util.List;

/**
 *
 * @author SB-Alumno
 */
public class Pokemon {
    private String nombre; 
    private boolean isShiny;
    private List<String> poderes;
    private int level;

    public Pokemon() {
    }

    public Pokemon(String nombre, boolean isShiny, List<String> poderes, int level) {
        this.nombre = nombre;
        this.isShiny = isShiny;
        this.poderes = poderes;
        this.level = level;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isIsShiny() {
        return isShiny;
    }

    public void setIsShiny(boolean isShiny) {
        this.isShiny = isShiny;
    }

    public List<String> getPoderes() {
        return poderes;
    }

    public void setPoderes(List<String> poderes) {
        this.poderes = poderes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", isShiny=" + isShiny + ", poderes=" + poderes + ", level=" + level + '}';
    }
    
    
}
