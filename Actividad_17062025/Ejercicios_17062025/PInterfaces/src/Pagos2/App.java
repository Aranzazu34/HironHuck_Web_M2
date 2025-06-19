package Pagos2;

import java.time.LocalDate;

import Pagos.ProductoVirtual;

public class App {

/*
 * 1.2. Versión 2:

Crea un interface MetodoPago que tenga un método de este tipo:

void procesarPago(double cantidad);

Después, impleméntalo en dos o tres clases, del tipo:

- PagoTarjeta: simula pago con tarjeta, con el número de PIN etc

- PagoEfectivo: simula pago en efectivo (dar cambio, etc)

- PagoBizum, cheque u otros

Cada clase debe imprimir un mensaje diferente cuando se procesa el pago.

Prueba desde el main() a instanciar estas clases y a invocar procesarPago() con distintas cantidades para cada clase.
 */

    public static void main(String[] args) throws Exception {
        
        PagoTarjeta p1 = new PagoTarjeta(250, 1234);

        PagoEfectivo p2 = new PagoEfectivo(1000, 650, 0, null);

        LocalDate fecha = LocalDate.of(2025, 6, 15);
        PagoBizum p3 = new PagoBizum(100, "Amadeo Torner Figuerola", fecha);

                
        p1.procesarPago(500);

        System.out.println("\n------------------------------------------------\n");

        p2.procesarPago(750);

        System.out.println("\n------------------------------------------------\n");

        p3.procesarPago(50);

    }    

}
