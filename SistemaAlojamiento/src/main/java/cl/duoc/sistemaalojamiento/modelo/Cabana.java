package cl.duoc.sistemaalojamiento.modelo;

public class Cabana extends Alojamiento {
    private int capacidadPersonas;

    public Cabana(String codigo, String nombre, int capacidadPersonas) {
        super(codigo, nombre);
        this.capacidadPersonas = capacidadPersonas;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    @Override
    public int calcularPrecioNoche() {
        return 60000 + (capacidadPersonas * 5000);
    }
}
