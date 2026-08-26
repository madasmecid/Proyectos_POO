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
        
        
       Terrestre gato1 = new Terrestre (4,"leche", "Susan", "San Bernardo");
       
        System.out.println("El nuevo gato se llama " + gato1.getNombre()+ ", su duenia es " + gato1.getDuenio()+ " y es de la ciudad de " + gato1.getCiudad());
        
        gato1.hacerSonido();
        
        gato1.correr();
        
        Volador loro1 = new Volador (2, "Pepito", "Jose", "Penaflor");
        
        System.out.println(loro1.toString());
        
        loro1.hacerSonido();
        
        loro1.volar();
       
        
    }
    
}
