package cl.duoc.gestorvehiculostp2.modelo;

public class Camioneta extends  Vehiculo{

    private int capacidadCarga;

    public Camioneta(String patente, String marca, int capacidadCarga) {
        super(patente, marca);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }


    @Override
    public int calcularCostoDiario() {
        return 45000 + (capacidadCarga * 50);
    }
}
