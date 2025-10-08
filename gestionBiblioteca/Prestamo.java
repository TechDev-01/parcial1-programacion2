package gestionBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null; // aún no devuelto
    }

    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
    }

    public long calcularDiasPrestamo() {
        LocalDate fin = (fechaDevolucion == null) ? LocalDate.now() : fechaDevolucion;
        return ChronoUnit.DAYS.between(fechaPrestamo, fin);
    }

    public boolean esAtrasado() {
        return calcularDiasPrestamo() > 15;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }
}
