/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public abstract class Personal implements Capacitable{
    
    private String nombre, rut, fechaNac, horarioTrabajo;

    public Personal() {
    }

    public Personal(String nombre, String rut, String fechaNac, String horarioTrabajo) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNac = fechaNac;
        this.horarioTrabajo = horarioTrabajo;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        if (horarioTrabajo.equals("VESPERTINO") || horarioTrabajo.equals("DIURNO")){
        this.horarioTrabajo = horarioTrabajo;
        }else{
            System.out.println("debe ser horario diurno o vespertino");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() > 3){
        this.nombre = nombre;
        }else{
            System.out.println("El nombre debe tener mas de 3 letras");
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut.length()> 8){
        this.rut = rut;
        }else{
            System.out.println("El rut no es valido debe tener por lo menos 9 digitos");
        }
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Personal{" + "nombre=" + nombre + ", rut=" + rut + ", fechaNac=" + fechaNac + '}';
    }
    
    
    abstract void realizarTrabajo();
    
    
      
}
