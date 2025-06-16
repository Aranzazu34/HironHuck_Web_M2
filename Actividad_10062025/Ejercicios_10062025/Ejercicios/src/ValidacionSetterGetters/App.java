package ValidacionSetterGetters;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /*
     * 2- (medio) Ejercicio validación setter, y ArrayLists:
Tienes el objeto ClienteDiscoteca.
Tienes un arraylist de clientes discoteca ya creados.
Antes de añadir un cliente más en el arraylist, debes verificar si el cliente tiene 18 años o más. Si es
mayor de edad, se añade el cliente, si no, se le da un mensaje de que no puede entrar.
Si es mayor de edad, imprimir nombre, edad y bienvenid@ a nuestra discoteca.

+EXTRA: hacer esto en un bucle while (para salir escribe 'salir'), y guardar dos arraylist, uno con los clientes aceptados y otro con los 
rechazados. Mostrar ambos al final.
     */

    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);        

        ArrayList<ClienteDiscoteca> cliAceptados = new ArrayList<ClienteDiscoteca>();
        ArrayList<ClienteDiscoteca> cliRechazados = new ArrayList<ClienteDiscoteca>();

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush(); 

        String  nombre;
        int     edad;
        boolean salir=false;

        do{    

            System.out.println("Nombre Cliente:");
            nombre = tcl.nextLine();

            System.out.println("Edad Cliente:");
            edad = tcl.nextInt();
            tcl.nextLine();

            ClienteDiscoteca cliente = new ClienteDiscoteca(edad, nombre);

            System.out.println();

            if ( edad >= 18 ){
                cliAceptados.add(cliente);
                System.out.println(nombre + ", " + edad + " años. Bienvenid@ a nuestra discoteca.\n");
            }else{
                cliRechazados.add(cliente);
                System.out.println(nombre + ", " + edad + " años. No puede entrar a la discoteca, por ser menor de edad.\n");
            }

            System.out.println("Quiere salir? (true/false)");
            salir = tcl.nextBoolean();
            tcl.nextLine();   
            System.out.println();            


        }while(!salir)
        ;    
        
        System.out.println();
        
        System.out.println("Clientes rechazados por la edad:");
        System.out.println("==============================================");
        for (ClienteDiscoteca clienteDiscoteca : cliRechazados) {
            System.out.println(clienteDiscoteca.getNombre() + ", " + clienteDiscoteca.getEdad()+" años");            
        }

        System.out.println();

        System.out.println("Clientes Aceptados:");
        System.out.println("==============================================");
        for (ClienteDiscoteca clienteDiscoteca : cliAceptados) {
            System.out.println(clienteDiscoteca.getNombre() + ", " + clienteDiscoteca.getEdad()+" años");            
        }  
        
        System.out.println();

        tcl.close();
    }
}
