package cl.duoc.listatareas;

public class Tarea {

    private String descripcion;
    private String estado; // "Pendiente " o  "Completada"

    public Tarea() {
    }

    public Tarea(String estado, String descripcion) {
        this.estado = estado;
        this.descripcion = "Pendiente";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacía");
        }
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void marcaCompletada(){
        this.estado = "Completada";
    }
}
