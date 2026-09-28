/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleadosremuneraciones;

/**
 *
 * @author Compu
 */
public abstract class Empleado {
    private String rut;
    private double sueldoBase;

    public Empleado() {
    }

    public Empleado(String rut, double sueldoBase) {
        setRut(rut);
        setSueldoBase(sueldoBase);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if(rut == null || rut.trim().isEmpty()){
            throw new IllegalArgumentException("Rut no puede ser nulo o estar vacio.");
        }
        this.rut = rut;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        if(sueldoBase <= 0){
            throw new IllegalArgumentException("Sueldo base no puede ser 0 o menor");
        }
        this.sueldoBase = sueldoBase;
    }
    
    abstract public double calcularSueldoLiquido();
    
}
