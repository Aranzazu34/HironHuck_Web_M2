public class Deporte extends Zapato{
    private String especialidad;
    private boolean ult_tendencia;

    public Deporte(String marca, String modelo, String talla, double precio, String especialidad, boolean ult_tendencia) {
        super(marca, modelo, talla, precio); //proviene de Zapato
        this.especialidad = especialidad;
        this.ult_tendencia = ult_tendencia;
    }


    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isUlt_tendencia() {
        return this.ult_tendencia;
    }

    public void setUlt_tendencia(boolean ult_tendencia) {
        this.ult_tendencia = ult_tendencia;
    }


    @Override
    public String toString() {
        return "El zapato de " + getClass().getSimpleName().toLowerCase() +                
               " es de la marca " + getMarca() + ", modelo " + getModelo() + " y de la talla " + getTalla() + 
               ". Especialidad: " + getEspecialidad() +
               ". Tiene un precio de " + getPrecio() + " y es " + 
               ( isUlt_tendencia() ? "última tendencia" : "de otra temporada") + ".";                  
    }


    
}