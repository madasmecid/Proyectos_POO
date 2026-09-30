/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallermecanicoautofix;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 *
 * @author SB-Alumno
 */
public class GestorTaller {
    private ArrayList<Vehiculo> vehiculos;

    public GestorTaller() {
        this.vehiculos = new ArrayList<>();
    }
    
    public void registrarVehiculo (Vehiculo v){
        String tipo = "";
        if (v instanceof Auto){
            tipo ="Auto";
        }else if(v instanceof Furgon){
            tipo = "Furgon";
        }
  
        if(v == null){
            throw new IllegalArgumentException("No se puede registrar un vehiculo nulo.");
        }else{
            vehiculos.add(v);
            System.out.println(v.getMarca()+" "+ tipo +" Registrado Correctamente");
        }
    }
    
    public ArrayList<Vehiculo> busquedaMarca( String marca){
        ArrayList<Vehiculo> encontrado = new ArrayList<>();
        if(marca == null || marca.trim().isEmpty()){
            throw new IllegalArgumentException("Marca ingresada no puede ser nulo ni vacío.");
        }else{
            for(Vehiculo v : vehiculos){
                if(v.getMarca().equalsIgnoreCase(marca)){
                    encontrado.add(v);
                }
            }
        }
        return encontrado;
    }      
    
    
    public void mostrarEncontrados(String marca){
        System.out.println("=== BUSQUEDA POR MARCA ===");
        ArrayList<Vehiculo> mostrar = busquedaMarca(marca);
        
        if (mostrar == null || mostrar.isEmpty()){
            System.out.println("No se encontro vehiculos con esa marca.");
        }else{
            for(Vehiculo v : mostrar){
                System.out.println(v.toString());
            }
        }
        
    }
    
    public void listarVehiculos(){
        System.out.println("=== LISTA VEHICULOS ===");
        if(vehiculos == null || vehiculos.isEmpty()){
            System.out.println("No hay vehiculos para mostrar");
            return;
        }
        for (Vehiculo v : vehiculos){
            System.out.println("Marca: "+ v.getMarca()+ " | annio: "+ v.getAnnioFabricacion());
        }
    
    }
    
    
    
}
