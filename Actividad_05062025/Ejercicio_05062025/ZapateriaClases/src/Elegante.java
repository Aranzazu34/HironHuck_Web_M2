public class Elegante extends Zapato {
    private boolean tieneHebilla;

    public Elegante(String marca, String modelo, String talla, double precio, boolean tieneHebilla) {
        super(marca, modelo, talla, precio); //proviene de Zapato
        this.tieneHebilla = tieneHebilla;
    }


    public boolean isTieneHebilla() {
        return this.tieneHebilla;
    }

    public boolean getTieneHebilla() {
        return this.tieneHebilla;
    }

    public void setTieneHebilla(boolean tieneHebilla) {
        this.tieneHebilla = tieneHebilla;
    }


    @Override
    public String toString() {
        return "El zapato " + getClass().getSimpleName().toLowerCase() +                
               " es de la marca " + getMarca() + ", modelo " + getModelo() + " y de la talla " + getTalla() + 
               ". " + ( isTieneHebilla() ? "Tiene hebilla." : "") + 
               " A un precio de " + getPrecio() + ".";               
    }

    
}