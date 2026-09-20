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
    
    public ArrayList<Vehiculo> buscarPorPatente (String patente, int annio){
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for(Vehiculo v : flota){
            if(v.getPatente().equalsIgnoreCase(patente) && v.getAnnio() == annio){
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
    
    public void mostrarEntontrados(String patente){
        System.out.println("------- vehiculos encontrados por patente------");
        ArrayList<Vehiculo> mostrar = buscarPorPatente(patente);
        if (mostrar.isEmpty()){
            System.out.println("No se encontro vehiculo con esa patente");
        }else{
            for(Vehiculo v: mostrar){
                System.out.println(v.toString());
            }
        }
        }
    
    public void mostrarEncontrados(String patente, int annio){
        System.out.println("-----------Encontrados por patente y anio-------------");
        ArrayList<Vehiculo> mostrar = buscarPorPatente(patente, annio);
        if(mostrar.isEmpty()){
            System.out.println("Vehiculo no encontrado");
        }else{
            for( Vehiculo v : mostrar){
                System.out.println(v.toString());
            }
        }
    }
        
    }
    
    
    

