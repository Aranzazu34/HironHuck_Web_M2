
/*
 * 2- DEBUGGAR UN CALCULO

Tienes un array o arraylist de 20 ciudades.

Se seleccionan aleatoriamente 3 de ellas y se imprimen (se pueden repetir).

Visualiza las variables en el debugger. ¿Qué ocurre con el índice del bucle? y con el número random?

+EXTRA:

Prueba a crear un método que haga el random y lo retorna al main, y sigue con el debugger el flujo del programa cuando salta desde el main() 
hasta el método y  vuelve
 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //se crea lista con 20 ciudades
        ArrayList<String> listaCiudades = new ArrayList<String>();

        listaCiudades.add("Sevilla");
        listaCiudades.add("Zaragoza");
        listaCiudades.add("Barcelona");
        listaCiudades.add("Tarragona"); 
        listaCiudades.add("Almería");

        listaCiudades.add("Burgos");
        listaCiudades.add("Salamanca");
        listaCiudades.add("Toledo");
        listaCiudades.add("Cuenca");
        listaCiudades.add("Caceres");

        listaCiudades.add("Santander");
        listaCiudades.add("Oviedo");  
        listaCiudades.add("Bilbao");
        listaCiudades.add("San Sebastian");
        listaCiudades.add("Huesca");

        listaCiudades.add("Madrid");  
        listaCiudades.add("Logroño");
        listaCiudades.add("Teruel");
        listaCiudades.add("Granada");
        listaCiudades.add("Soria");    
        
        /***************************
        int numCiudades = listaCiudades.size();

        System.out.println(listaCiudades);
        System.out.println("Numero Ciudades: "+numCiudades);
        System.out.println();

        System.out.println("======RANDOM 3 CIUDADES (SE PUEDEN REPETIR)===========");
        int numRamdon = 3; //para controlar 3 ciudades
        int i = 1;

        while ( i<= numRamdon){ //mientras no se tengan 3 ciudades aleatorias, se continuará aplicando el Random de Ciudades

                //Obtener un numero random para obtener la posición de la ciudad en el ArrayList
                int posRandom = (int) (Math.random() * numCiudades);
                System.out.println("La ciudad nº "+ i + ", es: "+ listaCiudades.get(posRandom));
                System.out.println();

                i += 1;
        }  
        ***************************/
        
        //random de Ciudades, en método
        randomCiudades(listaCiudades);

    }

    public static void randomCiudades(ArrayList<String> lista){
        int numCiudades = lista.size();

        System.out.println(lista);
        System.out.println("Numero Ciudades: "+numCiudades);
        System.out.println();

        System.out.println("======RANDOM 3 CIUDADES (SE PUEDEN REPETIR)===========");
        int numRamdon = 3; //para controlar 3 ciudades
        int i = 1;

        while ( i<= numRamdon){ //mientras no se tengan 3 ciudades aleatorias, se continuará aplicando el Random de Ciudades

                //Obtener un numero random para obtener la posición de la ciudad en el ArrayList
                int posRandom = (int) (Math.random() * numCiudades);
                System.out.println("La ciudad nº "+ i + ", es: "+ lista.get(posRandom));
                System.out.println();

                i += 1;
        } 

    }
}
