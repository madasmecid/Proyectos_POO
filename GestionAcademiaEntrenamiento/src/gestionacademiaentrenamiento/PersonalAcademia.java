/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionacademiaentrenamiento;

/**
 *
 * @author Compu
 */
public abstract class PersonalAcademia implements Asistencia{
    private String nombre;
    private String rut;
    private int anioIngreso;

    public PersonalAcademia() {
    }

    public PersonalAcademia(String nombre, String rut, int anioIngreso) {
        this.nombre = nombre;
        this.rut = rut;
        this.anioIngreso = anioIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() >= 3){
        this.nombre = nombre;
        }else{
        System.out.println("el nombre debe tener 3 caracteres ");
        }
}

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if(rut.length() > 8){
        this.rut = rut;
        }else{
            System.out.println("El rut debe tener minimo 9 digitos");
        }
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        if(anioIngreso <= 2000){
            System.out.println("No puede tener año de ingreso menor a 2000");
        }else{
        this.anioIngreso = anioIngreso;
        }
    }

    @Override
    public String toString() {
        return "PersonalAcademia{" + "nombre=" + nombre + ", rut=" + rut + ", anioIngreso=" + anioIngreso + '}';
    }

    @Override
    public void marcarAsistencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
