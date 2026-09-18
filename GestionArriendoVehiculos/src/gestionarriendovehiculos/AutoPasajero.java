/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionarriendovehiculos;

/**
 *
 * @author Compu
 */
public class AutoPasajero extends Vehiculo implements ISeguroAdicional{
    private int cantidadPasajeros;
    private boolean seguroCompleto;

    public AutoPasajero() {
    }

    public AutoPasajero(int cantidadPasajeros, boolean seguroCompleto, String patente, int annio, int diasArriendo) {
        super(patente, annio, diasArriendo);
        setCantidadPasajeros(cantidadPasajeros);
        this.seguroCompleto = seguroCompleto;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        if (cantidadPasajeros < 1 || cantidadPasajeros > 8){
            throw new IllegalArgumentException("EL numero de pasajeros debe ser entre 1 y 8");
        }
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public boolean isSeguroCompleto() {
        return seguroCompleto;
    }

    public void setSeguroCompleto(boolean seguroCompleto) {
        this.seguroCompleto = seguroCompleto;
    }
    
    

    @Override
    public double calcularTotalArriendo() {
        double tarifaBase = getDiasArriendo()* 25000;
        if(cantidadPasajeros > 5){
            tarifaBase += tarifaBase * 0.15;
        }
        return tarifaBase;
    }

    @Override
    public boolean aplicarSeguroCompleto() {
        return seguroCompleto;
    }
    
    
    
    
}
