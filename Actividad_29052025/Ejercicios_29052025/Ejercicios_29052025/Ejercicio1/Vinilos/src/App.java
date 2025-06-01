import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /*
     * 1- DISCOS DE VINILO

Crear un arraylist con al menos 5 discos, con los datos: Artista, título, año, duración (pueden ser otros).


- Mostrar todos los discos, con todos los datos. Que esto sea un método externo al main


- Mostrar uno determinado: por ejemplo el año del tercer disco (esto lo podría pedir el cliente, o no)


- Cambiar ese mismo año (esto lo podría pedir el cliente, o no) y mostrar ese cambio.


- Etc hacer pruebas


EXTRA: método buscador con contains() o con equals(). Que el usuario escriba nombre de artista y me diga si está, y en qué posición está.


+EXTRA:
Que todos estos datos los entre el cliente: usuario entra Artista, título, año y duración (no hace falta hacer un CRUD entero).
     */

    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        ArrayList<Vinilo> listVinilos = new ArrayList<>();
        int  numVinilos = 5;
        

        introListaVinilos(listVinilos, tcl, numVinilos);
        mostrarListaVinilos(listVinilos);

        System.out.println("=================CONSULTAS=======================");

        String salir="n";

        do{

            mostrarDatoVinilo(listVinilos, tcl);
            System.out.println();
            tcl.nextLine();

            System.out.println("Quiere consultar otros datos?(s/n)");
            salir = tcl.nextLine().toLowerCase();
            System.out.println();
                
            //es lo contrario a la condición del bucle!!!
            switch (salir) {
                case "s":
                    salir = "n";
                    break;
                case "n":
                    salir = "s";
                    break;                
                default:
                    break;
            }   
            
            System.out.println();
            mostrarListaVinilos(listVinilos);
            
            
        }while (salir.equalsIgnoreCase("n"));
        

        tcl.close();

    }

    //método para introducir inicialmente los 5 vinilos
    public static void introListaVinilos(ArrayList<Vinilo> lista, Scanner tcl, int numVinilos){
        System.out.println("-------------Introducir los vinilos (hasta 5)");

        int i=0;
        boolean salir = true;
        String aux;
        
        while (i<5 && salir) {

            //creamos el objeto del álbum
            Vinilo vinilo = new Vinilo();

            //método en la clase para añadir la información del vinilo
            vinilo.introVinilo(tcl, (i+1));

            //agregar vinilo a la lista
            lista.add(vinilo);

            i += 1;

            if (i != 5){
                System.out.println("Quiere introducir otro vinilo? (s/n)");
                aux = tcl.nextLine();
            
                if(aux.equalsIgnoreCase("n")){ 
                    salir = false;
                }
            }

            
        }
    }

    public static void mostrarListaVinilos(ArrayList<Vinilo> Lista){
        System.out.println();
        System.out.println("============================");
        System.out.println("Lista de Vinilos:");
        int i = 1;
        for(Vinilo vinilo : Lista){
            System.out.println( i +". Álbum: " + vinilo.getTitulo() + " del artista " + vinilo.getArtista() + ", año " + 
                                                 vinilo.getAnyo() + " (duración de "+ vinilo.getDuracion()+")\n");
            i += 1;
        }  
    }

    public static void mostrarDatoVinilo(ArrayList<Vinilo> lista, Scanner tcl){
        System.out.println("Número de álbum a consultar un dato:\n");
        int numVinilo = tcl.nextInt();
        tcl.nextLine();

        System.out.println("Dato a consultar (1- Artista, 2- Título, 3- Año, 4- Duración y 0- No)");
        int dato = tcl.nextInt();
        tcl.nextLine();

        String salir="n";
        
        for (int i=0; i<lista.size(); i++){

            //si la posición del array, corresponde al número de Vinilo a consultar el dato
            if( i == (numVinilo-1) ){
                //llamada al método para devolver el dato que se quiere consultar del vinilo
                lista.get(i).mostrarDatoVinilo(dato, numVinilo);
                System.out.println();

                 //se pregunta al usuario si desea modificar ese dato
                System.out.println("Quiere modificar el dato consultado?(s/n)");
                salir = tcl.nextLine().toLowerCase();
                System.out.println();

                if( salir.equalsIgnoreCase("s")){
                    lista.get(i).modificarDato(dato, numVinilo, tcl);
                }
            }

        }
    }
}
