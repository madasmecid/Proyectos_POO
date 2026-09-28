/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorenvioslogisticas;

/**
 *
 * @author Compu
 */
public abstract class Envio {
    private String codigoSeguimiento;
    private double costoBase;

    public Envio() {
    }

    public Envio(String codigoSeguimiento, double costoBase) {
        setCodigoSeguimiento(codigoSeguimiento);
        setCostoBase(costoBase);
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(String codigoSeguimiento) {
        if(codigoSeguimiento == null || codigoSeguimiento.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo ingresado incorrectamente, intente nuevamente.");
        }
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        if(costoBase <= 0){
            throw new IllegalArgumentException("Costo base debe ser mayor a 0.");
        }
        this.costoBase = costoBase;
    }
    
    abstract public double calcularCostoTotal();
    
    
}
