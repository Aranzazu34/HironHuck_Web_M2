package Naturaleza;

//atributos default, private y public (uno de cada)
public class Arbol {    
    private String nombre;  //privado
    public  int    estacion;  //publico
    boolean        frutal; //default           


    public Arbol() {
    }


    public Arbol(String nombre, int estacion, boolean hoja_caduca) {
        this.nombre = nombre;
        this.estacion = estacion;
        this.frutal = hoja_caduca;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstacion() {
        return this.estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public boolean isfrutal() {
        return this.frutal;
    }

    public void setHoja_caduca(boolean hoja_caduca) {
        this.frutal = hoja_caduca;
    }




    @Override
    public String toString() {
        return "{" + getClass().getSimpleName().toLowerCase() +
            " nombre: '" + getNombre() + "'" +
            ", estacion: '" + getEstacion() + "'" +
            ", frutal: '" + isfrutal() + "'" +
            "}";
    }





}
