public class Casual extends Zapato {
    private String material;

    public Casual(String marca, String modelo, String talla, double precio, String material) {
        super(marca, modelo, talla, precio); //proviene de Zapato
        this.material = material;
    }


    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }



    @Override
    public String toString() {
        return "El zapato " + getClass().getSimpleName().toLowerCase() + 
               " es de la marca " + getMarca() + ". Modelo " + getModelo() + " y de la talla " + getTalla() + 
               ". Tiene un precio de " + getPrecio() + " y esta realizado con " + getMaterial() + ".";            
    }


    

    
}
