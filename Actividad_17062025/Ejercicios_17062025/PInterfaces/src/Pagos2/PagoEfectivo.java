    package Pagos2;

//PagoEfectivo: simula pago en efectivo (dar cambio, etc)
public class PagoEfectivo implements MetodoPago{    
    private double cantidad; //lo que se debe pagar
    private double cantidad_dada;
    private double cambio;
    private String mensaje;
    

    public PagoEfectivo() {
    }

    public PagoEfectivo(double cantidad, double cantidad_dada, double cambio, String mensaje) {
        this.cantidad = cantidad;
        this.cantidad_dada = cantidad_dada;

        calcularCambio();
        
    }


    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad_dada() {
        return this.cantidad_dada;
    }

    public void setCantidad_dada(double cantidad_dada) {
        this.cantidad_dada = cantidad_dada;
    }

    public double getCambio() {

        return this.cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public String getMensaje() {

        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }    


    public void calcularCambio(){

        if ( this.cantidad_dada >= this.cantidad){
            this.cambio = this.cantidad_dada - this.cantidad;
            this.mensaje = "Pago correcto!";
        }else{
            this.cambio = 0;
            this.mensaje = "Falta la cantidad a pagar de " + (this.cantidad - this.cantidad_dada);
        }        
    }

    @Override
    //Cada clase debe imprimir un mensaje diferente cuando se procesa el pago.
    public void procesarPago(double cantidad){
        setCantidad(cantidad);

        calcularCambio();

        System.out.println(toString());  
    }    


    @Override
    public String toString() {
        return "Pago Efectivo:\n" +
            " Pago de: " + getCantidad() + "\t" +
            " A Cuenta: " + getCantidad_dada() + "\t" +
            " Cambio de: " + getCambio() + "\n" +
            getMensaje();            
    }


}
