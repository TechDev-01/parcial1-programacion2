package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Plato {
        private String nombre;
        private double precio;
        private String categoria;
        private int tiempoPreparacion;

        public Plato(String nombre, double precio, String categoria, int tiempoPreparacion) {
            this.nombre = nombre;
            this.precio = precio;
            this.categoria = categoria;
            this.tiempoPreparacion = tiempoPreparacion;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public int getTiempoPreparacion() {
            return tiempoPreparacion;
        }
    }

    // ---------------- CLASE MESERO ----------------
    static class Mesero {
        private String nombre;
        private String codigo;
        private int mesasAtendidas;

        public Mesero(String nombre, String codigo) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.mesasAtendidas = 0;
        }

        public void registrarMesa() {
            mesasAtendidas++;
        }

        public Pedido crearPedido(int numeroMesa, List<Plato> listaPlatos, String hora) {
            registrarMesa();
            return new Pedido(numeroMesa, listaPlatos, hora);
        }

        public String getNombre() {
            return nombre;
        }

        public int getMesasAtendidas() {
            return mesasAtendidas;
        }
    }

    // ---------------- CLASE PEDIDO ----------------
    static class Pedido {
        private int numeroMesa;
        private List<Plato> listaPlatos;
        private String horaPedido;
        private double subtotal;
        private double descuento;
        private int tiempoEstimado;

        public Pedido(int numeroMesa, List<Plato> listaPlatos, String horaPedido) {
            this.numeroMesa = numeroMesa;
            this.listaPlatos = listaPlatos;
            this.horaPedido = horaPedido;
            this.subtotal = calcularSubtotal();
            this.descuento = calcularDescuento();
            this.tiempoEstimado = calcularTiempoEstimado();
        }

        private double calcularSubtotal() {
            double suma = 0;
            for (Plato p : listaPlatos) {
                suma += p.getPrecio();
            }
            return suma;
        }

        private double calcularDescuento() {
            if (subtotal > 50000) {
                return subtotal * 0.10;
            }
            return 0;
        }

        private int calcularTiempoEstimado() {
            int tiempo = 0;
            for (Plato p : listaPlatos) {
                tiempo += p.getTiempoPreparacion();
            }
            return tiempo;
        }

        public Cuenta generarCuenta() {
            return new Cuenta(subtotal, descuento);
        }

        public int getNumeroMesa() {
            return numeroMesa;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public double getDescuento() {
            return descuento;
        }

        public int getTiempoEstimado() {
            return tiempoEstimado;
        }
    }

    // ---------------- CLASE CUENTA ----------------
    static class Cuenta {
        private double subtotal;
        private double descuento;
        private double iva;
        private double totalPagar;

        public Cuenta(double subtotal, double descuento) {
            this.subtotal = subtotal;
            this.descuento = descuento;
            this.iva = calcularIVA();
            this.totalPagar = calcularTotalPagar();
        }

        private double calcularIVA() {
            return (subtotal - descuento) * 0.19;
        }

        private double calcularTotalPagar() {
            return (subtotal - descuento) + iva;
        }

        public void mostrarCuenta() {
            System.out.println("--------- CUENTA ---------");
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Descuento: $" + descuento);
            System.out.println("IVA (19%): $" + iva);
            System.out.println("TOTAL A PAGAR: $" + totalPagar);
            System.out.println("--------------------------");
        }
    }

    // ---------------- CLASE PRINCIPAL ----------------
    public class p2_parcial1 {
        public static void main(String[] args) {
            // Crear algunos platos
            Plato p1 = new Plato("Ensalada", 15000, "Entrada", 10);
            Plato p2 = new Plato("Carne Asada", 35000, "Plato fuerte", 25);
            Plato p3 = new Plato("Helado", 12000, "Postre", 5);

            // Crear un mesero
            Mesero mesero1 = new Mesero("Carlos", "M001");

            // Lista de platos solicitados
            List<Plato> pedidoPlatos = new ArrayList<>();
            pedidoPlatos.add(p1);
            pedidoPlatos.add(p2);
            pedidoPlatos.add(p3);

            // Crear pedido
            Pedido pedido1 = mesero1.crearPedido(5, pedidoPlatos, "12:30 PM");

            // Generar cuenta
            Cuenta cuenta1 = pedido1.generarCuenta();
            cuenta1.mostrarCuenta();

            // Mostrar información adicional
            System.out.println("Tiempo estimado de entrega: " + pedido1.getTiempoEstimado() + " minutos");
            System.out.println("Mesas atendidas por " + mesero1.getNombre() + ": " + mesero1.getMesasAtendidas());
        }
    }
}
