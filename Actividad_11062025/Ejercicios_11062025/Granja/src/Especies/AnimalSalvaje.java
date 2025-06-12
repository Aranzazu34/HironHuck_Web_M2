package Especies;

public class AnimalSalvaje extends Animales {
    private boolean nocturno;
    private String  alimentacion;
    final boolean  protegido = true;


    public AnimalSalvaje() {
    }


    public AnimalSalvaje(boolean nocturno, String alimentacion, String especie, String nombre, int    num_patas, String origen) {
        super(especie, nombre, num_patas, origen);

        this.nocturno = nocturno;
        this.alimentacion = alimentacion;
    }


    public boolean isNocturno() {
        return this.nocturno;
    }

    public void setNocturno(boolean nocturno) {
        this.nocturno = nocturno;
    }

    public String getAlimentacion() {
        return this.alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public boolean isProtegido() {
        return this.protegido;
    }




    @Override
    public String toString() {
        return "{" + getClass().getSimpleName().toLowerCase() +
            ": es nocturno: '" + isNocturno() + "'" +
            ", su alimentacion es: '" + getAlimentacion() + "'" +
            ", esta protegido: '" + isProtegido() + "'" +
            "}";
    }






}
