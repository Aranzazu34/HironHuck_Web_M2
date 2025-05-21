import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {

    /*
     * 1- FIESTA EN TU CASA!  (JAVA VERSION)

        Montas una fiesta este finde en tu casa!
        Tienes una lista de 10 invitados en un arraylist

        – Michael, que estaba el primero de la lista, resulta que está de viaje y no puede venir
        – Te llama la Pepi que se apunta con su novio Silvester
        – Te encuentras a Eva, que dice que le cueles la tercera
        – Resulta que hay otra fiesta al lado la misma noche, con 10 personas más,  y toda esa gente dicen que les gusta vuestra música que se 
        apuntan a tu fiesta!
        – Mostrar la lista definitiva de invitados en orden alfabético. En un momento dado, tienes curiosidad por saber quién es el último de la 
        lista (mostrarlo)
        – Además, con tanto lío, te entra la duda de si tu amigo Pedro está incluído en la lista o no. Si está, decir en qué posición está. Si no, 
        decir que no está.

        A cada paso debe ir actualizándose la la lista de invitados en tu casa y qué proceso has hecho.
     * 
     */
    public static void ejercicio1(Scanner tcl){
       ArrayList<String> invitados1 = new ArrayList<>(Arrays.asList("Michael", "Donna", "Spencer", "John", "Samantha", 
       "Blake", "Martin", "Brenda", "Luke", "Pedro"));        
        System.out.printf("Invitados a mí fiesta:\t %s",invitados1);
        System.out.println();

        invitados1.remove(0); //Michael no puede venir
        System.out.printf("Michael es baja:\t %s",invitados1);
        System.out.println();
        invitados1.add(2,"Eva");
        System.out.printf("Eva en puesto 3:\t %s",invitados1);
        System.out.println();

        //invitados de la otra fiesta
        ArrayList<String> invitados2 = new ArrayList<>(Arrays.asList("Justin", "Kate", "Shakira", "alanis", "Bryan", 
       "Eric", "Isaac", "Cher", "Johny", "Amanda")); 
       System.out.printf("Invitados otra fiesta:\t %s",invitados2);
        System.out.println();   
        invitados1.addAll(invitados2);
        System.out.printf("Invitados agregados de la otra fiesta:\n %s",invitados1);
        System.out.println();

        //Mostrar la lista definitiva de invitados en orden alfabético. 
        Collections.sort(invitados1, String.CASE_INSENSITIVE_ORDER);
        System.out.printf("Invitados ordenados a mí fiesta:\n %s",invitados1);
        System.out.println();

        //En un momento dado, tienes curiosidad por saber quién es el último de la 
        //lista (mostrarlo)
        System.out.printf("Último Invitado:\n %s",invitados1.getLast());
        System.out.println();

        //Además, con tanto lío, te entra la duda de si tu amigo Pedro está incluído en la lista o no. Si está, decir en qué posición está. Si no, 
        //decir que no está.

        if(invitados1.contains("Pedro") )
            System.out.printf("Pedro está en la lista en la posición %d" , invitados1.indexOf("Pedro"));            
        else
            System.out.println("OMG! Pedro no está en la lista de invitados."); 


    }


    /*
     * 2- ArrayList de números enteros:
        • Pedir cuantos números quiere el usuario entrar
        • Hacer entrada de datos (números) en el bucle
        • Cuando tengas el ArrayList completo, hacer la media de todos los números y dar ese resultado en
        pantalla
     */
    public static void ejercicio2(Scanner tcl){
       System.out.println("Cuántos números quiere introducir?");
       int nums = tcl.nextInt();
       tcl.nextLine();

       ArrayList<Integer> numeros = new ArrayList<>(nums);
       int i=0;
       int numero;
       float sumNumeros = 0; //para que después salgan los decimales

        //cumplimentar la lista de los 5 invitados
       while(i<nums){
            System.out.printf("Introduce un número (faltan %d de %d)", i+1, nums);
            System.out.println();
            numero = tcl.nextInt();

            numeros.add(numero);
            i +=1;

            sumNumeros += numero;
       }

       System.out.println("Lista de numeros: " + numeros);
       System.out.println("La media de todos los numeros es (sumatoria numeros/cantidad numeros): " + (float) (sumNumeros/nums));
    }

    /*
     * 3- En la siguiente frase:

        String fraseAleatoria = "Los errores del pasado son la sabiduría del presente";
        Decir si existe la letra "e", cuántas veces aparece, y en qué posiciones.
     */
    public static void ejercicio3(Scanner tcl){
       String fraseAleatoria = "Los errores del pasado son la sabiduría del presentE";
       //String fraseAleatoria = "Los arroras dal pasado son la sabiduría dal prasantE";
       char   letra = 'e';

       //existe la letra "e"
       if(fraseAleatoria.indexOf(letra) != -1)
            System.out.println("La frase contiene la letra e");
       else
            System.out.println("La frase NO contiene la letra e");
        
        //total de letras "e"
        int conE = 0;
        ArrayList<Integer> posiciones =  new ArrayList<>();

        for(int i= 0; i<fraseAleatoria.length(); i++){
            //todo a tipo Char y en minúscula por si hay Mayusculas de la letra e
            if( Character.toLowerCase(fraseAleatoria.charAt(i)) == Character.toLowerCase(letra) ){ 
                //System.out.println("letra e encontrada");
                conE += 1;

                posiciones.add(i);
            }                
        }
        
        System.out.printf("La frase contiene %d letra/s 'e'", conE);
        System.out.println();
        System.out.println("En las posiciones: " + posiciones);
    

        /*Esto es muy PRO
        char letraAContar = 'e';
        long contador = texto.chars().filter(c -> c == letraAContar).count();
        System.out.println("La letra '" + letraAContar + "' aparece " + contador + " veces en el texto.");
        */
    }
    

    public static void extra(Scanner tcl){
       int i = 0;
    }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        //ejercicio1(teclado);
        //ejercicio2(teclado);
        ejercicio3(teclado);
        //extra(teclado);

        teclado.close();

    }
}
