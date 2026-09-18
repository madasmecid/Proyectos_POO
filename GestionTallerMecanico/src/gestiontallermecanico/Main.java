/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/*
 * JUSTIFICACIÓN DEL PARADIGMA ORIENTADO A OBJETOS (IL 1.1):
 * A diferencia del paradigma procedimental/estructurado donde los datos y los procedimientos 
 * están desacoplados, la POO integra atributos privados y comportamientos mediante encapsulamiento.
 * El tipado estático de Java garantiza la consistencia en tiempo de compilación, mientras que la 
 * herencia y el polimorfismo permiten tratar colecciones uniformes (ArrayList<Servicio>) ejecutando 
 * los cálculos especializados en tiempo de ejecución sin verificaciones manuales de tipo.
 */
package gestiontallermecanico;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GestorTaller gestor = new  GestorTaller();
        
        try{
            MantencionFrenos freno1 = new MantencionFrenos("Premium", true, true, "frenos yari", 2000, 5);
            gestor.registrarServicio(freno1);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: " + e.getMessage());
        }
        
        try{
            MantencionFrenos freno2 = new MantencionFrenos("Selecto", true, true, "toyota", 2025, 1);
            gestor.registrarServicio(freno2);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion "+ e.getMessage());
        }
        
        try{
            CambioAceite aceite1 = new CambioAceite("10W40 sintetico", false, "act-001", 2018, 1);
            gestor.registrarServicio(aceite1);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: " + e.getMessage());
        }
        
        try{
            CambioAceite aceite2 = new CambioAceite("%W30", true, "act-002", 2023, 2);
            gestor.registrarServicio(aceite2);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: " + e.getMessage());
        }
        
        try{
            CambioAceite aceite3 = new CambioAceite("20W50 mineral", false, "act-err", 1990, 1);
            gestor.registrarServicio(aceite3);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: " + e.getMessage());
        }
        
        
        
        try{
            MantencionFrenos frenos3 = new MantencionFrenos("45W", true, true, "ert-001", 2020, 10);
            gestor.registrarServicio(frenos3);
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+ e.getMessage());
        }
    


    
        
        
        gestor.calcularCostosTotales();
        
        gestor.listarServicios();
       
        
       gestor.mostrarBusqueda("frenos yari");
       
       gestor.mostrarBusqueda("ert-001", 2020);
       
       
    }
    
}
