package cl.duoc.sistemagimnasio.modelo;

public class SocioEstudiante extends Socio{
    private int diasClases;

    public SocioEstudiante(String rut, String nombre, int diasClases) {
        super(rut, nombre);
        this.diasClases = diasClases;
    }

    public int getDiasClases() {
        return diasClases;
    }

    public void setDiasClases(int diasClases) {
        this.diasClases = diasClases;
    }

    @Override
    public int calcularCostoMensual() {
        return 25000 + (diasClases * 100);
    }
}
