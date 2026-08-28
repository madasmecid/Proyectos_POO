/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.biblioteca;

/**
 *
 * @author Compu
 */
public class Revista extends Material {
    
    private String edicion, temaActual, publicacion;

    public Revista(String edicion, String temaActual, String publicacion, String codigoMaterial, String nombre, String fechaPublicacion) {
        super(codigoMaterial, nombre, fechaPublicacion);
        this.edicion = edicion;
        this.temaActual = temaActual;
        this.publicacion = publicacion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getTemaActual() {
        return temaActual;
    }

    public void setTemaActual(String temaActual) {
        this.temaActual = temaActual;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Revista{" + super.toString()+ " edicion: " + edicion + ", temaActual: " + temaActual + ", publicacion: " + publicacion + '}';
    }
    
    
    

    @Override
    void prestar() {
        System.out.println("Se presta revista solo para leer en las instalaciones...");
    }
    
    public void consultarMismoContenido(){
        System.out.println("El cliente consulta por revistar con el mismo contenido...");
    }
    
}
