import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    public static void agregarCurso(Scanner tcl, Escuela escuela){
        System.out.println("===Introducir Curso para la Escuela: "+ escuela.getNombre() +"===\\n");
        System.out.println("Identificador:");
        String idCurso = tcl.nextLine();

        System.out.println("Nombre:");
        String nCurso = tcl.nextLine();

        System.out.println("Localidad:");
        String localidad = tcl.nextLine();        

        System.out.println("Precio:");
        float  precio = tcl.nextFloat();
        tcl.nextLine();

        System.out.println("Curso Nocturno (SI/NO):");
        String nocturno = tcl.nextLine();
        
        boolean esNocturno =( (nocturno.equalsIgnoreCase("SI") ) ? true : false);

        //public Curso(String idCurso, String nCurso, String localidad, float precio, boolean nocturno, 
        //             String nombreEscuela, ArrayList<Curso> listCursos) 
        Curso curs = new Curso(idCurso, nCurso, localidad, precio, esNocturno, escuela.getNombre());

        //ahora se añade el curso creado a la lista de cursos de la escuela
        escuela.getLCursos().add(curs);
    }

    public static void modificarDatosCursoEscuela(Scanner tcl, Escuela escuela){
        System.out.println("===Modificar Datos Curso de la Escuela: "+ escuela.getNombre() +"===\n\n" );        
        ArrayList<Curso> lcursos = escuela.getLCursos();

        System.out.println("Identificador Curso:");
        String idCurso = tcl.nextLine();   
        
        System.out.println("Los datos en blanco, no se modificarán.\n\n");    

        String nCurso;
        String localidad;
        float  precio;
        String nocturno;
        boolean esNocturno;

        for (Curso curso : lcursos) {
            if(curso.getIdCurso().equalsIgnoreCase(idCurso)){
               System.out.println( "Nombre:\n " );
               nCurso = tcl.nextLine();   

               if(!(nCurso == null || nCurso.isBlank()) ){
                    curso.setNCurso(nCurso);
               }

               System.out.println( "Localidad:\n " );
               localidad = tcl.nextLine();   

               if(!(localidad == null || localidad.isBlank()) ){
                    curso.setLocalidad(localidad);
               }  

               System.out.println( "Localidad:\n " );
               precio = tcl.nextFloat();  
               tcl.nextLine(); 

               if(!(precio == 0) ){
                    curso.setPrecio(precio);
               }                 

               System.out.println( "Curso nocturno:\n " );
               nocturno = tcl.nextLine(); 
               
               esNocturno =( (nocturno.equalsIgnoreCase("SI") ) ? true : false);

               if(!(nocturno == null || nocturno.isBlank()) ){
                    curso.setNocturno(esNocturno);
               }                 


               System.out.println( "Curso actualizado\n " );
               break;
            }
        }
    }

    public static void  eliminarCurso(Scanner tcl, Escuela escuela){
        System.out.println("===Eliminar Curso de la Escuela: "+ escuela.getNombre() +"===\n\n" );        
        ArrayList<Curso> lcursos = escuela.getLCursos();

        System.out.println("Identificador Curso:");
        String idCurso = tcl.nextLine();    

        for (Curso curso : lcursos) {
            if(curso.getIdCurso().equalsIgnoreCase(idCurso)){
                 lcursos.remove(curso);
                 System.out.println("Eliminado el Curso de la Escuela: "+ escuela.getNombre()+"\n\n" );                   
                 break;
            }
        }

    }

    public static void mostrarCursos(Escuela escuela){
        System.out.println("===Mostrar Cursos de la Escuela: "+ escuela.getNombre() +"===\n\n" );        
        ArrayList<Curso> lcursos = escuela.getLCursos();

        for (Curso curso : lcursos) {
            System.out.println(curso.getIdCurso() + " - "+ curso.getNCurso() + ", " +
                                "Localidad: " +curso.getLocalidad() + " Precio: "+ curso.getPrecio() + 
                                "Es Nocturno: " + ( curso.isNocturno() ? "Sí" : "No" ) );  
        }    

    }

    public static void GestionEscuelaCursos(Escuela escuela, Scanner tcl){
        String entrada;
        int opcion;

        do{

            try{
                    //usar un método de los propios de la bicicleta
                    System.out.println("Introduce una opción ( 1. Agregar Curso, 2. Modificar Dato/s Curso, 3. Eliminar Curso, 4. Mostrar Cursos y 5. Salir):");
                    entrada = tcl.nextLine();
                    opcion = Integer.parseInt(entrada);

                    System.out.println("!!!!!!!opcion: "+opcion);
                    
                    switch (opcion) {
                        case 1:
                            agregarCurso(tcl, escuela);
                            break;
                        case 2:
                            modificarDatosCursoEscuela(tcl, escuela);
                            break;                    
                        case 3:
                            eliminarCurso(tcl, escuela);
                            break; 
                        case 4:
                            mostrarCursos(escuela);
                            break; 
                        case 5:
                            System.out.println("Saliendo del menú...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intenta de nuevo.");
                            break;
                    }      
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                opcion = -1; // o cualquier otro valor para representar error
            }
     
          
        }while(opcion != 5);

    }
   

}
