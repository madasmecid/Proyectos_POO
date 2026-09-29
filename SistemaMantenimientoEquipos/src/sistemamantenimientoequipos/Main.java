/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemamantenimientoequipos;

/**
 *
 * @author Compu
 */
public class Main {
    public static void main(String[] args) {
        TallerGestor taller = new TallerGestor();

        System.out.println("--- 1. CREACIÓN VÁLIDA ---");
        try {
            // horasUso, codigo, costoBase
            // Base: 100.000 -> Total: (100.000 * 1.10) + (50 * 200 = 10.000) = 120.000
            EquipoIndustrial eq1 = new EquipoIndustrial(50, "EQ-01", 100000);
            taller.agregarEquipo(eq1);
            System.out.println("Equipo ingresado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear equipo: " + e.getMessage());
        }

        System.out.println("\n--- 2. DETALLE ANTES DE GARANTÍA ---");
        taller.mostrarEquipos();

        System.out.println("\n--- 3. APLICANDO GARANTÍA (20%) ---");
        // Base baja de 100.000 a 80.000 (-20%)
        // Nuevo Total: (80.000 * 1.10 = 88.000) + 10.000 = 98.000
        taller.aplicarGarantia();

        System.out.println("\n--- 4. DETALLE TRAS GARANTÍA ---");
        taller.mostrarEquipos();

        System.out.println("\n--- 5. PRUEBAS DEFENSIVAS ---");

        // Caso 1: Horas de uso <= 0
        try {
            System.out.println("Test 1: Horas de uso en 0...");
            EquipoIndustrial errHoras = new EquipoIndustrial(0, "EQ-ERR", 50000);
            System.out.println("FALLO: Permitió horas de uso <= 0");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 2: Código vacío
        try {
            System.out.println("Test 2: Código vacío...");
            EquipoIndustrial errCod = new EquipoIndustrial(20, "   ", 50000);
            System.out.println("FALLO: Permitió código vacío");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 3: Costo base <= 0
        try {
            System.out.println("Test 3: Costo base negativo...");
            EquipoIndustrial errCosto = new EquipoIndustrial(20, "EQ-02", -1000);
            System.out.println("FALLO: Permitió costo base negativo");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 4: Agregar objeto nulo al gestor
        try {
            System.out.println("Test 4: Agregar nulo al gestor...");
            taller.agregarEquipo(null);
            System.out.println("FALLO: Permitió agregar nulo");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }
    }
}