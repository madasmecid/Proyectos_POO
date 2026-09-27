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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VehiculoCarga carga1 = new VehiculoCarga(2, "ert-33", 1000);
        
        System.out.println(carga1.calcularPrecioFinal());
        
        VehiculoElectrico electrico1 = new VehiculoElectrico(40, "444r", 2000);
        
        System.out.println(electrico1.calcularPrecioFinal());
    }
    
}
