package cl.duoc.gestorequipos;

public class Equipo {
    private String serie;
    private String marca;
    private int ram;

    public Equipo() {
    }

    public Equipo(String serie, String marca, int ram) {
        this.serie = serie;
        this.marca = marca;
        this.ram = ram;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
