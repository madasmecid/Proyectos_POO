/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public abstract class Medico extends Personal{
    private String especialidad;
    private int aniosExperiencia;

    public Medico() {
    }

    public Medico(String especialidad, int aniosExperiencia) {
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Medico(String especialidad, int aniosExperiencia, String nombre, String rut, String fechaNac, String horarioTrabajo) {
        super(nombre, rut, fechaNac, horarioTrabajo);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "Medico " + "especialidad=" + especialidad + ", aniosExperiencia=" + aniosExperiencia +" - " + super.toString();
    }
    
    
    
    public void atenderPaciente(){
        System.out.println("Atiende a su siguiente paciente");
    }

    @Override
    abstract void realizarTrabajo();
      

    @Override
    abstract public void capacitable();
    
    
}
