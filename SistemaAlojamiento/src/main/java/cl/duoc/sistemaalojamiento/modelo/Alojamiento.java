package cl.duoc.sistemaalojamiento.modelo;

public abstract class Alojamiento {
    private String codigo, nombre;

    public Alojamiento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public abstract int calcularPrecioNoche();
}
