package model;

public class Botella extends Insumo {
    private int capacidadMl;

    public Botella() {
    }

    public Botella(int capacidadMl, String codigo, String nombre, int stockActual) {
        super(codigo, nombre, stockActual);
        setCapacidadMl(capacidadMl);
    }

    public int getCapacidadMl() {
        return capacidadMl;
    }

    public void setCapacidadMl(int capacidadMl) {
        if (capacidadMl <= 0) {
            throw new IllegalArgumentException("La capacidad en ml debe ser mayor a 0.");
        }
        this.capacidadMl = capacidadMl;
    }

    @Override
    public String toString() {
        return super.toString() + " | Formato: " + capacidadMl + " ml";
    }
}