import java.util.ArrayList;
import java.util.UUID;

public class Persona {
    private UUID id;
    private String nombre;
    private ArrayList<Mascota> suMascota = new ArrayList<>();


    public Persona() {
    }


    public Persona(String nombre, ArrayList<Mascota> suMascota) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.suMascota = suMascota;
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getSuMascota() {
        return this.suMascota;
    }

    public void setSuMascota(ArrayList<Mascota> suMascota) {
        this.suMascota = suMascota;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", suMascota='" + getSuMascota() + "'" +
            "}";
    }
    
}
