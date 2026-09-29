/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemamantenimientoequipos;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class TallerGestor {
    
    private ArrayList<Equipo> equipos;

    public TallerGestor() {
        this.equipos = new ArrayList<>();
    }
    
    public void agregarEquipo(Equipo e){
        if(e == null){
            throw new IllegalArgumentException("Equipo a guardar no puede ser nulo.");
        }else{
            equipos.add(e);
            System.out.println("Se agrego correctamente el equipo: "+ e.getCodigo());
        }
    }
    
    public void mostrarEquipos(){
        if(equipos == null || equipos.isEmpty()){
            System.out.println("NO hay equipos para mostrar");
            return;
        }
        for(Equipo e : equipos){
            System.out.println(e.getCodigo()+"-- $"+ (long) e.getCostoBase());
        }
    }
    
    public void aplicarGarantia(){
        System.out.println("Aplicar garantia");
        if(equipos == null || equipos.isEmpty()){
            System.out.println("No hay equipos para aplicar garantia");
            return;
        }
        for(Equipo e : equipos){
            if (e instanceof IGarantizable i ){
                i.aplicarGarantia(20);
            }
                
        }
    }
    
    
    
}
