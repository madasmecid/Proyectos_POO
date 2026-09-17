/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca2;

/**
 *
 * @author madas
 */
public class Libro extends Material {
    
    private String autor;
    private String genero;
    private boolean disponiblePrestamoExtendido;

    public Libro() {
    }

    public Libro(String autor, String genero, boolean disponiblePrestamoExtendido, String titulo, int anioPublicacion, int paginas) {
        super(titulo, anioPublicacion, paginas);
        setAutor(autor);
        setGenero(genero);
        this.disponiblePrestamoExtendido = disponiblePrestamoExtendido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor == null || autor.trim().isEmpty()){
            throw new IllegalArgumentException("Autor no puede estar vacio");
        }
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()){
            System.out.println("EL genero no puede quedar vacio");
        }
        this.genero = genero;
    }

    public boolean isDisponiblePrestamoExtendido() {
        return disponiblePrestamoExtendido;
    }

    public void setDisponiblePrestamoExtendido(boolean disponiblePrestamoExtendido) {
        this.disponiblePrestamoExtendido = disponiblePrestamoExtendido;
    }
    
    

    @Override
    public double calcularCostoReposicion() {
        double costo = 20000;
        if(getPaginas()> 500){
            costo += costo * 0.20;
    }
        return costo;
    }
    
}
