import java.util.List;

public class CodSmell {

    public void procesarPedido(int idCliente, String nombreCliente, String direccionCliente,
                                List<Integer> idsProductos, List<Integer> cantidades,
                                boolean descuento, double porcentajeDescuento,
                                boolean envioExpress, String metodoPago) {

        double total = calcularTotal(idsProductos, cantidades, descuento, porcentajeDescuento);
        
        if (envioExpress) {
            total += obtenerCostoEnvioExpress();
        }

        procesarPago(metodoPago);
        
        enviarEmail(nombreCliente, direccionCliente, total);
        
        actualizarInventario(idsProductos, cantidades);
    }

    private double calcularTotal(List<Integer> idsProductos, List<Integer> cantidades,
                                 boolean descuento, double porcentajeDescuento) {
        double total = 0;
        for (int i = 0; i < idsProductos.size(); i++) {
            total += obtenerPrecioProducto(idsProductos.get(i)) * cantidades.get(i);
        }

        if (descuento) {
            total -= total * porcentajeDescuento;
        }

        return total;
    }

    private double obtenerPrecioProducto(int idProducto) {
        return idProducto * 10.0; // Simulación de base de datos
    }

    private double obtenerCostoEnvioExpress() {
        return 10.0;
    }

    private void procesarPago(String metodoPago) {
        switch (metodoPago) {
            case "tarjeta":
                System.out.println("Procesando pago con tarjeta...");
                break;
            case "paypal":
                System.out.println("Procesando pago con PayPal...");
                break;
            default:
                System.out.println("Método de pago no soportado.");
                break;
        }
    }
    private void enviarEmail(String nombreCliente, String direccionCliente, double total) {
        System.out.println("Enviando email a: " + nombreCliente);
        System.out.println("Dirección de envío: " + direccionCliente);
        System.out.println("Total: $" + total);
    }
    private void actualizarInventario(List<Integer> idsProductos, List<Integer> cantidades) {
        for (int i = 0; i < idsProductos.size(); i++) {
            System.out.println("Actualizando inventario: Producto " + idsProductos.get(i) + ", reducido en " + cantidades.get(i) + " unidades");
        }
    }
}
