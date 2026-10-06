package com.example.gestorpeliculas;

public class Pelicula {

    private String titulo;
    private String Director;
    private int annio;

    public Pelicula(String titulo, int annio, String director) {
        this.titulo = titulo;
        this.annio = annio;
        Director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }
}
