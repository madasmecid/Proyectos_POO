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
        
        System.out.println(cirujano1);
        
        cirujano1.capacitable();
        
        cirujano1.realizarTrabajo();
        
        cirujano1.realizarCirugia();
        cirujano1.realizarCirugia();

        
        System.out.println("------------------------------");
        
        System.out.println("total cirugias "+ cirujano1.getCantidadCirugiasRealizadas());
        
        System.out.println("---------------------------------");
        
        Contador contador1 = new Contador();
        contador1.setNombre("Pedrito");
        contador1.setDepartamento("Medicina oriental");
        contador1.setPresupuestoAdministrativo(3000);
        contador1.setHorarioTrabajo("Vespertino");
        
        System.out.println("el nuevo contador se llama " + contador1.getNombre()+ " y trbaja en horario " + contador1.getHorarioTrabajo());
        
        contador1.generarInformeFinanciero();
        
        contador1.capacitable();
        
        System.out.println("---------------------");
        
        Recepcionista recepcionista1 = new Recepcionista();
        
        recepcionista1.setNumeroVentanilla(4);
        recepcionista1.setNombre("Pilar");
        recepcionista1.setHorarioTrabajo("Diurno");
        recepcionista1.setDepartamento("Clinica infantil");
        
        System.out.println("La nueva recepcionista " + recepcionista1.getNombre()+ " se le asigno el horario " + recepcionista1.getHorarioTrabajo());
        
        recepcionista1.registrarPAciente();

    }
    
}
