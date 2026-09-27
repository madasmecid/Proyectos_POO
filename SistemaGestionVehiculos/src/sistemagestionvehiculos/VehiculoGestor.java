/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionvehiculos;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class VehiculoGestor {
    private ArrayList <Vehiculo> vehiculos;  

    public VehiculoGestor() {
        this.vehiculos = new ArrayList<>();
    }
    
    

    public VehiculoGestor(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void agregarVehiculo( Vehiculo v){
        if (v == null){
            throw new IllegalArgumentException("No se puede agregar vehiculo nulo.");
        }else{
            vehiculos.add(v);
            System.out.println("Se agrego vehiculo exitosamente: " + v.toString());
        }
    }
    
    public void mostrarVehiculos(){
        for ( Vehiculo v : vehiculos){
            System.out.println("Patente: " + v.getPatente()+ " Precio base $" + (long) v.getPrecioBase() + " precio final $" + (long) v.calcularPrecioFinal());
        }
    }
    
    public void cargarBaterias(){
        for(Vehiculo v : vehiculos){
            if (v instanceof VehiculoElectrico e){
                e.recargar(2);
                System.out.println("Bateria recargada vehiculo: " + e.getPatente()+ " nivel bateria: " + e.getNivelBateria());
            }
        }
    }
    
    
    
    
}
