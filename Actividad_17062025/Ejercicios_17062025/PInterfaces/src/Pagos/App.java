package Pagos;
public class App {

    /*
     * 1.1. Versión 1:

Crea un interface MetodoPago que tenga unos método vacíos como:

- PagoTarjeta();

- PagoPayPal();

- PagoTransferencia();

-> Crea la clase ProductoFisico

Sobre esa clase, implementa cada uno de los tres métodos (un simple texto personalizado bastará)

-> Crea la clase ProductoVirtual

Sobre esa clase, implementa cada uno de los tres métodos (un simple texto personalizado bastará)
     */
    
    public static void main(String[] args) throws Exception {
        
        ProductoFisico p1 = new ProductoFisico("1A", "Monitor Philips EcoBlue");
        ProductoVirtual p2 = new ProductoVirtual("203", "Frontal 1000 Lumens", false);

        System.out.println(p1.toString());
        System.out.println("===========================================");
        p1.PagoTarjeta();
        p1.PagoPayPal();
        p1.PagoTransferencia();

        System.out.println("\n------------------------------------------------\n");

        System.out.println(p2.toString());
        System.out.println("===========================================");
        p2.PagoTarjeta();
        p2.PagoPayPal();
        p2.PagoTransferencia();



    }
}
