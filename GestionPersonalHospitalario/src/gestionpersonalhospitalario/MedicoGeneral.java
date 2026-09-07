/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public class MedicoGeneral extends Medico{
    
    private int cantidadConsultasDiarias;

    public MedicoGeneral() {
    }

    public MedicoGeneral(int cantidadConsultasDiarias) {
        this.cantidadConsultasDiarias = cantidadConsultasDiarias;
    }

    public MedicoGeneral(int cantidadConsultasDiarias, String especialidad, int aniosExperiencia, String nombre, String rut, String fechaNac, String horarioTrabajo) {
        super(especialidad, aniosExperiencia, nombre, rut, fechaNac, horarioTrabajo);
        this.cantidadConsultasDiarias = cantidadConsultasDiarias;
    }

    

    public int getCantidadConsultasDiarias() {
        return cantidadConsultasDiarias;
    }

    public void setCantidadConsultasDiarias(int cantidadConsultasDiarias) {
        if (cantidadConsultasDiarias >= 0){
        this.cantidadConsultasDiarias = cantidadConsultasDiarias;
        }else{
            System.out.println("La cantidad de consultas no puede ser menor a 0");
        }
    }

    @Override
    public String toString() {
        return "MedicoGeneral{" + "cantidadConsultasDiarias=" + cantidadConsultasDiarias + " - "+ super.toString();
    }
    
    
    
    
    public void realizarConsultaMedica(){
        
        System.out.println("Realiza consulta medica");
    }
    
    @Override
    void realizarTrabajo() {
        System.out.println("Espera al siguente paciente en su box");
    }
    @Override
    public void capacitable() {
        System.out.println("Se capacita al medico general para el nuevo sistema de pacientes");
    }
    
}
