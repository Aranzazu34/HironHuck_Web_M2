// herencia: usa palabra reservada extends
public class Perro extends Mascota{
        private String raza;

        public Perro(String nombre, int edad, String raza) {
            super(nombre, edad); //lo pilla de Mascota
            this.raza = raza;
        }


    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String ladrar(){
        return "guau!";
    }

    @Override
    public String toString() {
        return "\nMe llamo " + getNombre()+ ", tengo " + getEdad() +
            " años, soy un " + this.getClass().getSimpleName().toLowerCase() + " de raza " + getRaza() + " y digo: " + ladrar() +"\n";
            
    }



    


}

   