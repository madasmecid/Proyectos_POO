/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
            CambioAceite aceite3 = new CambioAceite("20W50 mineral", false, "act-err", 1980, 1);
            gestor.registrarServicio(aceite3);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: " + e.getMessage());
        }
        
        
        gestor.calcularCostosTotales();
        
        gestor.listarServicios();
       
        
       gestor.MostrarBusqueda("frenos yari");
        
        System.out.println("SERVICIOS ENCONTRADOS POR ANIO");
        
        for(Servicio s : gestor.buscarPorCodigo("frenos yari", 2000)){
            System.out.println(s);
        }

        
        
    }
    
}
