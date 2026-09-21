package model;

public class Etiqueta extends Insumo {
    private String tipoEtiqueta; // Ej: "COLLERIN", "FRONTAL", "CONTRA"

    public Etiqueta() {
    }

    public Etiqueta(String tipoEtiqueta, String codigo, String nombre, int stockActual) {
        super(codigo, nombre, stockActual);
        setTipoEtiqueta(tipoEtiqueta);
    }

    public String getTipoEtiqueta() {
        return tipoEtiqueta;
    }

    public void setTipoEtiqueta(String tipoEtiqueta) {
        if (tipoEtiqueta == null || tipoEtiqueta.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de etiqueta no puede estar vacío.");
        }
        this.tipoEtiqueta = tipoEtiqueta.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString() + " | Ubicación: " + tipoEtiqueta;
    }
}