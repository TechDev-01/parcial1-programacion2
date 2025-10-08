package gestionBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String cedula;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.librosPrestados = new ArrayList<>();
    }

    public boolean puedePrestar() {
        return librosPrestados.size() < 3;
    }

    public void agregarLibro(Libro libro) {
        if (puedePrestar()) {
            librosPrestados.add(libro);
        }
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return nombre + " (Cédula: " + cedula + ")";
    }
}
