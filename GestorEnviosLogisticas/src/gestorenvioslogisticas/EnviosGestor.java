/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorenvioslogisticas;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class EnviosGestor {
    private ArrayList<Envio> envios;

    public EnviosGestor() {
        this.envios = new ArrayList<>();
    }
    
    
    public void agregarEnvio(Envio e){
        if(e == null){
            throw new IllegalArgumentException("No se puede agregar envio nulo o vacio.");
        }else{
            envios.add(e);
            System.out.println("Se agrego el nuevo envio codigo: "+ e.getCodigoSeguimiento()+ " exitosamente.");
        }
    }
    
    public void mostrarEnvios(){
        System.out.println("------ENVIOS REGISTRASOS------");
        if (envios == null || envios.isEmpty()){
            System.out.println("No hay envios para mostrar");
        }else{
            for (Envio e : envios){
                System.out.println("Codigo Envio: "+ e.getCodigoSeguimiento()+ " costo base: $"+ (long)e.getCostoBase()+" costo total: $" + (long) e.calcularCostoTotal());
            }
        }
    }
    
    public void aplicarDescuentosPromocionales(){
        if (envios == null || envios.isEmpty()){
            throw new IllegalArgumentException("No existen envios para aplicar descuentos.");
        }else{
            for(Envio e : envios){
                if(e instanceof EnvioAereo a){
                    a.aplicarDescuento(15);
                    System.out.println("Se le aplico un descuento al envio: "+ a.getCodigoSeguimiento());
                }
            }
        }
    }
    
    
    
}
