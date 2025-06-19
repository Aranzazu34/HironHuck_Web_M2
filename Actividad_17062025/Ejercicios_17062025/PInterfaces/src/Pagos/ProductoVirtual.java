package Pagos;

public class ProductoVirtual implements MetodoPago{
    private String id_prod;
    private String nombre;
    private boolean stock;


    public ProductoVirtual() {
    }

    public ProductoVirtual(String id_prod, String nombre, boolean stock) {
        this.id_prod = id_prod;
        this.nombre = nombre;
        this.stock = stock;
    }


    public String getId_prod() {
        return this.id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStock() {
        return this.stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }


    @Override
    public void PagoTarjeta(){
        System.out.println("(PV) Pago por Tarjeta");
    }
    
    @Override
    public void PagoPayPal(){
        System.out.println("(PV) Pago por PayPal");
    }

    @Override
    public void PagoTransferencia(){
        System.out.println("(PV) Pago por Transferencia");
    }

    @Override
    public String toString() {
        return "Producto Virtual:\n" +
            "id_prod: " + getId_prod() + "\n" +
            "Producto: " + getNombre() + "\n" +
            "Stock:'" + (isStock() ? "Sí" : "No") + "\n";
    }


    

}
