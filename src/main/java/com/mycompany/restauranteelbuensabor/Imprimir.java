/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Imprimir {

    private static final String SEP = "========================================";

    public static void mostrarCarta() {
        System.out.println(SEP);
        System.out.println("    " + Datos.nombreRestaurante);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEP);

        int i = 0;
        while (i < Datos.getProductos().size()) {
            Producto prod = Datos.getProductos().get(i);
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), prod.getNombre(), prod.getPrecio());
            i++;
        }

        System.out.println(SEP);
    }

    public static void mostrarPedido() {
        double subtotal = calcularSubtotal();

        System.out.println("--- PEDIDO ACTUAL ---");
        imprimirItems();
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {

        double[] datos = calcularTotales();
        double subtotal = datos[0];
        double iva = datos[1];
        double propina = datos[2];
        double total = datos[3];

        imprimirEncabezado("FACTURA No. %03d%n");

        imprimirItems();

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(SEP);
        System.out.println("Gracias por su visita!");
        System.out.println(Datos.nombreRestaurante + " - Valledupar");
        System.out.println(SEP);

        Datos.numeroFactura++;
        Datos.estado = 0;
        Datos.total = total;
    }

    public static void imprimirFacturaResumen() {

        double[] datos = calcularTotales();
        double subtotal = datos[0];
        double iva = datos[1];
        double propina = datos[2];
        double total = datos[3];

        imprimirEncabezado("FACTURA No. %03d (RESUMEN)%n");

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(SEP);
    }

    // ================= MÉTODOS AUXILIARES =================

    private static double calcularSubtotal() {
        double subtotal = 0;
        int i = 0;

        while (i < Datos.getProductos().size()) {
            Producto p = Datos.getProductos().get(i);
            if (p.getCantidad() > 0) {
                subtotal += p.getPrecio() * p.getCantidad();
            }
            i++;
        }
        return subtotal;
    }

    private static void imprimirItems() {
        int i = 0;

        while (i < Datos.getProductos().size()) {
            Producto p = Datos.getProductos().get(i);
            if (p.getCantidad() > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        p.getNombre(),
                        p.getCantidad(),
                        p.getPrecio() * p.getCantidad());
            }
            i++;
        }
    }

    private static void imprimirEncabezado(String formatoFactura) {
        System.out.println(SEP);
        System.out.println("    " + Datos.nombreRestaurante);
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(SEP);
        System.out.printf(formatoFactura, Datos.numeroFactura);
    }

    private static double[] calcularTotales() {

        double subtotal = calcularSubtotal();
        int cantidadItems = contarItems();

        double base = subtotal;

        if (cantidadItems > 3) {
            base -= base * 0.05;
        }

        double iva = base * 0.19;
        double total = base + iva;

        double propina = 0;

        if (base > 50000) {
            propina = total * 0.10;
            total += propina;
        }

        return new double[]{base, iva, propina, total};
    }

    private static int contarItems() {
        int cont = 0;
        int i = 0;

        while (i < Datos.getProductos().size()) {
            if (Datos.getProductos().get(i).getCantidad() > 0) {
                cont++;
            }
            i++;
        }

        return cont;
    }
}
