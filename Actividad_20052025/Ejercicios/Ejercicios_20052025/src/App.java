import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    //1- Rellenar ArrayList y mostrar resultado:
    //Crear un arraylist mediante un bucle con los números del 20 al 50. Mostrar después todo el contenido del arraylist final.
    public static void ejercicio1(Scanner tcl){
       ArrayList<Integer> numeros = new ArrayList<>();

       for(int i=20; i<=50; i++){
            numeros.add(i);
       }

       System.out.println(numeros);
    }

    //2- Preguntar al usuario elementos típicos de la fiesta de Sant Jordi.
    //Para acabar, escribir 'salir'. Al final, mostrar todos los elementos introducidos por el usuario.
    public static void ejercicio2(Scanner tcl){
       List<Object> elemSJordi = new ArrayList<>();
       boolean salir = false;
       String  elem;

       do{
            System.out.println("Dí un elemento del día de St. Jordi:\n");
            elem = tcl.nextLine();

            if(elem.equalsIgnoreCase("salir")){
                salir = true;
            }else{
                elemSJordi.add(elem); 
                //no se puede al tener que controlar el salir elemSJordi.add(tcl.nextLine());
            }
            
       }while(!salir);

       System.out.println(elemSJordi);
    }

    /*3- CRUD: recepción internacional... y universal!
    Te han encargado organizar la recepción oficial para el primer contacto extraterrestre, en la montaña de Montserrat.
    Solo unos pocos en el mundo pueden asistir. ¿A quién enviarías? De momento la lista sólo puede ser de cinco elegid@s.
    Pero dos de ellos, en los puestos 2 y 3, se asustan y se dan de baja, y entra entonces el personaje X (darle nombre) en el puesto 2.
    La persona que está en el último puesto, se pone enferma y te recomienda que pongas en su lugar al personaje Y (darle nombre). 
    Ojo con saber qué índice es el último
    En el último momento, se añade el personaje Z (darle nombre) al puesto vacante (puesto 3).
    Ves mostrando a cada paso cómo va quedando la lista actualizada: los medios están muy interesados en seguir la noticia al minuto!

    */
    public static void ejercicio3(Scanner tcl){
       ArrayList<String> invitados = new ArrayList<>(5);
       int i=0;
       String invitado;

        //cumplimentar la lista de los 5 invitados
       while(i<5){
            System.out.println("Cumplimenta la lista de invitados (solo son 5)");
            invitado = tcl.nextLine();

            invitados.add(invitado);
            i +=1;
       }

       System.out.println("Lista de invitados: " + invitados);

       //se dan de baja los invitado 2 y 3
       invitados.remove(2);
       System.out.println("se va el 2: " + invitados);

       invitados.remove(3);
       System.out.println("se va el 3: " + invitados);

       //se añade en la posición 2 el nuevo
       System.out.println("Nuevo invitado en posición 2");
       invitado = tcl.nextLine();       
       invitados.add(2,invitado);
       System.out.println(invitados);

       //la última persona del momento se da de baja y hay que substituirla por otra   
       int ult_invitado = invitados.size();

       System.out.printf("Nuevo invitado remplazara al invitado %d (%s)\n",ult_invitado,invitados.get(ult_invitado-1));
       invitado = tcl.nextLine(); 
       System.out.println();     

       invitados.set(ult_invitado-1, invitado);
       System.out.println(invitados);

       //En el último momento, se añade el personaje Z (darle nombre) al puesto vacante (puesto 3).
       System.out.printf("Nuevo invitado Z para la vacante 3\n");
       invitado = tcl.nextLine(); 
       System.out.println();

       invitados.add(3, invitado);  
       System.out.println(invitados);
       
    }

    /*
     * Hay algo que no he explicado pero que puedo poner como ejercicio aparte extra a ver si lo solucionais: 
     * hacer dos arraylist de strings, juntarlos en un arraylist de arraylists, y a partir de aqui: 
       cómo lees el segundo elemento del segundo arraylist para mostrarlo? 
       Y segundo, cómo modificas el valor del tercer elemento del primer arraylist?
     */
    public static void extra(Scanner tcl){
       ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("boligrafo","libreta", "Clip","estuche","mochila"));
       System.out.println("arr1: "+ arr1);

       ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Mates","Literatura", "Medio","Tecnologia","Inglés","Dibujo", "Catalán", "Física"));
       System.out.println("arr2: "+ arr2);

       ArrayList<ArrayList<String>> arrTodo = new ArrayList<>();
       arrTodo.add(arr1);
       arrTodo.add(arr2);

       System.out.println("arrTodo: "+ arrTodo);

       //cómo lees el segundo elemento del segundo arraylist para mostrarlo? 
       System.out.println("Leer el segundo elemento de la segunda ArrayList: " + arrTodo.get(1).get(1));

    }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        //ejercicio1(teclado);
        //ejercicio2(teclado);
        //ejercicio3(teclado);
        extra(teclado);

        teclado.close();

    }
}