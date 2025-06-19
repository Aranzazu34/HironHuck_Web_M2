package Pagos2;

// PagoTarjeta: simula pago con tarjeta, con el número de PIN etc
public class PagoTarjeta implements MetodoPago{
    private double cantidad;
    private int pin;


    public PagoTarjeta() {
    }

    public PagoTarjeta(double cantidad, int pin) {
        this.cantidad = cantidad;
        this.pin = pin;
    }


    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    @Override
    //Cada clase debe imprimir un mensaje diferente cuando se procesa el pago.
    public void procesarPago(double cantidad){
        setCantidad(cantidad);

        System.out.println(toString());  
    }


    @Override
    public String toString() {
        return "Pago Tarjeta:\n" +
            " Pago de: " + getCantidad() + "\t" +
            " Pin: " + getPin();
    }


}
