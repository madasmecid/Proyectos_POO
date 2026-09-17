/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca2;

import java.util.ArrayList;

/**
 *
 * @author madas
 */
public class GestorBiblioteca {
    private ArrayList<Material> materiales;

    public GestorBiblioteca(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    GestorBiblioteca() {
        this.materiales = new ArrayList<>();
    }
    
    public void registrarMaterial(Material material){
        if(material == null){
            throw new IllegalArgumentException ("No se puede registrar un material nulo");
        }
        this.materiales.add(material);
        System.out.println("Material registrado correctamente: "+ material.getTitulo());
    }
    
    public ArrayList<Material> buscarPorTitulo(String titulo){
        ArrayList<Material> resultados = new ArrayList<>();
        if(titulo != null){
            for(Material m : this.materiales){
                if(m.getTitulo().equalsIgnoreCase(titulo.trim())){
                    resultados.add(m);
                }
            }
        }
        return resultados;
    }
    
    public ArrayList<Material> getMateriales(){
        return materiales;
    }
    
    public void calcularCostoReposicion(){
        System.out.println("-----COSTO DE REPOSICION----");
        for (Material m: this.materiales){
            System.out.printf("%s: $%.0f\n", m.getTitulo(), m.calcularCostoReposicion());
        }
    }
    
    public void listarMateriales(){
        System.out.println("\nMATERIALES REGISTRADOS");
        for (Material m : this.materiales){
            System.out.println(m.toString());
        }
    }
    
    
}
