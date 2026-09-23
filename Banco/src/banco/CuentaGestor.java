/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author SB-Alumno
 */
public class CuentaGestor {
    private ArrayList<CuentaBancaria> cuentas;

    public CuentaGestor() {
        this.cuentas = new ArrayList<>();
    }
    
    public void agregarCuenta(CuentaBancaria cuenta){
        if (cuenta == null){
            System.out.println("No se puede agregar cuenta nula.");
        }else{
            cuentas.add(cuenta);
            System.out.println("Se agrego la cuenta: " + cuenta.getNumeroCuenta());
        }       
    }
    
    public void mostrarCuentas(){
        System.out.println("----LISTA DE CUENTAS----");
        if(cuentas.isEmpty()){
            System.out.println("No hay cuentas para mostrar");
        }else{
            for(CuentaBancaria c : cuentas){
                System.out.println("Cuenta: "+ c.toString());
            }
        }
    }
    
    public CuentaBancaria buscarCuenta(String numeroCuenta){
        for (CuentaBancaria c : cuentas){
            if (c.getNumeroCuenta().equalsIgnoreCase(numeroCuenta.trim())){
                return c;
            }
        }
        return null;
    }
        
    
    
    
}
