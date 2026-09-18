/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarriendovehiculos;

/**
 *
 * @author Compu
 */
public class CamionetaCarga extends Vehiculo{
    private double capacidadCargaKg;
    private boolean traccion4x4;

    public CamionetaCarga() {
    }

    public CamionetaCarga(double capacidadCargaKg, boolean traccion4x4, String patente, int annio, int diasArriendo) {
        super(patente, annio, diasArriendo);
        setCapacidadCargaKg(capacidadCargaKg);
        this.traccion4x4 = traccion4x4;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void setCapacidadCargaKg(double capacidadCargaKg) {
        if(capacidadCargaKg <= 0){
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor a 0");
        }
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public boolean isTraccion4x4() {
        return traccion4x4;
    }

    public void setTraccion4x4(boolean traccion4x4) {
        this.traccion4x4 = traccion4x4;
    }

    @Override
    public double calcularTotalArriendo() {
        double tarifaBase = getDiasArriendo()* 40000;
        if(traccion4x4){
            tarifaBase += tarifaBase *0.20;
        }
        return tarifaBase;
    }

    
}
