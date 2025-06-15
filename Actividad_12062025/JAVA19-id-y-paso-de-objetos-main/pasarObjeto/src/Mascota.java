public class Mascota {
    private Long id;
    private static Long contador = 0L;
    private String tipo;
    private String nombre;
    private int edad;
    //private Persona amo;


    public Mascota() {
    }


    public Mascota(String tipo, String nombre, int edad) {
        contador++;
        this.id = contador;
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
        
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

   

    
    @Override
    public String toString() {
        return 
            " \n{ id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + " }";
    }
    
}
