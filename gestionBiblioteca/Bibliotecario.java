package gestionBiblioteca;

public class Bibliotecario {
    private String nombre;
    private String idEmpleado;

    public Bibliotecario(String nombre, String idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    public boolean verificarDisponibilidad(Libro libro) {
        return libro.isDisponible();
    }

    public boolean verificarLimite(Usuario usuario) {
        return usuario.puedePrestar();
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        if (verificarDisponibilidad(libro) && verificarLimite(usuario)) {
            usuario.agregarLibro(libro);
            libro.cambiarEstado(false);
            return new Prestamo(usuario, libro);
        }
        return null; 
    }

    public Multa registrarDevolucion(Prestamo prestamo) {
        prestamo.registrarDevolucion();
        prestamo.getUsuario().devolverLibro(prestamo.getLibro());
        prestamo.getLibro().cambiarEstado(true);

        long dias = prestamo.calcularDiasPrestamo();
        if (dias > 15) {
            int atraso = (int) (dias - 15);
            return new Multa(atraso);
        }
        return null; 
    }
}
