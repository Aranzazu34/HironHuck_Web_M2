package Pagos;

//Sobre esa clase, implementa cada uno de los tres métodos (un simple texto personalizado bastará)
public class ProductoFisico implements MetodoPago {
    private String id_prod;
    private String producto;


    public ProductoFisico() {
    }



    public ProductoFisico(String id_prod, String producto) {
        this.id_prod = id_prod;
        this.producto = producto;
    }



    public String getId_prod() {
        return this.id_prod;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


    @Override
    public void PagoTarjeta(){
        System.out.println("(PF) Pago por Tarjeta");
    }
    
    @Override
    public void PagoPayPal(){
        System.out.println("(PF) Pago por PayPal");
    }

    @Override
    public void PagoTransferencia(){
        System.out.println("Pago por Transferencia");
    }



    @Override
    public String toString() {
        return "Producto Físico:\n" +
            "id_prod: " + getId_prod() + "\n" +
            "Producto: " + getProducto() + "\n";            
    }



}
