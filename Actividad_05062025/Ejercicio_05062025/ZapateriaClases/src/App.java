import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /*
     * EJERCICIO TIENDA ZAPATERIA (segunda parte)


Vamos a probar a usar la herencia para evitar repetir código y unir las clases de zapatos.:


Crear una clase madre de las clases casual, elegante y deportes. Y ver cómo se usa en el main.

Cómo creas un arraylist con todas las clases hijas para poder recorrer sus propiedades?

Cómo sumarías todos los precios de todos los zapatos?


+EXTRA: que alguna clase (o más de una) tenga algún atributo extra (o más de uno). Ejemplo: la
categoría Elegante -> boolean tieneHebilla; En ese caso, no olvidar modificar el toString() y añadir
los métodos pertinentes (getters y setters).
     */
    public static ArrayList<Zapato> zapateria = new ArrayList<Zapato>();

    public static void main(String[] args) throws Exception {
        Scanner  tcl = new Scanner(System.in);
        double  sum_precios = 0.0;  //sumar todos los precios de los zapatos

        // limpia pantalla2        
        System.out.print("\033[H\033[2J");
        System.out.flush();  


        //introducir Zapatos
        Zapato zp = new Zapato();
        zp.introducirZapato(zapateria,tcl);
        
        System.out.println();
        System.out.println();

        //System.out.println(zapateria.toString());
        System.out.println();
        System.out.println("Mostrar la lista de zapatos:\n");
        for (Zapato  shoe : zapateria) {
            System.out.println(shoe.toString());            
        }        

        //mostrar modelo y precio de los zapatos
        System.out.println();
        System.out.println("Mostrar modelos y precios de la lista de zapatos:\n");
        for (Zapato  shoe : zapateria) {
            System.out.println(shoe.getModelo() + " " + shoe.getPrecio()); 
            sum_precios += shoe.getPrecio();           
        }


        System.out.println("\nLa suma total de Precios de los zapatos de la lista es: " + sum_precios);

        //ArrayList<Mascota> granja = new ArrayList<>();
        //granja.add(p1);        


        tcl.close();
        
    }
}
