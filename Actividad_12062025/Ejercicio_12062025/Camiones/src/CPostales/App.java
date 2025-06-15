package CPostales;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 3- DIRECCION POSTAL (objeto como atributo de una clase)

Tienes dos clases, Dirección y Cliente

La clase Dirección debe tener estas propiedades: Calle, ciudad, codigo postal

La clase Cliente  debe tener estas propiedades: id, nombre, edad, dirección

En la clase principal (Main), crea un objeto de tipo Direccion y uno de tipo Persona, y muestra la información completa de la persona, 
incluyendo su dirección.

+EXTRA: que la persona pueda tener varias direcciones (arraylist de objetos)
 */

public class App {    

    public static void main(String[] args) throws Exception {

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush(); 

        Direccion d1 = new Direccion("San Marco, 24 2B", "Del Cabo", 75012);    
        Direccion d2 = new Direccion("Menorca, 15", "Benavente", 46100);   

        Cliente c1 = new Cliente(12, "Antonella", 30, new ArrayList<>(Arrays.asList(d1,d2)));

        System.out.println(c1);
        System.out.println();

        System.out.println(d1);
        System.out.println(d2);
    
    }

}
