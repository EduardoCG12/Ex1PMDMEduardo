package com.example.ex1pmdmeduardo;

public class Animal {
    private String nombre;
    private int imagen;

    public Animal(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen=imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
