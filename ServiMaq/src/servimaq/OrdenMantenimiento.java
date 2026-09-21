/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servimaq;

/**
 *
 * @author Compu
 */
public abstract class OrdenMantenimiento {
    private String codigoOrden;
    private int anioFabricacion;
    private int horasTrabajo;

    public OrdenMantenimiento() {
    }

    public OrdenMantenimiento(String codigoOrden, int anioFabricacion, int horasTrabajo) {
        setCodigoOrden(codigoOrden);
        setAnioFabricacion(anioFabricacion);
        setHorasTrabajo(horasTrabajo);
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        if(codigoOrden == null || codigoOrden.trim().isEmpty()){
           throw new IllegalArgumentException("codigo ingresado no es valido.");
        }
        this.codigoOrden = codigoOrden;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if(anioFabricacion < 1995 || anioFabricacion > 2026){
            throw new IllegalArgumentException("El anio a ingresar debe estar entre 1995 y 2026");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        if(horasTrabajo <= 0){
            throw new IllegalArgumentException("Horas de trabajo debe ser mayor a 0.");
        }
        this.horasTrabajo = horasTrabajo;
    }
    
    public abstract double calcularCostoFinal();

    @Override
    public String toString() {
        return "codigoOrden: "+ codigoOrden + " -- anioFabricacion: " + anioFabricacion;
    }
    
    
    
    
}
