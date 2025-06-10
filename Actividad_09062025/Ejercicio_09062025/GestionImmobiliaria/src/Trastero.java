public class Trastero extends Inmueble {
    private boolean seguridad;


    public Trastero() {
    }
   

    public Trastero(boolean seguridad, float superficie, double precio, String ubicacion, String tipo) {
        super(superficie, precio, ubicacion, tipo);
        this.seguridad = seguridad;
    }



    public boolean isSeguridad() {
        return this.seguridad;
    }

    public void setSeguridad(boolean seguridad) {
        this.seguridad = seguridad;
    }

    //Dos tipos de consulta: una que muestre solo tipo y ubicación: ‘casa en Santa Coloma’
    public void inmuebleTipoUbicacion(){
        System.out.println( "El "+ getClass().getSimpleName().toLowerCase() + " está en " + getUbicacion() );
    }    


    @Override
    //características. Mostrar Trastero
    public void mostrarCaracteristicas(){
        
        System.out.println("El " + getTipo() + 
                            ( isSeguridad() ? " tiene seguridad" : "") +
                           ", con una superficie de " + getSuperficie() + 
                           " m2 y precio de " + getPrecio() + ". Está ubicado en " + getUbicacion() +"."
        );

    }   


    @Override
    public String toString() {
        return "ToString: El " + getTipo() + 
                            ( isSeguridad() ? " tiene seguridad" : "") +
                           ", con una superficie de " + getSuperficie() + 
                           " m2 y precio de " + getPrecio() + ". Está ubicado en " + getUbicacion() +".";
    }




}
