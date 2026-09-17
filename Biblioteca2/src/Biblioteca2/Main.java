/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Biblioteca2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorBiblioteca gestor = new GestorBiblioteca();
        
        try{
            Libro libro1 = new Libro("El principito","Ficcion", false, "El principito",1943, -0 );
            libro1.setDisponiblePrestamoExtendido(true);
            gestor.registrarMaterial(libro1);
            } catch (IllegalArgumentException e){
            System.out.println("Error de validacion: "+ e.getMessage());    
        }
        
        try{
            Libro libro2 = new Libro("Don quijote","Novela", false, "Don quijote",1605, 863 );
            gestor.registrarMaterial(libro2);
            } catch (IllegalArgumentException e){
            System.out.println("Error de validacion: "+ e.getMessage());    
        }
        
        try{
            Revista revista1 = new Revista(15, false, false, "Ciencia hoy", 2015, 80);
            gestor.registrarMaterial(revista1);
        }catch (IllegalArgumentException e){
            System.out.println("No se pudo agregar " + e.getMessage());
        }
        
        try{
            Revista revista2 = new Revista(28, true, false, "Tegnoligia 360", 2024, 120);
            gestor.registrarMaterial(revista2);
        }catch (IllegalArgumentException e){
            System.out.println("No se pudo agregar " + e.getMessage());
        }
        
        
        //Busqueda por titulo
            System.out.println("\nBUSQUEDA POR TITULO");
            ArrayList <Material> busqueda = gestor.buscarPorTitulo("El principito");
            for (Material m : busqueda){
                System.out.println(m.toString());
            }
            
            //listar todos los materiales
           gestor.listarMateriales();

           //Costo reposicion
           gestor.calcularCostoReposicion();
        
    }
    
}
