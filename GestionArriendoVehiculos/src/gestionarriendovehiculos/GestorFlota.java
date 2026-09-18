/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarriendovehiculos;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class GestorFlota {
    private ArrayList<Vehiculo> flota;

    public GestorFlota(ArrayList<Vehiculo> flota) {
        this.flota = flota;
    }

    public GestorFlota() {
        this.flota = new ArrayList<>();
    }

    
    
    
    
        
    public void registrarVehiculo(Vehiculo v){
        if (v == null){
          throw new IllegalArgumentException("No se puede registrar un vehiculo nulo");
        }
        flota.add(v);
        System.out.println("El vehiculo " + v.getPatente()+ " se registro correctamente");
    }
    
    public ArrayList<Vehiculo> buscarPorPatente(String patente){
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : flota){
            if(v.getPatente().equalsIgnoreCase(patente)){
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    
    public void listarVehiculos(){
        for(Vehiculo v : flota){
            System.out.println(v.toString());
        }
    }
    
    public void calcularTotalesFlota(){
        for (Vehiculo v : flota){
            System.out.printf("%s: $%.0f\n", v.getPatente(),v.calcularTotalArriendo());
        }
    }
        
        
        
        
    
    
    
    
    
}
