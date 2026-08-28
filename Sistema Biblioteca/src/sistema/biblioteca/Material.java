/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.biblioteca;

/**
 *
 * @author Compu
 */
public abstract class Material {
    private String codigoMaterial, nombre, fechaPublicacion;
   

    public Material() {
    }

    public Material(String codigoMaterial, String nombre, String fechaPublicacion) {
        this.codigoMaterial = codigoMaterial;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Material{" + "codigoMaterial: " + codigoMaterial + ", nombre: " + nombre + ", fechaPublicacion: " + fechaPublicacion + '}';
    }

    
    
    abstract void prestar();
    
}
