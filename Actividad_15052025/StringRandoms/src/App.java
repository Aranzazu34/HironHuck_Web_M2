import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String saludo = "Hello, World! Are you great?";  // String va con comilas dobles
        char letra = 'A'; // char va con comillas simples
        System.out.println("la variable letra es: "+letra);
        System.out.println(saludo.charAt(7));
        
        //lenght te dice la longitud dele String (cantidad de caracteres)
        System.out.println("la frase tiene tantos caracteres: "+saludo.length());

        //como haríamos para recorrer toda la frase letras una a una?
        for(int i=0;i<saludo.length();i++){
            System.out.print(saludo.charAt(i));
        }
        System.out.println();

        Scanner teclado = new Scanner(System.in);
        System.out.println("dime una letra");
        char letraUser = teclado.next().charAt(3);  //te devolvera una letra de la posición en una cadena
        System.out.println("has escrito: "+letraUser);

        //metodos string:
        //toUpperCase()  => todo a mayúsculas
        //toLowerCase()  => todo a minúsculas        
        //equals()       => para comparar
        //equalsIgnoreCase() => para comparar sin may/min
        //replace        => cambia una letra por otra
        //replaceAll     => cambia todo (usar regexp)
        
        System.out.println(saludo.replace("e","u"));

        int num1 = 8978; //int tipo primitivo
        String numString = Integer.toString(num1);  //Integer es wrapper
        String numString2 = "" + num1;
        
        System.out.println("el numero en string: "+ numString2);

        String numerito = "5";
        int numeritoInt = Integer.parseInt(numerito);
        System.out.println(numeritoInt*numeritoInt);
        System.out.println(Math.pow(numeritoInt, 2));
        
        /* numeros random */
        /* sin hacer da un decimal de o a o.9999.. */
        //para un entero del 1 al 10
        int numeroRandom = (int) (Math.random() * 10) + 1;
        System.out.println("Num Ramdom: " + numeroRandom);
        
        teclado.close();

    }

}
