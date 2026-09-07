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
    private String departamento;

    public Administrativo() {
    }

    public Administrativo(String departamento, String nombre, String rut, String fechaNac, String horarioTrabajo) {
        super(nombre, rut, fechaNac, horarioTrabajo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
    
    
    
       


    @Override
    public String toString() {
        return "Administrativo " + "departamento=" + departamento + ", horarioTrabajo=" + " - "+ super.toString();
    }
    
    
    
    
    
    
    abstract void gestionarDocumento();

    @Override
    abstract void realizarTrabajo();

        
    
}
