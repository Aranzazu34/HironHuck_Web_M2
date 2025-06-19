package DiosesOlimpo;

public class DiosesDelOlimpo extends Dioses{
    private String  poder;
    private boolean relacion_humanos; 


    public DiosesDelOlimpo() {
    }

    public DiosesDelOlimpo(String poder, boolean relacion_humanos, String nombre, int edad, int grado_fuerza) {
        super(nombre, edad, grado_fuerza);
        this.poder = poder;
        this.relacion_humanos = relacion_humanos;
    }

    public String getPoder() {
        return this.poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public boolean isRelacion_humanos() {
        return this.relacion_humanos;
    }

    public void setRelacion_humanos(boolean relacion_humanos) {
        this.relacion_humanos = relacion_humanos;
    }


    @Override
    public String toString() {

        return getNombre() + " de " + getEdad() +" años. Tiene el poder: " + getPoder() + ". Grado de fuerza de " + getGrado_fuerza() +
            ". " + (isRelacion_humanos() ? "Sí" : "No" ) + " se relaciona con humanos.\n";          

    }
    

}
