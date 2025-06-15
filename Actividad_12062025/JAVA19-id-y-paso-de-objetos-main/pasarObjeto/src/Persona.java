import java.util.UUID;

public class Persona {
    private UUID id;
    private String nombre;
    private Mascota suMascota;


    public Persona() {
    }


    public Persona(String nombre, Mascota suMascota) {
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

    public Mascota getSuMascota() {
        return this.suMascota;
    }

    public void setSuMascota(Mascota suMascota) {
        this.suMascota = suMascota;
    }
    

    @Override
    public String toString() {
        return 
            " \nid='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", suMascota='" + getSuMascota() + "'" +
            "}";
    }
    
}
