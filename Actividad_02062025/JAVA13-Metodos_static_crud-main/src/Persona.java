

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private boolean estaCasado;
    private String dni;

    // constructores (poner un constructor vacio tambien)
    // el vacio es para poder crear uno en el main son parametros y después rellenarlo
    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, boolean estaCasado, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estaCasado = estaCasado;
        this.dni = dni;
        System.out.println("persona creada!");
        //System.out.println(this);
    }

    // getters y setters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstaCasado() {
        return this.estaCasado;
    }

    public void setEstaCasado(boolean estaCasado) {
        this.estaCasado = estaCasado;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String calcularDiferencia(int edadPadre){
        if(edadPadre>this.edad){
            return "el padre de " + this.nombre +  " tiene " + edadPadre + ", y la diferencia de edad es: " + (edadPadre - this.edad);
        } else{
            return "la edad del padre debe ser mayor que la del hijo";
        }
    }
    

    // toString
    @Override
    public String toString() {
        return 
                "nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", edad='" + getEdad() + "'" +
                ", estaCasado='" + isEstaCasado() + "'" +
                ", dni=" + getDni() ;
    }

}
