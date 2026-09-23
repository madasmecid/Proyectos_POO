/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

/**
 *
 * @author SB-Alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaGestor gestor = new CuentaGestor();
        
        
        try{
            CuentaAhorro cuentaA1 = new CuentaAhorro(0.05, "ooo", 1000);
            gestor.agregarCuenta(cuentaA1);
            cuentaA1.deposito(9000);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        try{
            CuentaAhorro cuentaA2 = new CuentaAhorro(0.06, "123456", 2000);
            gestor.agregarCuenta(cuentaA2);
            cuentaA2.deposito(90);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        try{
            CuentaInversion cuentaI1 = new CuentaInversion(500, "22222", 400);
            gestor.agregarCuenta(cuentaI1);
            if (cuentaI1.invertir(1000)){
                System.out.println("Su nuevo monto a invertir es: " + cuentaI1.getSaldoInvertido());
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        gestor.mostrarCuentas();
        
        CuentaBancaria cuentaEncontrada = gestor.buscarCuenta("22222");
        
        if (cuentaEncontrada != null){
            try{
                cuentaEncontrada.deposito(1);
            }catch (IllegalArgumentException e) {
                System.out.println("Error " + e.getMessage());
            }
        }else {
            System.out.println("Cuenta no existe.");
        }
        
    }
   
    
}
