package Electoral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Metodos {


    public Metodos() {
    }

    // limpia pantalla
    public static void limpiarPantalla(){        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    } 


    public static void aprietaEnter(Scanner teclado){
        String seguir;
        
        System.out.println("Para seguir, apretar Enter.");
        
        try{
            seguir = teclado.nextLine();
        }catch(Exception e){

        };

    }

    public static void limpiarListaPartidos(ArrayList<Partido> lista){
        Iterator<Partido> iterator = lista.iterator();

        while (iterator.hasNext()) {
            iterator.remove();
        }

    }



    //Pedir el porcentaje de votos recibido para cada uno de los partidos. Impide que se escriba un tipo diferente mediante hasNext() 
    //(ej: si se pide un entero, usar teclado.hasNextInt() )
    public static void introducirPartido(Scanner tcl, ArrayList<Partido> lista){
        String  nombre;
        float   porcentaje=0;
        boolean salir=false;
        int     i=1;

        float  total_porcentajes=0;
        
        aprietaEnter(tcl);

        do{
            System.out.println("Nombre de Partido:");
            nombre = tcl.nextLine();            

            System.out.println("Porcentaje de 0-100%:");
            porcentaje = tcl.nextFloat();
            tcl.nextLine();

            System.out.println();

            total_porcentajes += porcentaje;

            Partido partido = new Partido(nombre, porcentaje);

            lista.add(partido);

            if (total_porcentajes == 100 ){  //se ha llegado al 100%
                salir = true;
            }else if(total_porcentajes > 100){
                System.out.println("El sumatorio de % de los partidos es superior, es del "+ total_porcentajes);
                salir = true;
            }

            System.out.println();
            //System.out.println(i);
            i +=1;

        }while(!salir)
        ;

    }


    public static String imprimirCaracter(float dato){
        char caracter = '*'; // El caracter que quieres imprimir        
        String cadena="";

        for (int i = 0; i < (int) dato; i++) {
            cadena += caracter;
        }

        return cadena;
    }


    public static void mostrarResultado(ArrayList<Partido> lista){
        Iterator<Partido> iterator = lista.iterator();

        while (iterator.hasNext()) {
            Partido partido = iterator.next();
            System.out.println(partido + "   " + imprimirCaracter(partido.getPorcentaje()));
        }

    }


    //Cuando acabe que pregunte: ¿Actualizar resultados (S/N)? (*) Si dice que sí, limpia el terminal y vuelve a preguntar los resultados. 
    //Si dice que no, limpia el terminal y escribe “hasta la próxima!” y se acaba el programa. 
    public static boolean accion(Scanner tcl, ArrayList<Partido> lista){
        
        boolean salir=false;
        boolean repetir=false;

        System.out.println();

        do{

            System.out.println("Actualizar resultados? (S/N)");
            String dato = tcl.next();
            tcl.nextLine();

            if (dato.length() == 1) {
                char caracter = dato.charAt(0);

                if (Character.toUpperCase(caracter) == 'S' || Character.toUpperCase(caracter) == 'N') {
                    limpiarPantalla();

                    if (Character.toUpperCase(caracter) == 'S') {
                        //introducirPartido(tcl, lista);                        
                        repetir=true;
                    } else {                        
                        System.out.println("Hasta la próxima!");                        
                    }

                    salir=true;
                } else {
                    System.out.println("Dato incorrecto. Poner S/N");
                }
            } else {
                System.out.println("Solo poner S/N.");
            }

        }while(!salir);

        return repetir;

    }






}
