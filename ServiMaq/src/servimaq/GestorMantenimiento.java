/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servimaq;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class GestorMantenimiento {
    private ArrayList<OrdenMantenimiento> ordenes;

    public GestorMantenimiento() {
        this.ordenes = new ArrayList<>();
    }

    public GestorMantenimiento(ArrayList<OrdenMantenimiento> ordenes) {
        this.ordenes = ordenes;
    }
    
    
    public void registrarOrden(OrdenMantenimiento o){
        if(o == null){
            throw new IllegalArgumentException("No puede registrar un orden nula");
        }
        ordenes.add(o);
        System.out.println("SE registro la orden: "+ o.toString());
    }
    
    //Busqueda por codigo
    public ArrayList<OrdenMantenimiento> buscarPorCodigo(String codigo){
        ArrayList<OrdenMantenimiento> encontrados = new ArrayList<>();
        for(OrdenMantenimiento o : ordenes){
            if(o.getCodigoOrden().equalsIgnoreCase(codigo)){
                encontrados.add(o);
            }
        }
        return encontrados;
    }
    //Busqueda por codigo y por anio
    public ArrayList<OrdenMantenimiento> buscarPorCodigo(String codigo, int anio){
        ArrayList<OrdenMantenimiento> encontrados = new ArrayList<>();
        for(OrdenMantenimiento o : ordenes){
            if(o.getCodigoOrden().equalsIgnoreCase(codigo) && o.getAnioFabricacion() == anio){
                encontrados.add(o);
            }
        }
        return encontrados;
    }
    
    public void listarOrdenes(){
        System.out.println("--------LISTA DE ORDENES------");
        if(ordenes.isEmpty()){
            System.out.println("No se encontraron ordenes para listar.");
        }else{
             for(OrdenMantenimiento o : ordenes){
            System.out.println(o.toString());
            } 
        }        
    }
    
    public void calcularCostosTotales(){
        System.out.println("----------COSTOS TOTALES------------");
        if(ordenes.isEmpty()){
            System.out.println("No hay ordenes para mostrar sus costos");
        }else{
            for(OrdenMantenimiento o: ordenes){
                System.out.printf("%s: $%.0f\n", o.getCodigoOrden(), o.calcularCostoFinal());
            }
        }
    }
    
    public void mostrarBusqueda(String codigo){
        System.out.println("---------Ordenes encontradas---------");
        ArrayList<OrdenMantenimiento> mostrar = buscarPorCodigo(codigo);
        if(mostrar.isEmpty()){
            System.out.println("No hay ordenes con ese codigo.");
        }else{
        for(OrdenMantenimiento o : mostrar){
            System.out.println(o.toString());
        }
        }
    }
    
    public void mostrarBusqueda(String codigo, int anio){
        System.out.println("---------Ordenes encontradas---------");
        ArrayList<OrdenMantenimiento> mostrar = buscarPorCodigo(codigo, anio);
        if(mostrar.isEmpty()){
            System.out.println("No hay ordenes con ese codigo.");
        }else{
        for(OrdenMantenimiento o : mostrar){
            System.out.println(o.toString());
        }
        }
    }
    
    public void eliminarOrden(String codigo){
        int indice = -1;
        if(ordenes.isEmpty()){
            System.out.println("No hay ordenes registradas para eliminar");
        }else{
            for(int i = 0; i < ordenes.size(); i++){
                if(ordenes.get(i).getCodigoOrden().equalsIgnoreCase(codigo)){
                    indice = i;
                    break;
                }
            }
        }
        if (indice > -1){
            System.out.println("La siguente orden se elimino correctamente: "+ ordenes.get(indice).getCodigoOrden());
            ordenes.remove(indice);
        }else{
            System.out.println("No se encontro orden con ese codigo para eliminar.");
        }
    }
    
    public int buscarPosicionOrden(String codigo){
        if (ordenes.isEmpty()){
            System.out.println("No hay ordenes registradas aun");
            return -1;
        }
        for (int i = 0; i < ordenes.size(); i++){
                if(ordenes.get(i).getCodigoOrden().equalsIgnoreCase(codigo)){
                    return i;
                }
            }
        return -1;
    }
    
    public void mostrasDetalleOrden(String Codigo){
        int pos = buscarPosicionOrden(Codigo);
        if (pos != -1){
            System.out.println(ordenes.get(pos).toString());
        }else{
            System.out.println("Orden no encontrada");
        }
    }
    
    
}
