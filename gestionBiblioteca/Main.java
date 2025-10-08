package gestionBiblioteca;

import java.time.LocalDate;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Bibliotecario bibliotecario = new Bibliotecario("Laura", "EMP001");

        Usuario usuario1 = new Usuario("Carlos Pérez", "12345");
        biblioteca.registrarUsuario(usuario1);

        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "ISBN001", 500);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", "ISBN002", 120);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        //prestamo 1: hace 10 días (NO hay multa)
        Prestamo prestamo1 = new Prestamo(usuario1, libro1);
        biblioteca.agregarPrestamo(prestamo1);
        prestamo1.registrarDevolucion();
        Multa multa1 = bibliotecario.registrarDevolucion(prestamo1);

        if (multa1 == null) {
            System.out.println("Devolución del libro '" + libro1 + "' sin multa.");
        }

        //prestamo 2: hace 20 días (SÍ hay multa → 5 días atraso)
        Prestamo prestamo2 = new Prestamo(usuario1, libro2);
        biblioteca.agregarPrestamo(prestamo2);
        prestamo2.registrarDevolucion();
        Multa multa2 = bibliotecario.registrarDevolucion(prestamo2);

        if (multa2 != null) {
            System.out.println("Devolución del libro '" + libro2 + "' con multa:");
            System.out.println(multa2);
        }
    }
}
