/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionvehiculos;

/**
 *
 * @author Compu
 */
public class VehiculoCarga extends Vehiculo{
    
    private double capacidadToneladas;

    public VehiculoCarga() {
    }

    public VehiculoCarga(double capacidadToneladas, String patente, double precioBase) {
        super(patente, precioBase);
        setCapacidadToneladas(capacidadToneladas);
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        if(capacidadToneladas <= 0){
            throw new IllegalArgumentException("Capacidad en toneladas no puede ser 0 o menor.");
        }
        this.capacidadToneladas = capacidadToneladas;
    }
    
    

    @Override
    public double calcularPrecioFinal() {
        double recargoPorTonelada = 8.0 /100;
        double precioFinal = super.getPrecioBase()+ ((capacidadToneladas * recargoPorTonelada) * super.getPrecioBase());
        
        return precioFinal;
    }

    
    
}
