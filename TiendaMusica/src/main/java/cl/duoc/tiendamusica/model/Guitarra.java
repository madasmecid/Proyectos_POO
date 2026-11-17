package cl.duoc.tiendamusica.model;

public class Guitarra extends Instrumento{
    private int cuerdas;

    public Guitarra() {
    }

    public Guitarra(String marca, String codigo, int cuerdas) {
        super(marca, codigo);
        this.cuerdas = cuerdas;
    }

    @Override
    public int calcularPrecioArriendo() {
        return 15000 + (cuerdas * 1000);
    }

    public int getCuerdas() {
        return cuerdas;
    }

    public void setCuerdas(int cuerdas) {
        this.cuerdas = cuerdas;
    }
}
