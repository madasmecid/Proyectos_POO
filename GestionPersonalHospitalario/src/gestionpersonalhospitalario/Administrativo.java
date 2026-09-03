/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public abstract class Administrativo extends Personal{
    private String departamento, horarioTrabajo;

    public Administrativo() {
    }

    public Administrativo(String departamento, String horarioTrabajoString) {
        this.departamento = departamento;
        this.horarioTrabajo = horarioTrabajoString;
    }

    public Administrativo(String departamento, String horarioTrabajo, String nombre, String rut, String fechaNac) {
        super(nombre, rut, fechaNac);
        this.departamento = departamento;
        this.horarioTrabajo = horarioTrabajo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    @Override
    public String toString() {
        return "Administrativo " + "departamento=" + departamento + ", horarioTrabajo=" + horarioTrabajo + " - "+ super.toString();
    }
    
    
    
    
    
    
    abstract void gestionarDocumento();

    @Override
    abstract void realizarTrabajo();

        
    
}
