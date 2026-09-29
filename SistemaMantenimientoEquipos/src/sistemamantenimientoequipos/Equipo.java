/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemamantenimientoequipos;

/**
 *
 * @author Compu
 */
public abstract class Equipo {
    private String codigo;
    private double costoBase;

    public Equipo() {
    }

    public Equipo(String codigo, double costoBase) {
        setCodigo(codigo);
        setCostoBase(costoBase);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo invalido no puede estar vacio.");
        }
        this.codigo = codigo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        if(costoBase <= 0){
            throw new IllegalArgumentException("error. el costo base no puede ser 0 o un numero negativo");
        }
        this.costoBase = costoBase;
    }
    
    public abstract double calcularCostoMantencion();
    
    
    
    
}
