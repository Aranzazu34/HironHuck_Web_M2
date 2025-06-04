import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Gestoria {

    // método crear persona
    public static void crearPersona(ArrayList<Persona> miLista, Scanner sc) {
        System.out.println("Dime el Nombre:");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido:");
        String apellido = sc.nextLine();

        System.out.println("Dime la edad:");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Dime si está casado:");
        boolean es_casado = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Dime el dni:");
        String dni = sc.nextLine();

        Persona persona = new Persona(nombre, apellido, edad, es_casado, dni);
        miLista.add(persona);
    }

    // método render para no repetir codigo
    public static void mostrarLista(ArrayList<Persona> miLista) {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("lista personas:");

        for (Persona persona : miLista) {
            System.out.print(persona); 
            System.out.println();   
        }
    }

    public static int buscarPorNombre(ArrayList<Persona> miLista, Scanner sc) {
        System.out.println("Qué nombre buscas?");
        String nombreBuscar = sc.nextLine();

        for (int i = 0; i < miLista.size(); i++) {
            if (nombreBuscar.equalsIgnoreCase(miLista.get(i).getNombre())) {
                return i; // devuelve el índice si lo encuentra
            }
        }

        return -1; //devuelve -1 si no lo encuentra
    }

    // modificar cliente
    public static void modificarCliente(ArrayList<Persona> miLista, Scanner sc) {

        int indice = buscarPorNombre(miLista, sc); // ver si lo encuentra

        if (indice != -1) {
            Persona persona = miLista.get(indice);
            System.out.println("Persona encontrada: " + persona);
            System.out.println("Introduce nuevos datos:");

            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            persona.setNombre(nuevoNombre);

            System.out.print("Nuevo apellido: ");
            String nuevoApellido = sc.nextLine();
            persona.setApellido(nuevoApellido);

            System.out.print("Nueva edad: ");
            int nuevaEdad = sc.nextInt();
            sc.nextLine();
            persona.setEdad(nuevaEdad);

            System.out.print("¿Está casado? (true/false): ");
            boolean nuevoCasado = sc.nextBoolean();
            sc.nextLine();
            persona.setEstaCasado(nuevoCasado);

            System.out.print("Nuevo DNI: ");
            String nuevoDni = sc.nextLine();
            persona.setDni(nuevoDni);

            System.out.println("Cliente actualizado:");
            System.out.println(persona);

        } else {
            System.out.println("No lo he encontrado  :-(");
        }
    }

    // borrar cliente
    public static void borrarCliente(ArrayList<Persona> miLista, Scanner sc) {
        int indice = buscarPorNombre(miLista, sc); // busca si existe y el indice

        if (indice != -1) {
            Persona persona = miLista.get(indice);
            System.out.println("Persona encontrada:");
            System.out.println(persona);
            miLista.remove(indice); //borra elemento
            System.out.println("Persona eliminada correctamente.");

        } else {
            System.out.println("No se encontró ninguna persona con ese nombre.");
        }
    }

    // borrar persona con bucle for-each = MAL!
    public static void borrarForEach(ArrayList<Persona> miLista){
        //ConcurrentModificationException
        for (Persona persona : miLista) {
            if (persona.getNombre().equalsIgnoreCase("Pedro")) {
                miLista.remove(persona); //lo borra si el nombre es pedro
            }   
        }
    }

    // borrar persona con objeto Iterator
    public static void borrarIterator(ArrayList<Persona> miLista){
        Iterator<Persona> it = miLista.iterator();
        //String nombre = sc.next();
        while(it.hasNext()){ //mientras haya un siguiente,
            Persona persona = it.next(); // pillamelo
            if (persona.getNombre().equalsIgnoreCase("Pedro")) {
                it.remove();  //lo borra si el nombre es pedro
                System.out.println("Persona eliminada correctamente.");
            }   
        }
    }

    //tambien existe ListIterator, que tiene más opciones
    // por ejemplo, ir hacia atras en la lista (it.hasPrevious())
    
    
}
