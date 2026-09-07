/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionpersonalhospitalario;

import java.util.ArrayList;

/**
 *
 * @author Compu
 */
public class Main {

    
    public static void main(String[] args) {
        
        ArrayList<Personal> personal = new ArrayList<>();
        
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
        cirujano1.setHorarioTrabajo("DIURNO");

        
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
        
        contador1.setHorarioTrabajo("VESPERTINO");
        contador1.capacitable();
        
        System.out.println("---------------------");
        
        Recepcionista recepcionista1 = new Recepcionista();
        
        recepcionista1.setNumeroVentanilla(4);
        recepcionista1.setNombre("Pilar");
        recepcionista1.setHorarioTrabajo("Diurno");
        recepcionista1.setDepartamento("Clinica infantil");
        recepcionista1.setHorarioTrabajo("DIURNO");
        
        System.out.println("La nueva recepcionista " + recepcionista1.getNombre()+ " se le asigno el horario " + recepcionista1.getHorarioTrabajo());
        
        recepcionista1.registrarPAciente();
        System.out.println("------------------------------------------------");

        
        personal.add(contador1);
        personal.add(cirujano1);
        personal.add(recepcionista1);
        
        
        System.out.println("En este momento tenemos "+ personal.size()+ " personas trabajando en el sistema");
        
        String nombreBuscar = "Jose";
        
        boolean encontrado = false;
        
        for (int i = 0; i < personal.size(); i++){
            System.out.println(personal.get(i).toString());
            personal.get(i).realizarTrabajo();
            
            if (nombreBuscar.equals(personal.get(i).getNombre())){
                System.out.println("Trabajador encontrado");
                encontrado = true;
            }   
        }
        if(!encontrado){
            System.out.println("Personal no registrado");
        }
        
        int horarioDiurno = 0;
        
        for (int e = 0; e < personal.size(); e++){
            if("DIURNO".equals(personal.get(e).getHorarioTrabajo())){
                horarioDiurno +=1;
                
            }
        }
        
        System.out.println("trabajador horario diurno : "+ horarioDiurno);
        
                

    }
    
}

//REVISAR HORARIOS DE PERSONAL Y AGREGAR EN PERSONAL, REALIZAR CAMBIO EN TODAS LAS CLASES.
