package model;

public class Tapa extends Insumo {
    private String color;

    public Tapa() {
    }

    public Tapa(String color, String codigo, String nombre, int stockActual) {
        super(codigo, nombre, stockActual);
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("El color o tipo de tapa no puede estar vacío.");
        }
        this.color = color.trim();
    }

    @Override
    public String toString() {
        return super.toString() + " | Color/Tipo: " + color;
    }
}