package cl.duoc.gestormenbresiagimnasiotp2.modelo;

public class SocioVip extends Socio {
    private int sesionesPerzonalizadas;

    public SocioVip(String rut, String nombre, int sesionesPerzonalizadas) {
        super(rut, nombre);
        this.sesionesPerzonalizadas = sesionesPerzonalizadas;
    }

    public int getSesionesPerzonalizadas() {
        return sesionesPerzonalizadas;
    }

    public void setSesionesPerzonalizadas(int sesionesPerzonalizadas) {
        this.sesionesPerzonalizadas = sesionesPerzonalizadas;
    }

    @Override
    public int calcularCuotaMensual() {
        return 45000 + (sesionesPerzonalizadas * 12000);
    }
}
