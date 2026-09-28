/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorenvioslogisticas;

/**
 *
 * @author Compu
 */
public class EnvioTerrestre extends Envio {
    public int distanciaKm;

    public EnvioTerrestre() {
    }

    public EnvioTerrestre(int distanciaKm, String codigoSeguimiento, double costoBase) {
        super(codigoSeguimiento, costoBase);
        setDistanciaKm(distanciaKm);
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        if (distanciaKm <= 0){
            throw new IllegalArgumentException("Distancia en km mal ingresada, intente nuevamente.");
        }
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCostoTotal() {
        double RecargoKm = 150.0;
        double costoTotal = super.getCostoBase()+ (getDistanciaKm()* RecargoKm);
        return Math.round(costoTotal);
    }
    
    
    
}
