/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public class Recepcionista extends Administrativo {
    private int numeroVentanilla;

    public Recepcionista() {
    }

    public Recepcionista(int numeroVentanilla) {
        this.numeroVentanilla = numeroVentanilla;
    }

    public Recepcionista(int numeroVentanilla, String departamento, String horarioTrabajo, String nombre, String rut, String fechaNac) {
        super(departamento, horarioTrabajo, nombre, rut, fechaNac);
        this.numeroVentanilla = numeroVentanilla;
    }

   

    public int getNumeroVentanilla() {
        return numeroVentanilla;
    }

    public void setNumeroVentanilla(int numeroVentanilla) {
        if (numeroVentanilla > 0){
        this.numeroVentanilla = numeroVentanilla;
        }else{
            System.out.println("Numero de ventanilla no puede ser negativo o 0");
        }
    }

    @Override
    public String toString() {
        return "Recepcionista  " + "numeroVentanilla=" + numeroVentanilla + " - " + super.toString();
    }
    
    
    
    
    
    
    
    public void registrarPAciente(){
        System.out.println("Se registra nuevo paciente en el sistema");
    }

    @Override
    void gestionarDocumento() {
        System.out.println("Se gestiona nuevos documentos en sistema");
    }

    @Override
    void realizarTrabajo() {
        System.out.println("Se pone a trabajar");
    }

    @Override
    public void capacitable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
