// herencia: usa palabra reservada extends
public class Gato extends Mascota{
        private boolean salvaje;

        public Gato(){
        }


        public Gato(String nombre, int edad, boolean salvaje) {
            super(nombre, edad); //lo pilla de Mascota
            this.salvaje = salvaje;
        }


    public boolean isSalvaje() {
        return this.salvaje;
    }


    public void setSalvaje(boolean salvaje) {
        this.salvaje = salvaje;
    }

    //sobrecarga de métodos (una de las formas de polimorfismo)
    // pasamos si es true or false que queremos ver solo la edad:
    public String descripcion(boolean soloEdad){
        if(soloEdad){
            return getNombre() + " tiene " + getEdad() + " años";
        } else{
            return descripcion();
        }    
    }

    // pasamos una presentación personalizada 
    public void descripcion(String presentacion){
        System.out.println(presentacion);
        System.out.println(descripcion());
    }

    // no pasamos nada (descripción completa standard - como el toString())
    //no se pone @override porque el método presentación no existe previamente como método interno (el toString() sí)
    public String descripcion() {
        String salvaje = "";
        if(isSalvaje()){
            salvaje = "salvaje";
        } else{
            salvaje = "doméstico";
        }

        return "\nMe llamo " + getNombre()+ ", tengo " + getEdad() +
            " años, soy un " + this.getClass().getSimpleName().toLowerCase() + " " +  salvaje + " y digo miau!\n";
            
    }

}
