/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontallermecanico;

import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class GestorTaller {
    
    private ArrayList<Servicio> servicios;

    public GestorTaller(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    public GestorTaller() {
        this.servicios = new ArrayList<>();
    }
    
    public void registrarServicio(Servicio s){
        if (s == null){
            throw new IllegalArgumentException("Npo puede registrar un servicio nulo");
        }
            this.servicios.add(s);
            System.out.println("El servicio se ha registrado correctamente: "+ s.getCodigo());
    }
    
    public ArrayList<Servicio> buscarPorCodigo(String codigo){
        ArrayList<Servicio> resultado = new ArrayList<>();
        if(codigo != null){
            for(Servicio s : this.servicios){
                if(s.getCodigo().equalsIgnoreCase(codigo)){
                    resultado.add(s);
                }
            } 
        }
        return resultado;
    }
    
     public ArrayList<Servicio> buscarPorCodigo(String codigo, int annio){
        ArrayList<Servicio> resultado = new ArrayList<>();
        if(codigo != null){
            for(Servicio s : this.servicios){
                if(s.getCodigo().equalsIgnoreCase(codigo) && s.getAnioVehiculo() == annio){
                    resultado.add(s);
                }
            } 
        }
        return resultado;
    }
    
    public void listarServicios(){
        System.out.println("\nSERVICIOS REGISTRADOS");
        for(Servicio s : servicios){
            System.out.println(s.toString());
        }
    }
    
    public void calcularCostosTotales(){
        System.out.println("\nCOSTOS TOTALES DE SERVICIOS");
        for(Servicio s : servicios){
            System.out.printf("%s: $%.0f\n",s.getCodigo(), s.calcularCostoTotal());
        }
        
    }
    
    public void MostrarBusqueda(String Codigo){
            System.out.println("\nSERVICIOS ENCONTRADOS");
            ArrayList<Servicio> encontrados = buscarPorCodigo(Codigo);
            
            if (encontrados.isEmpty()){
                System.out.println("No se encontraron servicios con este codigo");
            }else{
                for(Servicio s : encontrados)
                    System.out.println(s);
                    
                   
                    
            }
    }
    
    
    
    
    
}
