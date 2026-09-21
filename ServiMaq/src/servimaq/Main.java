/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servimaq;

/**
 *
 * @author Compu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorMantenimiento gestor = new GestorMantenimiento();
        
        
        try{
            MantenimientoPreventivo preve1 = new MantenimientoPreventivo("intensiva", true, "44-pp", 2020, 2);
            gestor.registrarOrden(preve1);       
        }catch (IllegalArgumentException e){
            System.out.println("Error al registar: "+ e.getMessage());
        }
        
        try{
            MantenimientoPreventivo preve2 = new MantenimientoPreventivo("full", true, "90-dkk", 2015, 9);
            gestor.registrarOrden(preve2);       
        }catch (IllegalArgumentException e){
            System.out.println("Error al registar: "+ e.getMessage());
        }
        
        try{
            MantenimientoCorrectivo correctivo1 = new MantenimientoCorrectivo(70000, true, "rty-98", 2020, 10);
            gestor.registrarOrden(correctivo1);
        }catch (IllegalArgumentException e ){
            System.out.println("Error al registar: " + e.getMessage());
        }
        
        try{
            MantenimientoCorrectivo correctivo2 = new MantenimientoCorrectivo(10000, false, "ppppo-0", 2020, 1);
            gestor.registrarOrden(correctivo2);
        }catch (IllegalArgumentException e ){
            System.out.println("Error al registar: " + e.getMessage());
        }
        
        try{
            MantenimientoPreventivo preve3 = new MantenimientoPreventivo("mediana", false, "6666669-p", 2025, 5);
            gestor.registrarOrden(preve3);       
        }catch (IllegalArgumentException e){
            System.out.println("Error al registar: "+ e.getMessage());
        }
        
        
        gestor.listarOrdenes();
        gestor.mostrarBusqueda("ppppo-0");
        
        gestor.mostrarBusqueda("44-pp", 2020);
        
        gestor.calcularCostosTotales();
        
        gestor.eliminarOrden("90-dkk");
        
        gestor.listarOrdenes();
    }
    
    
    
}
