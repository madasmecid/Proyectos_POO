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

    
    
    
    
    //REgistro de vheiculos nuevos    
    public void registrarVehiculo(Vehiculo v){
        if (v == null){
          throw new IllegalArgumentException("No se puede registrar un vehiculo nulo");
        }
        flota.add(v);
        System.out.println("El vehiculo " + v.getPatente()+ " se registro correctamente");
    }
    
    //Buscar por patente
    public ArrayList<Vehiculo> buscarPorPatente(String patente){
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : flota){
            if(v.getPatente().equalsIgnoreCase(patente)){
                resultado.add(v);
            }
        }
        return resultado;
    }
    //Buscar por patente y annio (Recarga)
    public ArrayList<Vehiculo> buscarPorPatente (String patente, int annio){
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for(Vehiculo v : flota){
            if(v.getPatente().equalsIgnoreCase(patente) && v.getAnnio() == annio){
                resultado.add(v);
            }
        }
        return resultado;
    }
    
    //Listar todos los vehiculos registrados
    public void listarVehiculos(){
        System.out.println("-----------Lista de vehiculos----------------");
        if (flota.isEmpty()){
            System.out.println("No existen vehiculos para listar.");
        }else{
            for(Vehiculo v : flota){
                System.out.println(v.toString());
            }
        }
    }
    
    //Calcular el total de cada vehiculo de la flota
    public void calcularTotalesFlota(){
        for (Vehiculo v : flota){
            System.out.printf("%s: $%.0f\n", v.getPatente(),v.calcularTotalArriendo());
        }
    }
    
    //Mostrar los encontrados por patentes usando el metodo buscar por patente solo patente
    public void mostrarEncontrados(String patente){
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
    
    //Mostrar los enconrrados por patente y annio usando el metodo buscar por patente y annio (Recarga)
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
    
    public void eliminarPorPatente(String patente){
        int indice = -1;
        for(int i = 0; i < flota.size(); i++){
            if(flota.get(i).getPatente().equalsIgnoreCase(patente)){
                indice = i; 
                break;
            }
            }
        if(indice >= 0){   
            System.out.println("Se elimino el vehiculo patente " + flota.get(indice).getPatente());
            flota.remove(indice);
        }else{
            System.out.println("No se encontro patente para eliminar.");
        }
    }
 }


        
    
    
    

