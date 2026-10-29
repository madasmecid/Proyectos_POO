package cl.duoc.gestormascotasfx;

public class Mascota {
    private String chip;
    private String nombre;
    private  double peso;
    private String tipo;

    public Mascota() {
    }

    public Mascota(String chip, String nombre, double peso, String tipo) {
        this.chip = chip;
        this.nombre = nombre;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
