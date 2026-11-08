package cl.duoc.gestorvehiculostp2.modelo;

public class Auto extends Vehiculo {

    private int numeroPasajeros;

    public Auto(String patente, String marca, int numeroPasajeros) {
        super(patente, marca);
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    @Override
    public int calcularCostoDiario() {
        return 30000 +(numeroPasajeros * 2000);
    }
}
