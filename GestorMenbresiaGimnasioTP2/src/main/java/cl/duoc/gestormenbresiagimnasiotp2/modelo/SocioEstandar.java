package cl.duoc.gestormenbresiagimnasiotp2.modelo;

public class SocioEstandar extends Socio {

    private int accesoLocker;

    public SocioEstandar(String rut, String nombre, int accesoLocker) {
        super(rut, nombre);
        this.accesoLocker = accesoLocker;
    }

    public int getAccesoLocker() {
        return accesoLocker;
    }

    public void setAccesoLocker(int accesoLocker) {
        this.accesoLocker = accesoLocker;
    }


    @Override
    public int calcularCuotaMensual() {
        return 25000 + (accesoLocker * 1000);
    }
}
