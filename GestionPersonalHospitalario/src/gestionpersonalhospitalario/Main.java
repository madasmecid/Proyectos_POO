/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionpersonalhospitalario;

/**
 *
 * @author Compu
 */
public class Main {

    
    public static void main(String[] args) {
        
        Cirujano cirujano1 = new Cirujano();
        cirujano1.setNombre("Jose");
        cirujano1.setRut("12233445-5");
        cirujano1.setEspecialidad("cirugias espalda");
        cirujano1.setAniosExperiencia(7);
        
        cirujano1.capacitable();
        
        cirujano1.realizarTrabajo();
        
        cirujano1.realizarCirugia();
        
        System.out.println("------------------------------");
        
        
        System.out.println(cirujano1);

    }
    
}
