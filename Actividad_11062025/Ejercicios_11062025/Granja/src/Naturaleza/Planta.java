package Naturaleza;

//import Naturaleza.Arbol;  //no es necesario por estar dentro del mismo paquete

//atributos default, private y public (uno de cada
public class Planta {
    private String nombre;  //privado
    public  int    mes_plantar;  //publico
    boolean        deInterior; //default      
    

    public Planta() {
    }


    public Planta(String nombre, int mes_plantar, boolean deInterior) {
        this.nombre = nombre;
        this.mes_plantar = mes_plantar;
        this.deInterior = deInterior;
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMes_plantar() {
        return this.mes_plantar;
    }

    public void setMes_plantar(int mes_plantar) {
        this.mes_plantar = mes_plantar;
    }

    public boolean isDeInterior() {
        return this.deInterior;
    }

    public void setDeInterior(boolean deInterior) {
        this.deInterior = deInterior;
    }

    //¿Y podrías, por ejemplo acceder desde la clase Planta a algún atributo de la clase Arbol?
    public void getArbol(Arbol arbol){

        System.out.println("Desde Planta ==> Estación: " + arbol.getEstacion() + ", desde la clase " + arbol.getClass());

    }


    @Override
    public String toString() {
        return "{" + getClass().getSimpleName().toLowerCase() +
            " nombre: '" + getNombre() + "'" +
            ", Se planta en el mes: '" + getMes_plantar() + "'" +
            ", de interior:'" + isDeInterior() + "'" +
            "}";
    }


    

}
