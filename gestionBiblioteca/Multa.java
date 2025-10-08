package gestionBiblioteca;

public class Multa {
    private static final double VALOR_DIA = 2000.0;
    private int diasAtraso;
    private double monto;

    public Multa(int diasAtraso) {
        this.diasAtraso = diasAtraso;
        this.monto = calcularMulta(diasAtraso);
    }

    private double calcularMulta(int diasAtraso) {
        return diasAtraso * VALOR_DIA;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Multa: $" + monto + " por " + diasAtraso + " días de atraso.";
    }
}
