import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        /* ARRAYS PRIMITIVOS O FIJOS */

        /* C.R.U.D : Create, Red, Update, Delete */
        //CREATE **********************************
        //1- Pasarle directamente los valores:
        int[] enteros = {54,68,32,47,99};

        //2- Crearlo con el length y después pasarle los valores
        String[] animales = new String[5];
        animales[0] = "jirafa";
        animales[1] = "elefante";
        animales[2] = "perro";
        animales[3] = "tortuga";
        animales[4] = "pelicano";

        //READ ************************************
        System.out.println(enteros[2]); //muestra el indice 2
        System.out.println(animales[1]); //muestra el indice 1
        System.out.println(enteros); //muestra solo la dirección de memoria
        System.out.println(animales); //muestra solo la dirección de memoria
        //bucle for para pasar por todos:
        for(int i = 0; i<enteros.length; i++){
            System.out.print(enteros[i] + " . ");
        }
        System.out.println("");

        //bucle for-each de Java para ver todos los animales:
        for (String animal : animales) {
            System.out.print(animal + " - ");
        }
        System.out.println("");
        System.out.println("");

        // usando un toString()
        //System.out.println(animales.toString()); //direccion de memoria
        System.out.println(Arrays.toString(animales)); //

        //UPDATE **********************************
        animales[3] = "León";
        System.out.println(Arrays.toString(animales));

        //DELETE **********************************
        animales[3] = null;
        System.out.println(Arrays.toString(animales));

        for (String animal : animales) {
            if(animal != null)
              System.out.print(animal + " - ");
        }
        System.out.println("");
        System.out.println("");

        animales = null; //anula todo el array
        System.out.println(Arrays.toString(animales));

        //*** ARRAYS MULTIDIMENSIONALES ***
        int[][] matriz = {{45, 68, 47, 87, 12, 3}, {74, 46, 19, 82, 13}};
        //imprimir el numero 3:
        System.out.println(matriz[0][5]); //funciona para un valor de dentro => 3
        System.out.println(Arrays.toString(matriz[0])); //funciona para valor de fuera => {45, 68, 47, 87, 12, 3}

        // COPIAR UN ARRAY: te copia la dirección de memoria y te sobreescribe el otro
        // String[] animales2 = animales; estás clonando solamente
        // usar metodo copyOf de Arrays:
        String[] animales2 = Arrays.copyOf(animales, animales.length);  // esto OK


    }
}
