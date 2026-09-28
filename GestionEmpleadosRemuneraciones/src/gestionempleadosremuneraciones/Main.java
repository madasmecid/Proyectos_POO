/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionempleadosremuneraciones;

/**
 *
 * @author Compu
 */
public class Main {
    public static void main(String[] args) {
        EmpresaGestor gestor = new EmpresaGestor();

        System.out.println("--- 1. CREANDO EMPLEADOS VÁLIDOS ---");
        try {
            // EmpleadoPlanta: aniosAntiguedad, rut, sueldoBase
            // Base: 800.000 -> Líquido base (80%): 640.000 + Antigüedad (5 años * 3% = 15% de 800.000 = 120.000) -> 760.000
            EmpleadoPlanta ep1 = new EmpleadoPlanta(5, "11.111.111-1", 800000);

            // Base: 1.000.000 -> Líquido base (80%): 800.000 + Antigüedad (0 años = 0) -> 800.000
            EmpleadoPlanta ep2 = new EmpleadoPlanta(0, "22.222.222-2", 1000000);

            // EmpleadoComision: ventasMes, rut, sueldoBase
            // Base: 600.000 -> Líquido base (80%): 480.000 + Comisión (5% de 2.000.000 = 100.000) -> 580.000
            EmpleadoComision ec1 = new EmpleadoComision(2000000, "33.333.333-3", 600000);

            // Base: 500.000 -> Líquido base (80%): 400.000 + Comisión (5% de 5.000.000 = 250.000) -> 650.000
            EmpleadoComision ec2 = new EmpleadoComision(5000000, "44.444.444-4", 500000);

            gestor.agregarEmpleado(ep1);
            gestor.agregarEmpleado(ep2);
            gestor.agregarEmpleado(ec1);
            gestor.agregarEmpleado(ec2);

            System.out.println("Empleados agregados correctamente al gestor.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error inesperado en creación: " + e.getMessage());
        }

        System.out.println("\n--- 2. PLANILLA INICIAL ---");
        gestor.mostrarPlanilla();

        System.out.println("\n--- 3. APLICANDO BONOS A COMISIONISTAS ---");
        // ec1: ventas suben de 2.000.000 a 2.200.000 (+10%) -> nueva comisión: 110.000 -> nuevo líquido: 590.000
        // ec2: ventas suben de 5.000.000 a 5.500.000 (+10%) -> nueva comisión: 275.000 -> nuevo líquido: 675.000
        gestor.pagarBonos();

        System.out.println("\n--- 4. PLANILLA TRAS BONIFICACIÓN ---");
        gestor.mostrarPlanilla();

        System.out.println("\n--- 5. PRUEBAS DEFENSIVAS (CAPTURA DE EXCEPCIONES) ---");

        // Caso 1: Sueldo base negativo o cero
        try {
            System.out.println("Test 1: Creando empleado con sueldo base <= 0...");
            EmpleadoPlanta errorSueldo = new EmpleadoPlanta(2, "55.555.555-5", -100);
            System.out.println("FALLO: Se permitió sueldo negativo.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 2: RUT vacío o con puros espacios
        try {
            System.out.println("Test 2: Creando empleado con RUT vacío...");
            EmpleadoComision errorRut = new EmpleadoComision(1000000, "   ", 500000);
            System.out.println("FALLO: Se permitió RUT vacío.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 3: Antigüedad negativa
        try {
            System.out.println("Test 3: Creando empleado con años de antigüedad negativos...");
            EmpleadoPlanta errorAntiguedad = new EmpleadoPlanta(-3, "66.666.666-6", 700000);
            System.out.println("FALLO: Se permitió antigüedad negativa.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }

        // Caso 4: Agregar empleado nulo al gestor
        try {
            System.out.println("Test 4: Intentando agregar 'null' al gestor...");
            gestor.agregarEmpleado(null);
            System.out.println("FALLO: Se permitió agregar un objeto nulo.");
        } catch (IllegalArgumentException e) {
            System.out.println("ÉXITO: " + e.getMessage());
        }
    }
}
