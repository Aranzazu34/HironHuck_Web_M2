import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);    

        int posicion = teclado.nextInt(); //lee el numero

        teclado.nextLine(); //lee el salto de línea y poder continuar con el resto de datos a introducir

        /*
         * 1- ENTRADA ESTUDIANTE IRONHACK

                Estás dando entrada a cada nuevo estudiante de Ironhack, uno a uno, y le preguntas:

                - nombre
                - apellido
                - edad                

                Imprimir frase con estos 3 datos, del tipo:                

                “Te llamas José Luis González y tienes 25 años. Bienvenid@ a Ironhack!”
        */


        System.out.println("Nombre:");
        String nombre = teclado.nextLine(); //lee un String
        System.out.println("Apellido:");
        String apellido = teclado.nextLine(); //lee un String
        System.out.println("Edad:");
        String edad = teclado.nextLine(); //lee un String

        
    
                
        /*
             2- Luego, añade la posición de entrada en entero, al principio del cuestionario. 
             ¿Qué ocurre?  (no usar bucles ni nada)

             Para que se imprima: en el puesto 5, está Alberto García con 20 años"
         */
         
         System.out.println("en el puesto " + posicion + ", está Alberto García con 20 años\"");
         System.out.println("Te llamas " + nombre + " " + apellido + " y tienes " + edad + " años. Bienvenid@ a Ironhack!");

        teclado.close(); 

    }
}
