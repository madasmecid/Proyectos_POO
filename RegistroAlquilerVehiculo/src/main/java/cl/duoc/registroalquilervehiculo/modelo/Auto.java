package cl.duoc.registroalquilervehiculo.modelo;

public class Auto extends Vehiculo {
    private int pasajeros;

    public Auto(String patente, String marca, int pasajeros) {
        super(patente, marca);
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public int calcularCostoDiario() {
        return 30000 + (pasajeros * 2000);
    }
}
