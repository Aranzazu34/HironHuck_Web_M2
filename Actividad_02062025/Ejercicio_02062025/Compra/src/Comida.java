//Se propone que sean objetos Comida: nombre, origen, peso, precio.
public class Comida {
    private String nombre;
    private String origen;
    private float  peso;
    private double precio;


    public Comida(String nombre, String origen, float peso, double precio) {
        this.nombre = nombre;
        this.origen = origen;
        this.peso = peso;
        this.precio = precio;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "La comida " + getNombre() + ", tiene origen en " + getOrigen() + 
               ". Peso de " + getPeso() + " kg, con un precio de "+ getPrecio() + " el kg.";
    }



    
}
