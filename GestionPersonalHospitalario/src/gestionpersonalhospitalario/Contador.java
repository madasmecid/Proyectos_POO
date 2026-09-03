/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public class Contador extends Administrativo {
    private int presupuestoAdministrativo;

    public Contador() {
    }

    public Contador(int presupuestoAdministrativo, String departamento, String horarioTrabajo, String nombre, String rut, String fechaNac) {
        super(departamento, horarioTrabajo, nombre, rut, fechaNac);
        this.presupuestoAdministrativo = presupuestoAdministrativo;
    }

    public int getPresupuestoAdministrativo() {
        return presupuestoAdministrativo;
    }

    public void setPresupuestoAdministrativo(int presupuestoAdministrativo) {
        this.presupuestoAdministrativo = presupuestoAdministrativo;
    }

    @Override
    public String toString() {
        return "Contador  " + "presupuestoAdministrativo=" + presupuestoAdministrativo + " - " + super.toString();
    }
    
    
    
    
    
    
    public void generarInformeFinanciero(){
        System.out.println("Se genera informe financiero conrrespondiente al presente mes");
    }

    @Override
    void gestionarDocumento() {
        System.out.println("Se gestiona documentacion de nuevo presupuesto");
    }
    
    @Override
    public void capacitable() {
        System.out.println("Se llama a su capacitacion a contador por perdida de dinero");
    }

    @Override
    void realizarTrabajo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
