/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallermecanicoautofix;

/**
 *
 * @author SB-Alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorTaller gestor = new GestorTaller();
        
        
        try{
            Auto auto1 = new Auto("Yaris", true, true, "Toyota", 2022, 18000);
            gestor.registrarVehiculo(auto1);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
                }
        
        try{
            Auto auto2 = new Auto("Sail", false, false, "Chevrolet", 2018, 62000);
            gestor.registrarVehiculo(auto2);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        try{
            Furgon furgo1 = new Furgon(2.0, "Toyota", 2020, 45000);
            gestor.registrarVehiculo(furgo1);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
                }
        
        try{
            Furgon furgo2 = new Furgon(1.0, "Hyundai", 2023, 12000);
            gestor.registrarVehiculo(furgo2);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
                }
        
        
        gestor.mostrarEncontrados("hyundai");
        
        gestor.listarVehiculos();
        
        
    }
    
    
}
