/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servimaq;

/**
 *
 * @author Compu
 */
public class MantenimientoCorrectivo extends OrdenMantenimiento{
    
    private double costoRespuestos;
    private boolean cambioMotorCompleto;

    public MantenimientoCorrectivo() {
    }

    public MantenimientoCorrectivo(double costoRespuestos, boolean cambioMotorCompleto, String CodigoOrden, int anioFabricacion, int horasTrabajo) {
        super(CodigoOrden, anioFabricacion, horasTrabajo);
        setCostoRespuestos(costoRespuestos);
        this.cambioMotorCompleto = cambioMotorCompleto;
    }

    public double getCostoRespuestos() {
        return costoRespuestos;
    }

    public void setCostoRespuestos(double costoRespuestos) {
        if(costoRespuestos < 0){
            throw new IllegalArgumentException("El costo de respuesto de ser mayor a 0");
        }
        this.costoRespuestos = costoRespuestos;
    }

    public boolean isCambioMotorCompleto() {
        return cambioMotorCompleto;
    }

    public void setCambioMotorCompleto(boolean cambioMotorCompleto) {
        this.cambioMotorCompleto = cambioMotorCompleto;
    }
    
    
    
    @Override
    public double calcularCostoFinal() {
        double tarifaBase = (50000 * getHorasTrabajo())+ costoRespuestos;
        if (cambioMotorCompleto){
            tarifaBase += tarifaBase * 0.25;
        }
        return tarifaBase;
    }
    
}
