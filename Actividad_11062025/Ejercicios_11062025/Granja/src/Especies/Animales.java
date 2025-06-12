package Especies;

//atributos protected
abstract class Animales {
    protected  String especie;
    protected  String nombre;
    protected  int    num_patas;
    protected  String origen; //continente/país


    public Animales() {
    }


    public Animales(String especie, String nombre, int num_patas, String origen) {
        this.especie = especie;
        this.nombre = nombre;
        this.num_patas = num_patas;
        this.origen = origen;
    }




    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_patas() {
        return this.num_patas;
    }

    public void setNum_patas(int num_patas) {
        this.num_patas = num_patas;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }



    @Override
    public String toString() {
        return "{" + getClass().getSimpleName().toLowerCase() +
            " especie: '" + getEspecie() + "'" +
            ", nombre: '" + getNombre() + "'" +
            ", Nº patas: '" + getNum_patas() + "'" +
            ", Origen: '" + getOrigen() + "'" +
            "}";
    }





}
