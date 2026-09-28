package gestionempleadosremuneraciones;


import gestionempleadosremuneraciones.Empleado;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Compu
 */
public class EmpleadoPlanta extends Empleado{
    private int aniosAntiguedad;

    public EmpleadoPlanta() {
    }

    public EmpleadoPlanta(int aniosAntiguedad, String rut, double sueldoBase) {
        super(rut, sueldoBase);
        setAniosAntiguedad(aniosAntiguedad);
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        if(aniosAntiguedad < 0){
            throw new IllegalArgumentException("Anios de antiguedad no puede ser negativo.");
        }
        this.aniosAntiguedad = aniosAntiguedad;
    }
    
    

    @Override
    public double calcularSueldoLiquido() {
        double bonoPorAnnio = super.getSueldoBase() *(aniosAntiguedad * 0.03);
        double descuentosLegales = (super.getSueldoBase()*0.2 );
        
        double sueldoLiquido = (super.getSueldoBase()+ bonoPorAnnio) - descuentosLegales ;
        
        return sueldoLiquido;
    }
    
    
    
}
