package cl.duoc.gestorvehiculostp2.modelo;

public abstract class Vehiculo {
    private String marca, patente;

    public Vehiculo(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String modelo) {
        this.patente = patente;
    }

    public abstract int calcularCostoDiario();
}
