package cl.duoc.sistemaalojamiento.modelo;

public class Habitacion extends Alojamiento{
    private boolean esVip;

    public Habitacion(String codigo, String nombre, boolean esVip) {
        super(codigo, nombre);
        this.esVip = esVip;
    }

    public boolean isEsVip() {
        return esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }


    @Override
    public int calcularPrecioNoche() {
        return esVip ? (40000 + 15000 ): 40000;
    }
}
