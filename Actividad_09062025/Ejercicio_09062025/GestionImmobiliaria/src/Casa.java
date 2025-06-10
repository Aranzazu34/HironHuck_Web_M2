import java.util.Scanner;

public class Casa extends Inmueble {
    private boolean adosada;


    public Casa() {
    }
    

    public Casa(boolean adosada, float superficie, double precio, String ubicacion, String tipo) {
        super(superficie, precio, ubicacion, tipo);
        this.adosada = adosada;
    }


    public boolean isAdosada() {
        return this.adosada;
    }

    public void setAdosada(boolean adosada) {
        this.adosada = adosada;
    }


    //Dos tipos de consulta: una que muestre solo tipo y ubicación: ‘casa en Santa Coloma’
    public void inmuebleTipoUbicacion(){
        System.out.println( "La "+ getClass().getSimpleName().toLowerCase() + " está en " + getUbicacion() );
    }


    @Override
    //características. Mostrar Casa
    public void mostrarCaracteristicas(){
        
        System.out.println("La " + getTipo() +
                            ( isAdosada() ? "es adosada" : "") +
                           ", tiene una superficie de " + getSuperficie() + 
                           "  m2. Con un precio de " + getPrecio() + " y está ubicada en " + getUbicacion() +"."
        );

    }


    //Probar sobrecarga de métodos (método solo con tipo y ubicación) por parámetro y que modifique ambos datos!!!
    public void modificarDatos(Scanner tcl){
            System.out.println("Se modifican por sobrecarga en Casa: tipo+ubicacion (modificarDatos)");

            System.out.println("Ubicacion:");
            String ubicacion = tcl.nextLine();
                    
            System.out.println("Tipo:");
            String tipo = tcl.nextLine();            
            
            setTipo(tipo);
            setUbicacion(ubicacion);

            System.out.println();
    }             



    @Override
    public String toString() {
        return "ToString:  La " + getTipo() +
                            ( isAdosada() ? "es adosada" : "") +
                           ", tiene una superficie de " + getSuperficie() + 
                           " m2. Con un precio de " + getPrecio() + " y está ubicada en " + getUbicacion() +".";
    }





    
}
