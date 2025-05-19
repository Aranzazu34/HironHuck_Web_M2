import java.util.Arrays;
import java.util.Scanner;

public class App {
    //1 - Crear un array de lo que desees, pero con el tamaño que diga el usuario. Luego añadir elementos hasta que se rellene. Luego mostrarlo.
    //+EXTRA: Añadir los elementos desde un bucle
    public static void ejercicio1(Scanner tcl){
       System.out.println("Introducir tamaño array:");
       int nelementos = tcl.nextInt();
       tcl.nextLine();

       String[] elems = new String[nelementos]; //inicializar el array con el número de elementos, que se solicita
       String   elemento;

       //rellenar array con datos
       for(int i = 0; i < nelementos; i++){
            System.out.printf("Introduce elemento %d en la array:", i);
            elemento = tcl.nextLine();

            elems[i] = elemento;
       }

       //imprimir valores
       System.out.println(Arrays.toString(elems));

    }

    //2 - Tienes un array de 20 números enteros: decir cuales son pares e impares. Recordar el módulo (%) (resto de una división) 10%3 => 1
    // +EXTRA: añadirlos a nuevos arrays: 'arrayPares' y 'arrayImpares', y al final mostrar los tres arrays. En este caso, deberías saber por 
    // adelantado el length de cada uno (que hay 3 pares y 5 impares), o bien hacer arrays más grandes y dejar los últimos en null.
    public static void ejercicio2(Scanner tcl){
       int[] enteros = new int[20];
       int  numero;

       //agregar los valores a la tabla de enteros
       for(int i = 0; i < 20; i++){
            numero = (int) (Math.random() *  50 );

            if (!enteros.equals(numero)){
                enteros[i] = numero;
            }else{
                i -= 1;  //porque en esa posición no se agregó
            }
            
       }
       
       System.out.println(Arrays.toString(enteros));
       System.out.println("");

       int[] arrayPares = new int[20];
       int np=0;
       int[] arrayImpares = new int[20];
       int ni=0;

       //recorrer la Array de enteros, y almacenar los enteros pares en la arrayPares y los impares en arrayImpares
       for(int j=0; j<enteros.length; j++){
            if( (enteros[j]%2) == 0 ){
                arrayPares[np] = enteros[j];
                np += 1;
            }else{
                arrayImpares[ni] = enteros[j];
                ni += 1;
            }
        }

        /*
        System.out.println("Array inicial de enteros: " +Arrays.toString(enteros));
        System.out.println("Array de enteros Pares: " +Arrays.toString(arrayPares));
        System.out.println("Array de enteros Impares: " +Arrays.toString(arrayImpares));
        */

        //de cada array de Pares e Impares, elimino los 0
        System.out.println("np: " + np);
        int[] new_arrayPares = new int[np];

        for(int i=0; i<np; i++){
            new_arrayPares[i] = arrayPares[i];
        }

        System.out.println("ni: " + ni);
        int[] new_arrayImpares = new int[ni];

        for(int i=0; i<ni; i++){
            new_arrayImpares[i] = arrayImpares[i];
        }

        //ordenar arrays
        Arrays.sort(enteros);
        Arrays.sort(new_arrayPares);
        Arrays.sort(new_arrayImpares);

       System.out.println("Array inicial de enteros: " +Arrays.toString(enteros));
       System.out.println("Array de enteros Pares: " +Arrays.toString(new_arrayPares));
       System.out.println("Array de enteros Impares: " +Arrays.toString(new_arrayImpares));

    }

    //3- Premio vacaciones en Ibiza: tienes un listado de nombres de personas en un array. 
    //Aleatoriamente, seleccionar el ganador y mostrarlo. 
    //Entonces preguntar: "otra vez? (S/N)", y si es que sí, volver a generar nuevo ganador y mostrarlo. 
    //Seguir preguntando hasta que el usuario diga que no.
    public static void ejercicio3(Scanner tcl){
        String[] personas = {"Antonio", "Yvet", "Macarena", "Iu", "Jorge", "Yadira", "Luca", "Martín", "Leyre"};
        int     total = personas.length;
        int     ganador;
        boolean salir = false;
        String  continuar;

        do{

            ganador = (int) (Math.random() * total);
            System.out.printf("El ganador es: %s\n", personas[ganador]);

            System.out.println("Otra vez? S/N:\t");     
            continuar = tcl.nextLine();

            if(continuar.equalsIgnoreCase("N")){
                salir = true;
            }

        }while(!salir);

    }

    public static void extra(Scanner tcl){
       int i = 0;
    }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        ejercicio1(teclado);
        //ejercicio2(teclado);
        //ejercicio3(teclado);
        //extra();

        teclado.close();

    }
}
