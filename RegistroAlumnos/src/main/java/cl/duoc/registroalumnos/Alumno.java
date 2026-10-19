package cl.duoc.registroalumnos;

public class Alumno {

    private String rut;
    private String nombre;
    private int edad;

    public Alumno() {
    }

    public Alumno(int edad, String nombre, String rut) {
        this.edad = edad;
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
