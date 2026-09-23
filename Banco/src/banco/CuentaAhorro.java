/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author SB-Alumno
 */
public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorro() {
    }

    public CuentaAhorro(double tasaInteres, String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
        setTasaInteres(tasaInteres);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        if(tasaInteres < 0){
            throw new IllegalArgumentException("No puede ser menor a 0");
        }
        this.tasaInteres = tasaInteres;
    }
    
    

    @Override
    public void deposito(double monto) {
        double nuevoMonto = 0;
        if(monto <= 0){
            System.out.println("No se pudo realizar el deposito. Su saldo es: " + super.getSaldo());
        }else{
            nuevoMonto = monto + super.getSaldo();
            super.setSaldo(nuevoMonto);
            System.out.println("Deposito exitoso. Su nuevo saldo es: cuenta :" + super.getNumeroCuenta()+ " -- saldo: $" + (long)super.getSaldo());
        }
    }

    @Override
    public void retiro (double monto) {
        double nuevoMonto = 0;
        if (monto <= 0){
            System.out.println("No se puede realizar el retiro. Su saldo es: " + super.getSaldo());
        }else{
            nuevoMonto =super.getSaldo() - monto;
            super.setSaldo(nuevoMonto);
            System.out.println("Retiro exitoso. Su nuevo saldo es: "+ super.getSaldo());
        }
        
    }
    
    public void aplicaInteres(){
        double intereses = super.getSaldo() * tasaInteres;
        double nuevoSaldo = super.getSaldo()+ intereses;
        super.setSaldo(nuevoSaldo);
        
        System.out.println("Se le aplico un interes del "
        + getTasaInteres()+ " a su saldo. nuevo saldo: "+ super.getSaldo());
        
        
    }
    
    
    
}
