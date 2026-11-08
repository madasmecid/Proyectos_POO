package cl.duoc.gestorbicicletas.modelo;

public class Bicicleta {

    private String marca;

    public Bicicleta() {
    }

    public Bicicleta(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
