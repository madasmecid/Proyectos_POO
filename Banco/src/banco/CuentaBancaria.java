/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author SB-Alumno
 */
public abstract class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, double saldo) {
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldo);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if(numeroCuenta == null || numeroCuenta.trim().isEmpty()){
            throw new IllegalArgumentException("Numero de cuenta no puede quedar vacio.");
        }
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0){
            throw new IllegalArgumentException("Saldo no puede quedar vacio");
        }
        this.saldo = saldo;
    }
    
    abstract void deposito(double monto);
    
    abstract void retiro (double monto);

    @Override
    public String toString() {
        return "numeroCuenta: " + numeroCuenta + ", saldo: $" +(long) saldo;
    }
    
    
    
    
}
