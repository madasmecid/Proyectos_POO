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
public class Profesor extends Persona{
    private String region;

    public Profesor() {
    }

    public Profesor(String region) {
        this.region = region;
    }

    public Profesor(String region, String nombre, int edad, ArrayList<Pokemon> pokemones) {
        super(nombre, edad, pokemones);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Profesor{" + "region=" + region + '}';
    }
    
    
}
