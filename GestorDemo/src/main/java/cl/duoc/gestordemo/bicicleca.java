package cl.duoc.gestordemo;

public class bicicleca {
    private String marca;
    private String tipo;


    public bicicleca() {
    }

    public bicicleca(String marca, String tipo) {
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
