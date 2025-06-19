package SorteoTienda;
import java.util.Objects;

public class GrupoTienda {
    private String nombreTienda;    
    private String ubicacion;
    private String tipo;


    public GrupoTienda() {
    }

    public GrupoTienda(String nombreTienda, String ubicacion, String tipo) {
        this.nombreTienda = nombreTienda;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }


    public String getNombreTienda() {
        return this.nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "La tienda " + getNombreTienda() + ", ubicada en " + getUbicacion() + ". Es una " +
                getTipo() + ".";
    }
    

}
