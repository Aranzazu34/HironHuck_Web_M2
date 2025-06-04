import java.util.ArrayList;
import java.util.Scanner;

public class Gestoria {

    // método crear persona
    public static void crearPersona(ArrayList<Persona> miLista, Scanner sc){
        System.out.println("Dime el Nombre:");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido:");
        String apellido = sc.nextLine();     

        System.out.println("Dime la edad:");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime la está casado:");
        boolean es_casado = sc.nextBoolean();
        sc.nextLine();   

        System.out.println("Dime el dni:");
        String dni = sc.nextLine();

        Persona persona = new Persona(nombre, apellido, edad, es_casado, dni);
        miLista.add(persona);
    }
    
    //método render para no repetir codigo
    public static void mostrarLista(ArrayList<Persona> miLista){
        System.out.println();
        System.out.println("------------------------");
        System.out.println("lista personas, nombre y edad:");
        for(Persona persona : miLista){
            System.out.print(persona.getNombre() + " ");
            System.out.println(persona.getEdad());
        }
    }

    //método buscar nombre
    public static void buscarPorNombre(ArrayList<Persona> miLista, Scanner sc){
        System.out.println("buscar por nombre recibe esta lista: " + miLista);
        System.out.println("qué nombre buscas?");
        String nombreBuscar = sc.nextLine();
        boolean encontrado = false;

        //se podria usar contains en vez de equals daria un true/false
        
            for(Persona persona : miLista){
                if(nombreBuscar.equalsIgnoreCase(persona.getNombre())){
                    //en bucle for normal seria miLista.get(i).getNombre()
                    encontrado = true;
                } 
            }

            if (encontrado) {
                System.out.println("está en la lista!");
            } else{
                System.out.println("NO lo hemos encontrado!");
            }


            
    }
}
