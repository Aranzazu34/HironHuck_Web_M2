package Especies;

import Naturaleza.*; //probar a mostrar información  de Arbol/Planta

public class AnimalDomestico extends Animales {
    private String alimentacion;
    private int num_longevidad;


    public AnimalDomestico() {
    }


    public AnimalDomestico(String alimentacion, int num_longevidad, String especie, String nombre, int    num_patas, String origen) {
        super(especie, nombre, num_patas, origen);

        this.alimentacion = alimentacion;
        this.num_longevidad = num_longevidad;
    }



    public String getAlimentacion() {
        return this.alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public int getNum_longevidad() {
        return this.num_longevidad;
    }

    public void setNum_longevidad(int num_longevidad) {
        this.num_longevidad = num_longevidad;
    }


    /*    
    private String nombre;  //privado
    public  int    estacion;  //publico
    boolean        frutal; //default  
    */

    public void getArbol(Arbol arbol){

        System.out.println("Desde Animal Domestico ==> Estación: " + arbol.getEstacion() + ", desde la clase " + arbol.getClass());        

    }



    @Override
    public String toString() {
        return "{" + getClass().getSimpleName().toLowerCase() +
            ": su alimentacion es: '" + getAlimentacion() + "'" +
            ", su media de longevidad es: '" + getNum_longevidad() + "'" +
            "}";
    }


    




}
