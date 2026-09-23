/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author SB-Alumno
 */
public class CuentaInversion extends CuentaBancaria implements IInvertible {
    private double saldoInvertido;

    public CuentaInversion() {
    }

    public CuentaInversion(double saldoInvertido, String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
        setSaldoInvertido(saldoInvertido);
    }

    public double getSaldoInvertido() {
        return saldoInvertido;
    }

    public void setSaldoInvertido(double saldoInvertido) {
        if( saldoInvertido <= 0){
            throw new IllegalArgumentException("El saldo a invertir no puede ser 0 o menor a 0");
        }
        this.saldoInvertido = saldoInvertido;
    }
    
    
    

    @Override
    void retiro(double monto) {
         double nuevoMonto = 0;
        if (monto <= 0){
            System.out.println("No se puede realizar el retiro. Su saldo es: " + super.getSaldo());
        }else{
            nuevoMonto =super.getSaldo() - monto;
            super.setSaldo(nuevoMonto);
            System.out.println("Retiro exitoso de su cuenta de inversion. Su nuevo saldo es: "+ super.getSaldo());
        }
    }

    @Override
    public boolean invertir(double monto) {
        if (monto > 0) {
            super.setSaldo(super.getSaldo() + saldoInvertido );
            saldoInvertido = monto;
            return true;
        }
        return false;
    }

    @Override
     void deposito(double monto) {
       double nuevoMonto = 0;
        if(monto <= 0){
            System.out.println("No se pudo realizar el deposito. Su saldo es: " + super.getSaldo());
        }else{
            nuevoMonto = monto + super.getSaldo();
            super.setSaldo(nuevoMonto);
            System.out.println("Deposito exitoso en su cuenta de Inversion. Su nuevo saldo es: " + super.getSaldo());
        }
    }
    
    
}
