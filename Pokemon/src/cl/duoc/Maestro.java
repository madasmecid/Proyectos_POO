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
public class Maestro extends Persona{
    private int medallas;

    public Maestro() {
    }

    public Maestro(int medallas) {
        this.medallas = medallas;
    }

    public Maestro(int medallas, String nombre, int edad, ArrayList<Pokemon> pokemones) {
        super(nombre, edad, pokemones);
        this.medallas = medallas;
    }

    public int getMedallas() {
        return medallas;
    }

    public void setMedallas(int medallas) {
        this.medallas = medallas;
    }

    @Override
    public String toString() {
        return "Maestro{" + "medallas=" + medallas + '}';
    }
    
    
}
