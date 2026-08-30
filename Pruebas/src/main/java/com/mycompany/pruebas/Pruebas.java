/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebas;

/**
 *
 * @author Compu
 */
public class Pruebas {

    public static void main(String[] args) {
        
        
       try {
           String nombre = null;
           System.out.println(nombre.length());
       } catch (NullPointerException e) {
           System.out.println(e.getMessage());
       }
    }
}
