package cl.duoc.registrovehiculosfx;

public class Vehiculo {
    private String patente;
    private String marca;
    private int precio;

    public Vehiculo() {
    }

    public Vehiculo(String patente, int precio, String marca) {
        this.patente = patente;
        this.precio = precio;
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
