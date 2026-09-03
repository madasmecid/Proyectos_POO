/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public class Cirujano extends Medico{
    private int cantidadCirugiasRealizadas;

    public Cirujano() {
    }

    public Cirujano(int cantidadCirugiasRealizadas) {
        this.cantidadCirugiasRealizadas = cantidadCirugiasRealizadas;
    }

    public Cirujano(int cantidadCirugiasRealizadas, String especialidad, int aniosExperiencia) {
        super(especialidad, aniosExperiencia);
        this.cantidadCirugiasRealizadas = cantidadCirugiasRealizadas;
    }

    public Cirujano(int cantidadCirugiasRealizadas, String especialidad, int aniosExperiencia, String nombre, String rut, String fechaNac) {
        super(especialidad, aniosExperiencia, nombre, rut, fechaNac);
        this.cantidadCirugiasRealizadas = cantidadCirugiasRealizadas;
    }

    public int getCantidadCirugiasRealizadas() {
        return cantidadCirugiasRealizadas;
    }

    public void setCantidadCirugiasRealizadas(int cantidadCirugiasRealizadas) {
        if (cantidadCirugiasRealizadas >= 0){
        this.cantidadCirugiasRealizadas = cantidadCirugiasRealizadas;
        }else{
            System.out.println("La cantidad de cirujias no puede ser menor a 0");
        }
    }

    @Override
    public String toString() {
        return "Cirujano " + "cantidadCirugiasRealizadas=" + cantidadCirugiasRealizadas + " - "+ super.toString();
    }
    
    
    
    public void realizarCirugia(){
        cantidadCirugiasRealizadas += 1;
        System.out.println("Se realiza cirugia");
    }
    
    @Override
    void realizarTrabajo() {
        System.out.println("Preparado para la siguente cirugia");
    }
    @Override
    public void capacitable() {
        System.out.println("Se llama a su capacitacion semestral de cirujano");
    }
    
}
