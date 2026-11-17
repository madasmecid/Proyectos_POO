package cl.duoc.tiendamusica.model;

public class Teclado extends Instrumento {
    private int teclas;

    public Teclado() {
    }

    @Override
    public int calcularPrecioArriendo() {
        return 20000 + (teclas * 200);
    }

    public Teclado(String marca, String codigo, int teclas) {
        super(marca, codigo);
        this.teclas = teclas;
    }

    public int getTeclas() {
        return teclas;
    }

    public void setTeclas(int teclas) {
        this.teclas = teclas;
    }
}
