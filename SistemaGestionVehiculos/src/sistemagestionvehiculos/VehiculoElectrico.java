/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestionvehiculos;

/**
 *
 * @author Compu
 */
public class VehiculoElectrico extends Vehiculo implements IElectronico{
    
    private int nivelBateria;

    public VehiculoElectrico() {
    }

    public VehiculoElectrico(int nivelBateria, String patente, double precioBase) {
        super(patente, precioBase);
        setNivelBateria(nivelBateria);
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        if(nivelBateria < 0 || nivelBateria >100){
            throw new IllegalArgumentException("Nivel de bateria debe estar entre 0 y 100");
        }
        this.nivelBateria = nivelBateria;
    }
    
    


    @Override
    public double calcularPrecioFinal() {
        double subsidioVerde = 10.0 / 100;
        double precioFinal = super.getPrecioBase() - (super.getPrecioBase() * subsidioVerde);
        return precioFinal;
    }

    @Override
    public boolean recargar(int horas) {      
        double carga = (horas * 20);
        if (horas <= 0){
            return false;
        }else if (nivelBateria >= 0||nivelBateria < 100){
            nivelBateria += carga;
        }
        if(nivelBateria >= 100){
            nivelBateria = 100;
        }
        return true;
    }

    
    
    
    
}
