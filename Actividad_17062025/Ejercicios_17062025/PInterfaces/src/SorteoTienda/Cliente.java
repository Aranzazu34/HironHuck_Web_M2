package SorteoTienda;

import SorteoTienda.GrupoTienda;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String telefono;
    private int    socio;
    private ArrayList<GrupoTienda> tiendas = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String nombre, String telefono, int socio, ArrayList<GrupoTienda> tiendas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.socio = socio;
        this.tiendas = tiendas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public int getSocio() {
        return this.socio;
    }

    public void setSocio(int nombre) {
        this.socio = socio;
    }    

    public ArrayList<GrupoTienda> getTiendas() {
        return this.tiendas;
    }

    public void setTiendas(ArrayList<GrupoTienda> tiendas) {
        this.tiendas = tiendas;
    }




    @Override
    public String toString() {
        String cadena = "El cliente  " + getNombre() + " con telefono " + getTelefono() +
                        ", socio nº " + getSocio() + "de las Tiendas:\n\n";

        for (GrupoTienda tienda : getTiendas()) {

            cadena += " - " + tienda.toString() + "\n";            
            
        }

        return cadena;            
    }
    

}
