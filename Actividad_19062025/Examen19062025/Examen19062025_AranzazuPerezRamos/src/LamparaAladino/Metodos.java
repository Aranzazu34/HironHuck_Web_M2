package LamparaAladino;

import java.util.ArrayList;
import java.util.Scanner;


public class Metodos {

    
    public static void limpiarPantalla(){        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    } 

    public static void introducirDeseos(Scanner tcl, ArrayList<String> deseos){

        String deseo;
        String opcion;
        boolean salir=false;

        do{
            System.out.println("Introduce un deseo:\n");
            deseo = tcl.nextLine();

            deseos.add(deseo);

            boolean exito = false;

            do{
                System.out.println("\nContinua introduciendo deseos? (S/N)\n");
                opcion = tcl.nextLine();
                System.out.println();

                if (opcion.equalsIgnoreCase("S")) {
                    exito = true;
                } else if (opcion.equalsIgnoreCase("N")) {
                    salir = true;
                    exito = true;
                } else {
                    System.out.println("Opción no válida.");
                }

            }while (!exito);

        }while(!salir);

    }

    public static void obtenerDeseo(ArrayList<String> lista){

        int num_deseos = lista.size();  //obtenemos el numero de deseos de la lista

        //vamos a aplicar el random, para obtener el numero, para acceder al deseo 
        //de la lista en su posición
        int posicion = (int) (Math.random() * num_deseos ) + 1;
        //System.out.println("\nposicion " +posicion);

        System.out.println("\nLa lista de deseos es:\n");

        for (String d : lista) {
            System.out.println(d.toString());
        }
        
        System.out.println();

        System.out.printf("Has pedido %d deseos, y se te ha concedido: %s.", num_deseos, lista.get(posicion));

    }

}
