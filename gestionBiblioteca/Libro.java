package gestionBiblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private int numeroPaginas;
    private boolean disponible; // true = disponible, false = prestado

    public Libro(String titulo, String autor, String ISBN, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
        this.disponible = true; // por defecto al crear está disponible
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void cambiarEstado(boolean estado) {
        this.disponible = estado;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (ISBN: " + ISBN + ")";
    }
}
