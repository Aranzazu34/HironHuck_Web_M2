import java.io.IOException;
import java.util.Scanner;

public class App {
    
    /*
     * 1- SALUDAR!
        Pides saludo y nombre (ejemplo: ‘Hola’ y ‘Andrés’)
        Y te responde ‘Hola Andrés’.


        Realizar el método de saludar, de tres maneras diferentes:


        1.1- Llamas al método desde el main, sin parámetros, y sin return, y te hace el programa entero, incluyendo scanner etc (resultado ejemplo: ‘Hola Andrés’).

        Resumen: llamas al método y allí haces todo


        1.2 -- Llamas al método, con parámetros (saludo y nombre) (scanner en el main antes de llamar al método), y sin return, y muestra el resultado DENTRO del método (resultado ejemplo: ‘Hola Andrés’).

        Resumen: pides saludo y nombre, lo pasas al método y imprimes el resultado desde el método


        1.3- Llamas al método, con parámetros (saludo y nombre), y con return, y muestra el resultado FUERA de ese método, y dentro del main() (resultado ejemplo: ‘Hola Andrés’).

        Resumen: pasas saludo y nombre al método, creas la frase en el método y lo retornas al main(), donde imprimes el resultado.
     */
     //ejercicio 1.1
     public static void saludar(){
       Scanner teclado = new Scanner(System.in);
       
       System.out.println("Introduce saludo: ");
       String saludo = teclado.nextLine();
       System.out.println();

       System.out.println("Introduce nombre: ");
       String nombre = teclado.nextLine();
       System.out.println();   
       
       System.out.println(saludo + " " + nombre);

       teclado.close();

    }

    //ejercicio 1.2
    static void saludar(String saludo, String nombre){
       System.out.println(saludo + " " + nombre);
    }

    //ejercicio 1.3
    static String saludar(String saludo, String nombre, Scanner tcl){
        System.out.println("Introduce saludo: ");
        saludo = tcl.nextLine();
        System.out.println();

        System.out.println("Introduce nombre: ");
        nombre = tcl.nextLine();
        System.out.println();  

        return saludo + " " + nombre;
    }

    /*
     * 2- CALCULAR
    Con switch, preguntar la operación ( ‘sumar’, ‘restar’, ‘multiplicar’ y ‘dividir’ ), y desde cada caso, envíalo a una función diferente 
    ( ‘metodoSumar’, ‘metodoRestar’, ‘metodoMultiplicar’ y ‘metodoDividir’ ) que retorne el resultado a esa opción del switch y se muestre en 
     terminal.

    Resumen: desde cada caso del switch, llamas a un método u otro, y lo imprimes desde ese caso.


    +EXTRA: Opcional: colocar todo el programa en un bucle que siga funcionando mientras que el usuario no escriba “s” (salir).

    +EXTRA: usar char y (+, -, *,/) cuando le pides al usuario qué quiere hacer
     */
    static float metodoSumar(float a, float b){
       return a + b;
    }

    static float metodoRestar(float a, float b){
       return a - b;
    }

    static float metodoMultiplicar(float a, float b){
       return a * b;
    }

    static float metodoDividir(float a, float b){
        if(b == 0){
            return -1;
        }

       return a / b;
    }    

    static void ejercicio2(Scanner tcl) throws IOException{
        char salir;  //EXTRA 1
        String operacion;

        do{
                System.out.println("Introduce el numero a:");
                int a = tcl.nextInt();

                System.out.println("Introduce el numero b:");
                int b = tcl.nextInt(); 
                tcl.nextLine();

                System.out.println("Introduce la operación ( sumar, restar, multiplicar y dividir ):");
                operacion = tcl.nextLine().toLowerCase();

                float resultado=0;

                switch (operacion) {
                    case "sumar":
                        resultado = (float) metodoSumar(a, b);
                        break;
                    case "restar":
                        resultado = (float) metodoRestar(a, b);
                        break;
                    case "multiplicar":
                        resultado = (float) metodoMultiplicar(a, b);
                        break;
                    case "dividir":
                        resultado = (float) metodoDividir(a, b);
                        break;                                                      
                    default:
                        resultado = -2;
                        break;
                }
                
                if (resultado == -2) {
                    System.out.println("No se ha introducido una operación correctamente");
                }else if (resultado == -1){
                    System.out.println("El dividendo de la operación de dividir es 0, no es factible");
                }else{
                    System.out.printf("El resultado de la operación %s de los numeros %d y %d es: %.2f%n", operacion, a, b, resultado);
                    System.out.println();
                }

                System.out.println("Continuar (s/n)?");
                salir = (char) System.in.read();
                salir = Character.toLowerCase(salir);
                System.out.println();
            
            }while (salir == 's');

    }

    static void ejercicio2_extra2(Scanner tcl) throws IOException{
        char salir='s';  //EXTRA 2
        char operacion;

        do{
                System.out.println("Introduce el numero a:");
                int a = tcl.nextInt();

                System.out.println("Introduce el numero b:");
                int b = tcl.nextInt(); 
                tcl.nextLine();

                System.out.println("Introduce la operación ( +, -, * y / ):");
                operacion = (char) System.in.read();
                tcl.nextLine();
                
                float resultado=0;

                System.out.println("operacion: "+operacion);

                switch (operacion) {
                    case '+':
                        resultado = (float) metodoSumar(a, b);
                        break;
                    case '-':
                        resultado = (float) metodoRestar(a, b);
                        break;
                    case '*':
                        resultado = (float) metodoMultiplicar(a, b);
                        break;
                    case '/':
                        resultado = (float) metodoDividir(a, b);
                        break;                                                      
                    default:
                        resultado = -2;
                        break;
                }
                
                if (resultado == -2) {
                    System.out.println("No se ha introducido una operación correctamente");
                }else if (resultado == -1){
                    System.out.println("El dividendo de la operación de dividir es 0, no es factible");
                }else{
                    System.out.printf("El resultado de la operación %c%n de los numeros %d y %d es: %.2f%n", operacion, a, b, resultado);
                    System.out.println();
                }
                
                System.out.println("Continuar (s/n)?");
                salir = (char) System.in.read();
                salir = Character.toLowerCase(salir);
                tcl.nextLine();
                System.out.println();
            
            }while (salir == 's');

    }    


    /*
     * 3- CACATÚA CACAHUETES!

        Tienes una cacatúa que todo el rato te pide comer cacahuetes, diciendo “cacatúa cacahuetes!”.

        El programa te pregunta qué comida le das.

        Mientras NO sean cacahuetes, sigue diciendo “cacatúa cacahuetes!”

        Pero si le das cacahuetes, llama al método ‘dormirse’ y se calla, y en vez del mensaje anterior,
        vemos ‘zzZzzzz…’ (aquí acaba el programa)

        *EXTRA: realizar no solo el método 'dormirse()', sino también el de 'pideComida()'
     * 
     */

    static void dormirse(){
        System.out.println("zzZzzzz...");
        System.out.println();
    }

    static void pideComida(){
        System.out.println("cacatúa cacahuestes!");
        System.out.println();
    }

    static void ejercicio3(Scanner tcl){
        System.out.println("Qué comida le das a la cacatúa?");
        String comida = tcl.nextLine().toLowerCase();

        while (!comida.equals("cacahuetes")) {
            pideComida();

            System.out.println("Qué comida le das a la cacatúa?");
            comida = tcl.nextLine().toLowerCase();

        }

        dormirse();

    }

    /*
     * 4- MODIFICAR FRASE

        Métodos sobre frase  enviada por cliente:

        Se pide en el main() una frase (String) y una opcion (int o byte) y se envian a tratarFrase()

        - Si la opción es 1, devolver la frase en mayúsculas

        - Si la opción es 2, devolver la frase en minúsculas

        - Si la opción es 3, devolver la frase al revés (puedes buscar un método directo para esto)

        Retornar el resultado e imprimirlo desde el método main().
     */

     public static String tratarFrase(String frase, int opcion){
            switch (opcion) {
                case 1:
                    return frase.toUpperCase(); 
                case 2:
                    return frase.toLowerCase();
                case 3:
                    StringBuffer frase2 = new StringBuffer(frase);
                    return frase2.reverse().toString();                               
                default:
                    return "opción errónea!";
            }
     }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        //ejercicio 1.1
        //saludar();

        //ejercicio 1.2
        // System.out.println("Introduce saludo: ");
        // String saludo = teclado.nextLine();
        // System.out.println();

        // System.out.println("Introduce nombre: ");
        // String nombre = teclado.nextLine();
        // System.out.println();  
        // saludar(saludo, nombre);  
        
        //ejercicio 1.3
        // String saludo = null;
        // String nombre = null;
        // String frase = saludar(saludo, nombre, teclado);
        // System.out.println(frase);

        //ejercicio 2
        //ejercicio2(teclado);
        //ejercicio2_extra2(teclado);

        //ejercicio3(teclado);

        //EJERCICIO 4
        boolean salir=false;
        char char2 = 's';

        do{
            System.out.println("Introduce una frase:");             
            String frase= teclado.nextLine();
            System.out.println();

            System.out.println("Elige una opción para transformar la frase (1- Mayúsculas, 2- Mínusculas, 3- Al revés):");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println();

            System.out.println("'"+"El resultado es: " + tratarFrase(frase, opcion)+"'");
            System.out.println();

            System.out.println("Continuar (s/n)?");             
            char c= (char) System.in.read();
            teclado.nextLine();

            //System.out.println(Character.toString(c).toLowerCase());
            if( c != char2){
                System.out.println("SAAAALIIIIR");
                salir = true;
            }


        }while(!salir);


        teclado.close();

    }
}