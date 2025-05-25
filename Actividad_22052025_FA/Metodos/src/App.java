import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Vamos a probar algunos métodos");

        //sobrecarga de m´´etodos: mismo nombre de método, diferentes parámetros
        ejer1();
        ejer1("pepito", "juanita");
        
        String nom1 = "jaimito";
        String nom2 = "federica";
        ejer1(nom1, nom2);

        String nom3 = "roberto";
        String nom4 = "maria";
        ejer1(nom3, nom4);

        //ejer2("Garcia", 2);
        Scanner teclado = new Scanner((System.in));
        String texto = ejer2(teclado);
        System.out.println(texto);

        ArrayList<String> listaInvitados = new ArrayList<>();
        listaInvitados.add("pepito");
        listaInvitados.add("juanito");
        listaInvitados.add("jaimito");
        System.out.println("primera lista:");
        mostrarInvitados(listaInvitados);
        System.out.println();

        listaInvitados.add("francisca");
        listaInvitados.add("josefa");
        listaInvitados.set(1,"jaime");
        System.out.println("segunda lista:");
        mostrarInvitados(listaInvitados);  
        System.out.println();

        listaInvitados.clear();
        System.out.println("tercera lista:");
        mostrarInvitados(listaInvitados);          

    }

    
    //directas sin return
    static void ejer1(){
        System.out.println("hola mundo sin parámetros");
    }
    
    //recibe argumentos
    static void ejer1(String nombre1, String nombre2){
        System.out.println("hola, dijo " + nombre1 + " a " + nombre2);
    }

    
    static String ejer2(Scanner sc){
        System.out.println("dime un nombre:");
        String nombre = sc.nextLine();
        System.out.println("dime una opción:\n1-te cae bien\n2-te cae mal");
        int opcion = sc.nextInt();

        if(opcion == 1){
            return "a mí " + nombre + " me cae bien";
        }else{
            return "a mí " + nombre + " me cae mal";
        }
    }

    public static void mostrarInvitados(ArrayList<String> listaActualizada) {

        if(!listaActualizada.isEmpty()){
            for(String invitado: listaActualizada){
                System.out.println();
                System.out.println("bienvenido el invitado numero "+ (listaActualizada.indexOf(invitado)+1) + 
                                   ": " +invitado);
                System.out.println();
            }
        }else{
            System.out.println("La lista está vacía");
        }
    }

}
