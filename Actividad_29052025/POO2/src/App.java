import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);
        
        Persona p1 = new Persona(); //constructor vacío
        Persona p2 = new Persona("Arantxa", "Pérez", 46, false, "44199705F");

        System.out.println();

        //se agregan los datos de p1
        p1.setNombre("Eric");
        p1.setApellido("Guerrero");
        p1.setEdad(14);
        p1.setDni("39004123T");
        p1.setEstaCasado(false);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println();


        Persona p3 = new Persona();

        //introducir datos por usuario
        System.out.println("Dime el Nombre:");
        String nombre = tcl.nextLine();
        
        System.out.println("Dime el apellido:");
        String apellido = tcl.nextLine();                

        System.out.println("Dime la edad:");
        int edad = tcl.nextInt();
        tcl.nextLine();

        System.out.println("Dime la está casado:");
        boolean es_casado = tcl.nextBoolean();
        tcl.nextLine();        

        System.out.println("Dime el dni:");
        String dni = tcl.nextLine();

        p3.setNombre(nombre);
        p3.setApellido(apellido);
        p3.setEdad(edad); 
        p3.setEstaCasado(es_casado);
        p3.setDni(dni); 

        System.out.println("Persona p3");
        System.out.println(p3);

        Persona p5 = p3;  
        //copia referencia de memoria (si cambias uno, se cambia el otro)

        Persona p4 = new Persona("Enrique", apellido, edad, es_casado, dni);
        p4.setApellido("ALONSO");
        System.out.println("persona p4");
        System.out.println(p4);

        System.out.println("persona p5");
        p5.setApellido("RUIZ");
        System.out.println(p5);   

        System.out.println("persona p3");        
        System.out.println(p3); 
        
        //ArrayList de objetos
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
        System.out.println("-----------------------------");
        System.out.println(listaPersonas);
        
        mostrarLista(listaPersonas); //mostrar primera vez

        p1.setNombre("Mireia");
        p4.setEdad(62);
   
       mostrarLista(listaPersonas); //mostrar segunda vez

        //
        buscarPorNombre(listaPersonas, tcl);
        System.out.println(buscarPorNombre2(listaPersonas, tcl));
        
        
        tcl.close();
        
    }

    //método render para no repetir código
    //-----------para llamarlo, instanciar objto en el main: p1.mostrarLista(ListaPersonas)
    public static void mostrarLista(ArrayList<Persona> miLista){
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Lista de personas:");
        for(Persona persona : miLista){
            System.out.println(persona.getNombre() + " " + persona.getEdad());
        }  
    }

    //método buscar nombre
    public static void buscarPorNombre(ArrayList<Persona> miLista, Scanner tcl){
        System.out.println("Dime el nombre qué buscas:");
        String nombreBuscar = tcl.nextLine();

        
            for(Persona persona : miLista){
                if(nombreBuscar.equalsIgnoreCase(persona.getNombre()) ){
                    System.out.println(persona.getNombre() + ", está en la lista");
                    break;
                }
            } 
    }

    public static String buscarPorNombre2(ArrayList<Persona> miLista, Scanner tcl){
        System.out.println("Dime el nombre qué buscas:");
        String nombreBuscar = tcl.nextLine();
        //se podría usar contains en vez de equals: daria un true/false

            for(Persona persona : miLista){
                if(nombreBuscar.equalsIgnoreCase(persona.getNombre()) ){
                    //en bucle for normal seria miLista.get(i).getNombre()
                    return persona.getNombre() + ", está en la lista";
                }
            } 
        
        return "No se encuentra en la lista.";
    }    
        
}
