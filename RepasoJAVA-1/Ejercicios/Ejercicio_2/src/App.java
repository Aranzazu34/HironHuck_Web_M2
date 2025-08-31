import java.util.ArrayList;
import java.util.Scanner;


public class App {
    /*
     * 2- LISTA CURSOS JAVA

Vamos a crear un listado de escuelas que ofrecen cursos de programación en java.

Cada curso contiene estos datos:

nombre de la escuela

localidad de la escuela

precio del curso

si hacen cursos nocturnos o no

A partir de ahí. Crear todos los métodos habituales en la POO.

Y en el programa principal instanciar 3 escuelas (incrustarlas, no por usuario) y guardarlas en un arraylist de objetos, e imprimirlos todos.
     */
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);        

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush(); 

        
        //para guardar las Escuelas
        ArrayList<Escuela> lEscuelas = new ArrayList<Escuela>();

        //instanciamos 3 escuelas
        Escuela e1 = new Escuela("IronHack", new ArrayList<Curso>());
        Escuela e2 = new Escuela("Nucleo School", new ArrayList<Curso>());
        Escuela e3 = new Escuela("PUE", new ArrayList<Curso>());
        
        System.out.println(e1);
        System.out.println();
        System.out.println(e2);
        System.out.println();
        System.out.println(e3);   

        //añadir las escuelas en la ArrayList
        lEscuelas.add(e1);
        lEscuelas.add(e2);
        lEscuelas.add(e3);
    
        //Recorrer la ArrayList

        System.out.println();


        System.out.println("+++++++++++Bucle for-each (elementos)++++++++++++++++++++++++");
        //bucle for-each (elementos)
        for (Escuela escuela : lEscuelas) {
            System.out.println( "Escuela " + escuela.getNombre() );

            int opcion = 0;

            System.out.println("Introduce una opción ( 1. Gestionar Escuela, 2. Continuar):");

            while (!tcl.hasNextInt()) {
                System.out.println("Entrada inválida. Introduce 1 o 2:");
                tcl.next();
            }

            opcion = tcl.nextInt();
            tcl.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    Metodos.GestionEscuelaCursos(escuela, tcl);
                    break;
                case 2:
                    System.out.println("Pasando a la siguiente escuela...\n");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }            

        }

        System.out.println("=====================LISTA DE CURSOS POR ESCUELA=============================");        
        //bucle para mostrar toda la información de cursos de las Escuelas
        for (Escuela escuela : lEscuelas) {
            Metodos.mostrarCursos(escuela);

            System.out.println("\n\n");
        }

        tcl.close();

        System.out.println(">>> Fin del programa <<<");

    }
}

/*Specialized.Trek.Scott.Canyon.Giant.Orbea.Cannondale.Pinarello. */