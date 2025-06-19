package LamparaAladino;

import java.util.ArrayList;
import java.util.Scanner;

/*
 Has encontrado una lámpara de Aladino y le vas pidiendo deseos. Estos se van 
guardando en una lista. Cuando dejas de pedir deseos, se hace un random y se 
escoge solo uno de ellos. Se muestra una frase del tipo: “has pedido 7 deseos, y 
se te ha concedido: vacaciones en Hawaii”.
 */

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        ArrayList<String> deseos = new ArrayList<>();

        Metodos.limpiarPantalla();

        Metodos.introducirDeseos(tcl, deseos);
        Metodos.obtenerDeseo(deseos);

        tcl.close();
    }
}
