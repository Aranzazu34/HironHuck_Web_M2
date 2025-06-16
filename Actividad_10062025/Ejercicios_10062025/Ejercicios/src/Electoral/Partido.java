package Electoral;

public class Partido {
    private String nombre;
    private float porcentaje;


    public Partido() {
    }


    public Partido(String nombre, float porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }



    @Override
    public String toString() {
        return "El partido " + getNombre() + ", ha conseguido el " + getPorcentaje() + "% de los votos.";
    }



}
