/**
 * Cada curso contiene estos datos:

nombre de la escuela

localidad de la escuela

precio del curso

si hacen cursos nocturnos o no
**/

public class Curso{

    private String idCurso;
    private String nCurso;
    private String localidad;
    private float  precio;
    private boolean nocturno; 


    public Curso(String idCurso, String nCurso, String localidad, float precio, boolean nocturno, String nombreEscuela) {
        this.idCurso = idCurso;
        this.nCurso = nCurso;
        this.localidad = localidad;
        this.precio = precio;
        this.nocturno = nocturno;
        // Puedes guardar el nombre de la escuela si lo deseas
    }



    public String getIdCurso() {
        return this.idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNCurso() {
        return this.nCurso;
    }

    public void setNCurso(String nCurso) {
        this.nCurso = nCurso;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isNocturno() {
        return this.nocturno;
    }

    public void setNocturno(boolean nocturno) {
        this.nocturno = nocturno;
    }


    @Override
    public String toString() {
        return "{" +
            " idCurso='" + getIdCurso() + "'" +
            ", nCurso='" + getNCurso() + "'" +
            ", localidad='" + getLocalidad() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", nocturno='" + isNocturno() + "'" +
            "}";
    }

    


}
