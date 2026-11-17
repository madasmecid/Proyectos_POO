package cl.duoc.tiendamusica.model;

public abstract class Instrumento {
    private String marca;
    private String codigo;

    public Instrumento() {
    }

    public Instrumento(String marca, String codigo) {
        this.marca = marca;
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract int calcularPrecioArriendo();
}
