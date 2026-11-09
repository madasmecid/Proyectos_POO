package cl.duoc.registroalquilervehiculo.modelo;

public abstract class Vehiculo {
    private String patente, marca;

    public Vehiculo(String patente, String marca) {
        this.patente = patente;
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

    public abstract int calcularCostoDiario();
}
