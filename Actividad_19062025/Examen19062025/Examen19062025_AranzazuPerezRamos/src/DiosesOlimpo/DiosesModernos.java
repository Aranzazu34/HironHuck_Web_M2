package DiosesOlimpo;

public class DiosesModernos extends Dioses{
    private String medio_natural; 

    public DiosesModernos() {
    }

    public DiosesModernos(String medio_natural, String nombre, int edad, int grado_fuerza) {
        super(nombre, edad, grado_fuerza);
        this.medio_natural = medio_natural;
    }

    public String getMedio_natural() {
        return this.medio_natural;
    }

    public void setMedio_natural(String medio_natural) {
        this.medio_natural = medio_natural;
    }


    @Override
    public String toString() {

        return getNombre() + " de " + getEdad() +" años. Tiene un grado de fuerza de " + getGrado_fuerza() +
               ". Su medio natural es: " + getMedio_natural() + "\n";               

    }
    

}
