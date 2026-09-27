/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemagestionvehiculos;

/**
 *
 * @author Compu
 */
public class Main {
    public static void main(String[] args) {
        VehiculoGestor gestor = new VehiculoGestor();

        System.out.println("--- 1. CREANDO VEHÍCULOS ---");
        try {
            // Vehículos de Carga: toneladas, patente, precio base
            VehiculoCarga camion1 = new VehiculoCarga(2, "CA-1001", 10000000); 
            VehiculoCarga camion2 = new VehiculoCarga(5, "CA-2002", 15000000); 
            
            // Vehículos Eléctricos: nivel batería, patente, precio base
            VehiculoElectrico autoE1 = new VehiculoElectrico(50, "EL-3001", 20000000); 
            VehiculoElectrico autoE2 = new VehiculoElectrico(80, "EL-4002", 25000000); 

            // Agregamos los vehículos al gestor
            gestor.agregarVehiculo(camion1);
            gestor.agregarVehiculo(camion2);
            gestor.agregarVehiculo(autoE1);
            gestor.agregarVehiculo(autoE2);
            
            System.out.println("Vehículos creados y agregados exitosamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear un vehículo: " + e.getMessage());
        }

        System.out.println("\n--- 2. MOSTRANDO TODOS LOS VEHÍCULOS ---");
        gestor.mostrarVehiculos();

        System.out.println("\n--- 3. RECARGANDO BATERÍAS (SOLO ELÉCTRICOS) ---");
        gestor.cargarBaterias();

        System.out.println("\n--- 4. ESTADO DESPUÉS DE LA RECARGA ---");
        gestor.mostrarVehiculos();

        System.out.println("\n--- 5. PRUEBA DEFENSIVA (EXCEPCIONES) ---");
        try {
            System.out.println("Intentando crear un vehículo con batería mayor a 100...");
            VehiculoElectrico autoMalo = new VehiculoElectrico(150, "ERR-999", 5000000);
            System.out.println("Si ves este mensaje, tu constructor NO lanzó la excepción.");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando crear un vehículo con precio base negativo...");
            VehiculoCarga camionMalo = new VehiculoCarga(3, "ERR-888", -1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}