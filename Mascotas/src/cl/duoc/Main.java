/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cl.duoc;

/**
 *
 * @author Compu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Mascota perro1 = new Mascota ("Cholo", "Pedro", 4);
        
        Mascota gato1 = new Mascota();
        gato1.setNombre("Leche");
        gato1.setDuenio("jose");
        gato1.setNumeroPatas(4);
        
        
        
        System.out.println("Datos perro 1: " + perro1.toString());
        
        System.out.println("\nDatos del gato 1: " + gato1.toString());
        
        //se aagregan dos mascotas
        
    }
    
}
