import java.util.Scanner;

public class App {
    /*
     * 1- El usuario tiene que acertar un número del 1 al 5, generado aleatoriamente. Le vas preguntando hasta que acierte.

          Al final, decir en cuantos intentos lo ha conseguido.
     */
    public static void ejercicio1(Scanner tcl){
       int numeroRandom = (int) (Math.random() * 5) + 1;
       System.out.println("Num Ramdom: " + numeroRandom);

       boolean salir = false;
       int     numUser;
       int     nIntentos=0;

       while (!salir) {
            System.out.println("Dí un numero del 1 al 5, a ver si lo aciertas!");
            numUser = tcl.nextInt();
            nIntentos += 1;

            if (numUser == numeroRandom) {
                System.out.println("Enhorabuena acertaste! El número es: " + numUser);
                salir = true;
            }
       }

       System.out.printf("Lo has conseguido en %d intentos", nIntentos);
       
    }

    /*2- Tienes un color preseleccionado, por ejemplo el rojo, y le preguntas al usuario un color a ver si lo acierta (hasta tres intentos) */
  
    public static void ejercicio2(Scanner tcl){
       String   colorPre= "naranja";
       String   colorUser;
       boolean  salir=false;
       int      Intentos=3;
       int      numIntentos=0;

        int i=0;
        int lcolores=0;

       do{

            System.out.println("Dí un color, a ver si coincide con el preseleccionado!");
            colorUser = tcl.nextLine();

            numIntentos += 1;

            //se compara sí las cadenas contienen el mismo color
            if ( colorUser.compareToIgnoreCase(colorPre) == 0 ){
                   System.out.printf("El color %s, se ha obtenido después de %d intentos\n",colorUser,numIntentos);
                   salir=true;  //significa que han coincidido todas las letras
            }else{
                //controlar que se han realizado los 3 intentos
                if ( numIntentos == Intentos ){
                    salir=true;
                    System.out.printf("El color %s no coincide con el preseleccionado %s, se han realizado %d intentos\n",colorUser,colorPre,numIntentos);
                }                   
            }           
            
            System.out.println(numIntentos + " " + Intentos + " " + Boolean.toString(salir));               

        }while(!salir);

    }
    
    
    //3- Se introduce una frase y se devuelve  el texto a la inversa. Ejemplo: olpmejE
    public static void ejercicio3(Scanner tcl){
        System.out.println("Introduzca una palabra:");
        String palabra = tcl.nextLine();
        
        String palabraReves="";

        for(int i = palabra.length()-1; i>=0;i--){
            //usé la siguiente instrucción porque la comentada en su momento, no me funcionó (me dejaría algo seguramente)
            palabraReves += Character.toString(palabra.charAt(i));
            //palabraReves += palabra.charAt(i);
        }

        System.out.printf("La palabra inicial %s, se ha convertido al revés en %s",palabra,palabraReves);

    }

    /*4- Pides un numero de teléfono y le quitas, si hay, los guiones:   456-453-78 quedaría como 45645378 */
    public static void ejercicio4(Scanner tcl){
        System.out.println("Introduzca un telefono:");
        String telefono = tcl.nextLine();
    
        if ( telefono.contains("-"))
            //Se substituyen los '-' y los ' '
            System.out.println("El teléfono es: " + telefono.replace("-", "").replace(" ", ""));

    }

    /*5- Se pide un texto. Decir si está compuesto solo de minúsculas, solo de mayúsculas o si combina mayúsculas y minúsculas. */
    public static void ejercicio5(Scanner tcl){
        System.out.println("Introduzca un texto:");
        String texto = tcl.nextLine();

        boolean textoMin=false;
        boolean textoMay=false;

        for(int i=0; i< texto.length(); i++){
            char c=texto.charAt(i);
            if(Character.isUpperCase(c)){
                textoMay=true;
            }

            if(Character.isLowerCase(c)){
                textoMin=true;
            }
        }
        

        String combinacion = Boolean.toString(textoMay)+"-"+Boolean.toString(textoMin);

        switch (combinacion) {
            case "false-true" -> System.out.println("El texto solo contiene minúsculas.");
            case "true-false" -> System.out.println("El texto solo contiene mayúsculas.");
            default -> System.out.println("Combinación de texto en minúsculas/mayúsculas.");
        }

    }

    public static int obtenerCantidad(Scanner tcl){
        System.out.println("Introduzca la cantidad de veces que va a introducir una letra:");
        int cantidad = tcl.nextInt();
        tcl.nextLine();

        return cantidad;
    }

    //6- En un bucle, según la cantidad de veces que indica el usuario, 
    //se va pidiendo una letra cada vez, y se imprime: "has escrito A", "has escrito m", etc
    public static void ejercicio6(Scanner tcl){
        // System.out.println("Introduzca la cantidad de veces que va a introducir una letra:");
        // int cantidad = tcl.nextInt();
        // tcl.nextLine();
        int cantidad = obtenerCantidad(tcl);

        int i=1;
        String letra;

        //System.out.printf("cantidad %d\n",cantidad);
        while (i<=cantidad) {
            System.out.printf("i: %d\n",i);

            System.out.println("Introduzca una letra:");
            letra = tcl.nextLine();  
            
            //Si se ha introducido una única letra y no ha sido salto de línea
            if (letra.length()==1 && !letra.isEmpty()){
                //se va concatenando en un String, las letras introducidas por el usuario
                System.out.printf("has escrito %s\n", letra);
                i += 1;
            }

        }

    }

    //EXTRA: En un bucle, según la cantidad de veces que indica el usuario, se va pidiendo una letra cada vez, y se van guardando todas las 
    //letras juntas en una variable String. Ejemplo, el usuario entra los char: a, l, m, e, n, d, r, o, y se imprime al final el String "almendro" 
    //(hay que investigar para conseguir hacer el cambio de tipo)
    public static void extra(Scanner tcl){
        // System.out.println("Introduzca la cantidad de veces que va a introducir una letra:");
        // int cantidad = tcl.nextInt();
        // tcl.nextLine();
        int cantidad = obtenerCantidad(tcl);

        int i=1;
        String letra;
        String escrito="";

        //System.out.printf("cantidad %d\n",cantidad);
        while (i<=cantidad) {
            System.out.printf("i: %d\n",i);

            System.out.println("Introduzca una letra:");
            letra = tcl.nextLine();  
            
            //el espacio en blanco lo considera caracter, pero si no se introduce "caracter del teclado" 
            //y das a intro (como conseguir considerarlo espacio en blanco???). De la siguiente manera
            if (letra.length()==1 && !letra.isEmpty()){
                //se va concatenando en un String, las letras introducidas por el usuario
                escrito += letra;
                i += 1;
            }


        }

        System.out.printf("Has escrito %s",escrito);
    }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        //ejercicio1(teclado);
        //ejercicio2(teclado);
        //ejercicio3(teclado);
        //ejercicio4(teclado);
        //ejercicio5(teclado);
        //ejercicio6(teclado);
        extra(teclado);

        teclado.close();

    }
}
