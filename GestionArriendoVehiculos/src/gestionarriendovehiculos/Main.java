/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionarriendovehiculos;

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
        GestorFlota gestor = new GestorFlota();
        try{
        AutoPasajero auto1 = new AutoPasajero(7, true, "dfg-56", 2020, 5);
        gestor.registrarVehiculo(auto1);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: "+ e.getMessage());
        }
        
        try{
            CamionetaCarga camioneta1 = new CamionetaCarga(40, false, "ttyr-54", 2019, 4);
            gestor.registrarVehiculo(camioneta1);
        }catch (IllegalArgumentException e){
            System.out.println("Error de validacion: "+ e.getMessage());
        }
        
        gestor.listarVehiculos();
        
        gestor.calcularTotalesFlota();
        
        gestor.mostrarEntontrados("tyr-54");
        
    }
    
}
