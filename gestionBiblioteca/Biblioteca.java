package gestionBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;
    private List<Prestamo> listaPrestamos;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarLibro(String ISBN) {
        for (Libro libro : listaLibros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario obtenerUsuario(String cedula) {
        for (Usuario u : listaUsuarios) {
            if (u.getCedula().equals(cedula)) {
                return u;
            }
        }
        return null;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }
}
