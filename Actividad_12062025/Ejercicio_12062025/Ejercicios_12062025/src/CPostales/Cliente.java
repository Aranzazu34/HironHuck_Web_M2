package CPostales;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private int edad;
    private ArrayList<Direccion> direcciones = new ArrayList<>();



    public Cliente() {
    }


    public Cliente(int id, String nombre, int edad, ArrayList<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direcciones = direcciones;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Direccion> getDireccion() {
        return this.direcciones;
    }

    public void setDireccion(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }



    @Override
    public String toString() {          
        String cadena = "El cliente con id " + getId() + ", se llama " + getNombre() + ". Tiene " + getEdad() +
                        " años.\n\n" + "Direcciones:\n\n";

        for (Direccion direccion : getDireccion()) {

            cadena += " - " + direccion.toString() + "\n";            
            
        }

        return cadena;
        
    }


}
