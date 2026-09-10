/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cl.duoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SB-Alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon("Pikachu", true, List.of("Electrico", "Luchador"), 50);
        Pokemon pokemon2 = new Pokemon("Gengar", false, List.of("Fantasma"), 100);
        Pokemon pokemon3 = new Pokemon("Gastly", false, List.of("Fantasma", "Siniestro"), 90);
        
        Maestro maestro1 = new Maestro(4, "Brock", 20,
                new ArrayList<>());
        
        System.out.println(maestro1.getPokemones());
        
        System.out.println(maestro1.buscarPokemon("Pikachu"));
        System.out.println(maestro1.atrapar(pokemon1));
        System.out.println(maestro1.atrapar(pokemon3));

        System.out.println(maestro1.getPokemones());
        
        for (Pokemon poke:maestro1.getPokemones()) {
            System.out.println(poke.toString());
   
        }
        
        maestro1.liberarPokemon("Pikachu");
        
        for (Pokemon poke:maestro1.getPokemones()) {
            System.out.println(poke.toString());
        
    }
    }
}
