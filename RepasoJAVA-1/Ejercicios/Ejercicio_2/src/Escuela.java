import java.util.ArrayList;

public class Escuela {

    private String nombre;
    private ArrayList<Curso> lCursos;

    public Escuela() {
    }    

    public Escuela(String nombre, ArrayList<Curso> listCursos) {
        this.nombre = nombre;
        this.lCursos = listCursos;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Curso> getLCursos() {
        return this.lCursos;
    }

    public void setLCursos(ArrayList<Curso> lCursos) {
        this.lCursos = lCursos;
    }





    @Override
    public String toString() {
        return "Escuela: " + getNombre() + "\n\n" +
               "Cursos:\n\n"
               ;
    }


}
