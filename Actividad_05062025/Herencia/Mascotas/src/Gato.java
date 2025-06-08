public class Gato extends Mascota{
    private boolean salvaje;


    public Gato(String nombre, int edad, boolean salvaje) {
        super(nombre,edad); //lo pilla de Mascota
        this.salvaje = salvaje;
    }


    public boolean isSalvaje() {
        return this.salvaje;
    }

    public void setSalvaje(boolean salvaje) {
        this.salvaje = salvaje;
    }


    @Override
    public String toString() {
        return "\nMe llamo " + getNombre() +
               ", tengo " + getEdad() +               
               " soy un " + this.getClass().getSimpleName().toLowerCase() +
               ( this.salvaje ? " salvaje" : " domestico" ) +
               " y digo miau!\n";
    }
    
    
    
}
