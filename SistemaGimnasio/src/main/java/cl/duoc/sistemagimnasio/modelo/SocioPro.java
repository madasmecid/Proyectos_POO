package cl.duoc.sistemagimnasio.modelo;

public class SocioPro extends Socio{
    private int mesesContratado;

    public SocioPro(String rut, String nombre, int mesesContratado) {
        super(rut, nombre);
        this.mesesContratado = mesesContratado;
    }

    public int getMesesContratado() {
        return mesesContratado;
    }

    public void setMesesContratado(int mesesContratado) {
        this.mesesContratado = mesesContratado;
    }

    @Override
    public int calcularCostoMensual() {
        return 60000+ (mesesContratado * 300);
    }
}
