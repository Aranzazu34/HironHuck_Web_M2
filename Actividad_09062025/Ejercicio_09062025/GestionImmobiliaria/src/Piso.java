public class Piso extends Inmueble{
    private int planta;
    private boolean ascensor;
    private final boolean portero=false; // Atributo final


    public Piso() {
    }    


    public Piso(int planta, boolean ascensor, float superficie, double precio, String ubicacion, String tipo) {
        super(superficie, precio, ubicacion, tipo);
        this.planta = planta;
        this.ascensor = ascensor;
    }



    public int getPlanta() {
        return this.planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public boolean isAscensor() {
        return this.ascensor;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }

    public boolean isPortero() {
        return this.portero;
    }    

    //Dos tipos de consulta: una que muestre solo tipo y ubicación: ‘casa en Santa Coloma’
    public void inmuebleTipoUbicacion(){
        System.out.println( "El "+ getClass().getSimpleName().toLowerCase() + " está en " + getUbicacion() );
    }    

    @Override
    //características. Mostrar Piso
    public void mostrarCaracteristicas(){
        
        System.out.println("El " + getTipo() +
                           ", está en la " + getPlanta() + " planta" +
                            ( isPortero() ? " y con portero." : ".") +
                            ( isAscensor() ? "Tiene ascensor." : ".") +                            
                           " Con una superficie de " + getSuperficie() + 
                           "m2 y precio de " + getPrecio() + " y está ubicado en " + getUbicacion() +"."
        );

    } 

    
 


    @Override
    public String toString() {
        return "ToString:  El " + getTipo() +
                           ", está en la " + getPlanta() + " planta" +
                            ( isPortero() ? " con portero;" : ";") +
                            ( isAscensor() ? " tiene ascensor." : ".") +                            
                           " Con una superficie de " + getSuperficie() + 
                           " m2 y precio de " + getPrecio() + " y está ubicado en " + getUbicacion() +".";
    }



}
