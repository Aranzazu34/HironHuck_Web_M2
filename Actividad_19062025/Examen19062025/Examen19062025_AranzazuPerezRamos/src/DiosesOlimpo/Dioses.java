package DiosesOlimpo;

public class Dioses {
    //atributos comunes clase madre: Nombre, edad y GradoFuerza
    private String nombre;
    private int    edad;
    private int    grado_fuerza;  //valores de 0 a 200


    public Dioses() {
    }

    public Dioses(String nombre, int edad, int grado_fuerza) {
        this.nombre = nombre;
        this.edad = edad;
        this.grado_fuerza = grado_fuerza;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrado_fuerza() {
        return this.grado_fuerza;
    }

    public void setGrado_fuerza(int grado_fuerza) {
        this.grado_fuerza = grado_fuerza;
    }



    @Override
    public String toString() {

        return getNombre() + " de " + getEdad() +" años. Tiene un grado de fuerza de " + getGrado_fuerza() + ".\n";  
                
    }
    

}
