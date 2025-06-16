package ValidacionSetterGetters;

public class ClienteDiscoteca {
    private int     edad;
    private String  nombre;


    public ClienteDiscoteca() {
    }


    public ClienteDiscoteca(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }



    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "El cliente " + getNombre() + ",  tiene " + getEdad() + "años.";
    }
    

}
