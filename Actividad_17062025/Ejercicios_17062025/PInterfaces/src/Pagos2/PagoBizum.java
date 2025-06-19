package Pagos2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//PagoBizum, cheque u otros
public class PagoBizum implements MetodoPago {
    private double cantidad;
    private String destino;
    private LocalDate  fbizum;
    

    public PagoBizum() {
    }


    public PagoBizum(double cantidad, String destino, LocalDate fbizum) {
        this.cantidad = cantidad;
        this.destino = destino;
        this.fbizum = fbizum;
    }


    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFbizum() {
        return this.fbizum;
    }

    public void setFbizum(LocalDate fbizum) {
        this.fbizum = fbizum;
    }


    @Override
    //Cada clase debe imprimir un mensaje diferente cuando se procesa el pago.
    public void procesarPago(double cantidad){
        setCantidad(cantidad);

        System.out.println(toString());   
    }    


    @Override
    public String toString() {
        // Definir el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convertir LocalDate a String usando el formateador
        String fechaComoCadena = (getFbizum()).format(formatter);
     

        return "Pago Bizum:\n" +
            " Pago de: " + getCantidad() + "\t" +
            " Destinatario: " + getDestino() + "\t" +
            " Fecha: " + fechaComoCadena
            ;            
    }


    
}
