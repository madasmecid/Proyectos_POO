/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorenvioslogisticas;

/**
 *
 * @author Compu
 */
public class GestorEnviosLogisticas {

    /**
     * @param args the command line arguments
     */
    public class Main {
    public static void main(String[] args) {
        EnviosGestor gestor = new EnviosGestor();

        System.out.println("--- 1. CREANDO ENVÍOS VÁLIDOS ---");
        try {
            // EnvioTerrestre: distanciaKm, codigoSeguimiento, costoBase
            // Terrestre 1: Base 5.000 + (100 km * 150 = 15.000) -> Total: 20.000
            EnvioTerrestre et1 = new EnvioTerrestre(100, "TR-001", 5000);
            
            // Terrestre 2: Base 8.000 + (300 km * 150 = 45.000) -> Total: 53.000
            EnvioTerrestre et2 = new EnvioTerrestre(300, "TR-002", 8000);

            // EnvioAereo: pesoKg, codigoSeguimiento, costoBase
            // Aereo 1: Base 20.000 (+12% = 22.400) + (5 kg * 3.500 = 17.500) -> Total: 39.900
            EnvioAereo ea1 = new EnvioAereo(5.0, "AR-101", 20000);

            // Aereo 2: Base 50.000 (+12% = 56.000) + (10 kg * 3.500 = 35.000) -> Total: 91.000
            EnvioAereo ea2 = new EnvioAereo(10.0, "AR-202", 50000);

            gestor.agregarEnvio(et1);
            gestor.agregarEnvio(et2);
            gestor.agregarEnvio(ea1);
            gestor.agregarEnvio(ea2);

            System.out.println("Envíos ingresados correctamente al sistema.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error inesperado en creación: " + e.getMessage());
        }

        System.out.println("\n--- 2. DETALLE INICIAL DE ENVÍOS ---");
        gestor.mostrarEnvios();

        System.out.println("\n--- 3. APLICANDO DESCUENTO PROMOCIONAL (15% SOLO AÉREOS) ---");
        // ea1: Costo base baja de 20.000 a 17.000 (-15%) -> Nuevo Total: (17.000 * 1.12 = 19.040) + 17.500 = 36.540
        // ea2: Costo base baja de 50.000 a 42.500 (-15%) -> Nuevo Total: (42.500 * 1.12 = 47.600) + 35.000 = 82.600
        gestor.aplicarDescuentosPromocionales();

        System.out.println("\n--- 4. DETALLE TRAS PROMOCIÓN ---");
        gestor.mostrarEnvios();

        System.out.println("\n--- 5. PRUEBAS DEFENSIVAS (CAPTURA DE EXCEPCIONES) ---");

        // Caso 1: Costo base negativo
        try {
            System.out.println("Test 1: Creando envío con costo base <= 0...");
            EnvioTerrestre errorCosto = new EnvioTerrestre(50, "TR-ERR", -500);
            System.out.println("FALLO: Se permitió costo base negativo.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 2: Código de seguimiento vacío
        try {
            System.out.println("Test 2: Creando envío con código vacío...");
            EnvioAereo errorCodigo = new EnvioAereo(2.0, "   ", 10000);
            System.out.println("FALLO: Se permitió código vacío.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 3: Distancia terrestre menor o igual a 0
        try {
            System.out.println("Test 3: Creando envío terrestre con distancia <= 0...");
            EnvioTerrestre errorDistancia = new EnvioTerrestre(0, "TR-000", 5000);
            System.out.println("FALLO: Se permitió distancia <= 0.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 4: Peso aéreo menor o igual a 0
        try {
            System.out.println("Test 4: Creando envío aéreo con peso <= 0...");
            EnvioAereo errorPeso = new EnvioAereo(-1.5, "AR-000", 15000);
            System.out.println("FALLO: Se permitió peso <= 0.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 5: Agregar envío nulo al gestor
        try {
            System.out.println("Test 5: Intentando agregar 'null' al gestor...");
            gestor.agregarEnvio(null);
            System.out.println("FALLO: Se permitió agregar un objeto nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }
    }
    }
}

