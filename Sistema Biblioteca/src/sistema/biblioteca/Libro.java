/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.biblioteca;

/**
 *
 * @author Compu
 */
public class Libro extends Material {
    
    private String autor, editorial, version;
    private String numPaginas;

    public Libro(String autor, String editorial, String version, String numPaginas, String codigoMaterial, String nombre, String fechaPublicacion) {
        super(codigoMaterial, nombre, fechaPublicacion);
        this.autor = autor;
        this.editorial = editorial;
        this.version = version;
        this.numPaginas = numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString()+ " autor: " + autor + ", editorial: " + editorial + ", version: " + version + ", numPaginas: " + numPaginas + '}';
    }
    
    

    @Override
    void prestar() {
        System.out.println("Se presta libro por 2 semanas....");
    }
    
    public void buscarLibrosMismoAutor(){
        System.out.println("cliente solicitar buscar libros del mismo autor");
    }
    
}
