import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        do{
            System.out.println("\nelige opcion:\n1- Crear Cliente\n2- Mostrar todos\n3-Buscar por nombre\n4-Modificar cliente\n5-Borrar Cliente\n6-Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Gestoria.crearPersona(listaPersonas, sc);
                    break;

                    case 2:
                    Gestoria.mostrarLista(listaPersonas);
                    break;

                    case 3:
                    int indice = Gestoria.buscarPorNombre(listaPersonas, sc);
                    if (indice != -1) {
                        System.out.println("Está en la lista! " + " en la posición " + indice);
                    }else{
                        System.out.println("No lo he encontrado  :-(");
                    }
                    break;

                    case 4:
                    Gestoria.modificarCliente(listaPersonas, sc);
                    break;

                    case 5:
                    // Gestoria.borrarCliente(listaPersonas, sc);
                    //Gestoria.borrarForEach(listaPersonas);
                    Gestoria.borrarIterator(listaPersonas);
                    break;

                    case 6:
                    System.out.println("Hasta la vista, baby!");
                    break;

                default:
                    System.out.println("Debes introducir un número del 1 al 6");
            }

        }while(opcion!=6);


        // TEMA APARTE:
        // llamar al metodo cumpleaños() pasandole una persona específica como parametro

        //Persona personaCualquiera = new Persona("Pepe", "Lopez", 33, true, "23423342F");
        //cumple(personaCualquiera);
        cumple(listaPersonas.get(0)); //le pasa el primero que creamos
    }


    // metodo cumpleaños => añade uno a la edad
    // haciendolo solo con una persona, recibiriamos un objeto Persona al metodo
    public static void cumple(Persona persona){
        System.out.println(persona);
        persona.setEdad(persona.getEdad() + 1); //de la persona, solo pillamos la edad
        System.out.println("Feliz cumpleaños!");
        System.out.println(persona);
    }

}

    




/*
 * Persona p1 = new Persona(); // constructor vacío
        Persona p2 = new Persona("Robert", "Gonzalez", 43, false, "78451256P");

        // añadir al constructor vacío
        p1.setNombre("Laia");
        p1.setApellido("Martínez");
        p1.setEdad(36);
        p1.setEstaCasado(true);
        p1.setDni("25362548Q");
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        Persona p3 = new Persona();
        // introducir datos por usuario:
        System.out.println("Dime el nombre de la persona:");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido:");
        String apellido = sc.nextLine();

        System.out.println("Dime la edad:");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Está casado? (true/false):");
        boolean casado = sc.nextBoolean();
        sc.nextLine();

        System.out.println("DNI:");
        String dni = sc.nextLine();

        p3.setNombre(nombre);
        p3.setApellido(apellido);
        p3.setEdad(edad);
        p3.setEstaCasado(casado);
        p3.setDni(dni);
        System.out.println("persona 3:");
        System.out.println(p3);

        // Persona p4 = p3; //copia referencia de memoria == MAL

        Persona p4 = new Persona(nombre, apellido, edad, casado, dni);
        System.out.println("persona 4:");
        System.out.println(p4);
        p4.setNombre("Carmen");
        p4.setApellido("García");
        p4.setEdad(26);
        p4.setEstaCasado(true);
        p4.setDni("5623683265R");
        System.out.println("persona 4:");
        System.out.println(p4);

        // ArrayList de objetos Persona
        ArrayList<Persona> listaPersonas = new ArrayList<>(); 

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
        System.out.println("------------------------");
        System.out.println(listaPersonas);

        /* si no es static, me obliga a instanciar un objeto Gestoria
        Gestoria g1 = new Gestoria();
        g1.mostrarLista(listaPersonas); //mostrar primera vez
        */

        // si los metodos de Gestoria son static, no hace falta instanciar objeto gestoria
        /* 
        Gestoria.mostrarLista(listaPersonas); //mostrar primera vez
        p1.setNombre("Mireia");
        p4.setEdad(62);

        Gestoria.mostrarLista(listaPersonas); //mostrar segunda vez

        System.out.println(Gestoria.buscarPorNombre(listaPersonas, sc));
       */

        //sc.close();
 