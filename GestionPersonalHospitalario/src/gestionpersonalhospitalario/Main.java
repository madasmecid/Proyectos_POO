/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionpersonalhospitalario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Compu
 */
public class Main {

    
    public static void main(String[] args) {
        
        ArrayList<Personal> personal = new ArrayList<>();
        HashMap<String, Personal> trabajadores = new HashMap<>();
        
        Cirujano cirujano1 = new Cirujano();
        cirujano1.setNombre("Jose");
        cirujano1.setRut("12233445-5");
        cirujano1.setEspecialidad("cirugias espalda");
        cirujano1.setAniosExperiencia(7);
        
        Cirujano cirujano2 = new Cirujano();
        cirujano2.setNombre("Marco");
        cirujano2.setHorarioTrabajo("DIURNO");
        cirujano2.setRut("22233445-3");
        
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
        contador1.setRut("66666666-6");
        
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
        recepcionista1.setRut("999999-9");
        
        Contador contador2 = new Contador();
        
        contador2.setHorarioTrabajo("DIURNO");
        contador2.setNombre("Lechecito");
        contador2.setRut("1111111111-1");
    
        
        System.out.println("La nueva recepcionista " + recepcionista1.getNombre()+ " se le asigno el horario " + recepcionista1.getHorarioTrabajo());
        
        recepcionista1.registrarPAciente();
        System.out.println("------------------------------------------------");

        
        personal.add(contador1);
        personal.add(cirujano1);
        personal.add(recepcionista1);
        personal.add(contador2);
        personal.add(cirujano2);
        
        
        
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
        
        
        System.out.println("-----------------------------");
        
        for(int i = 0; i < personal.size(); i++ ){
            if ("DIURNO".equals(personal.get(i).getHorarioTrabajo()))
                System.out.println(personal.get(i).getNombre() + ": DIURNO");
        }
        
        int cantidadMedicos = 0;
        int cantidadAdministrativos = 0;

        
        for (int i = 0; i < personal.size(); i++){
            if (personal.get(i) instanceof Medico)
                cantidadMedicos ++;
            
            if (personal.get(i) instanceof Administrativo)
                cantidadAdministrativos ++;
        }
        
        System.out.println("Cantidad de medicos: " + cantidadMedicos);
        System.out.println("Cantidad administrativos: "+ cantidadAdministrativos);
        
        
        
        for (int i = 0; i < personal.size(); i++){
           if (personal.get(i) instanceof Administrativo){
                System.out.println("Administrativo: "+ personal.get(i).getNombre());}
           
           if (personal.get(i) instanceof Medico){
                System.out.println("Medico: "+ personal.get(i).getNombre());}
           
        }
        
        //System.out.println("Cantidad administrativos: "+ cantidadAdministrativos);
        
        
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < personal.size(); i++){
            if(personal.get(i).getHorarioTrabajo().equals("DIURNO") && personal.get(i) instanceof Medico){
                System.out.println("Medico :"+ personal.get(i).getNombre()+ " - "+ personal.get(i).getHorarioTrabajo());
            }
            
            if(personal.get(i).getHorarioTrabajo().equals("DIURNO") && personal.get(i) instanceof Administrativo){
                System.out.println("Administrativo :"+ personal.get(i).getNombre()+ " - "+ personal.get(i).getHorarioTrabajo());
            }
        }
        
        trabajadores.put(cirujano1.getRut(), cirujano1);
        trabajadores.put(contador2.getRut(), contador2);
        trabajadores.put(recepcionista1.getRut(), recepcionista1);
        trabajadores.put(contador1.getRut(), contador1);
        trabajadores.put(cirujano2.getRut(), cirujano2);
        
        System.out.println("--------------------------------------------");
        
        System.out.println(trabajadores.size());
        
        System.out.println(trabajadores.get("1111111111-1"));
        
        imprimir(trabajadores);
        
        
    }
    
    public static void imprimir(HashMap<String, Personal> trabajadores){
        for (Map.Entry<String, Personal> entry : trabajadores.entrySet()) {
            System.out.println(entry.getValue().getNombre());
            
        }
    }
    
}

