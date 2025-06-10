import java.util.Scanner;

public abstract class Inmueble {
    private float   superficie;
    private double  precio;
    private String  ubicacion;
    private String  tipo;


    public Inmueble() {
    }

    public Inmueble(float superficie, double precio, String ubicacion, String tipo) {
        this.superficie = superficie;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }


    public float getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //muestre solo tipo y ubicación: ‘casa en Santa Coloma’
    public void getUbicacionTipo(){

        //System.out.println("tipo inmueble: " + o.getClass());

        System.out.println( getTipo() + " en " + getUbicacion() );

    }


    //características. Mostrar Casa
    public abstract void mostrarCaracteristicas();

    //Probar sobrecarga de métodos (método solo con tipo y ubicación) por parámetro y que modifique ambos datos!!!
    public void modificarDatos(Scanner tcl){
            //System.out.println("Se modifican por sobrecarga en Casa: tipo+ubicacion (modificarDatos)");

            System.out.println("Ubicacion:");
            String ubicacion = tcl.nextLine();
                    
            System.out.println("Tipo:");
            String tipo = tcl.nextLine();            
            
            setTipo(tipo);
            setUbicacion(ubicacion);

            System.out.println();
    }  
        
    public void modificarDatos(String ubicacion){
            //System.out.println("Se modifica por sobrecarga en Piso: ubicacion (modificarDatos)");
            
            setUbicacion(ubicacion);

            System.out.println();
    }   

    public void modificarDatos(String tipo, String ubicacion){
            //System.out.println("Se modifican por sobrecarga en Trastero: tipo+ubicacion (modificarDatos)");
            
            setTipo(tipo);
            setUbicacion(ubicacion);

            System.out.println();
    }  


    @Override
    public String toString() {
        return "{" +
            " superficie='" + getSuperficie() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", ubicacion='" + getUbicacion() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }





    
}
