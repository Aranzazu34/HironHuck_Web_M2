import java.util.ArrayList;
import java.util.Scanner;

public class App {
    /*
     * Instructions

        Tienes una colección de bicicletas y vas registrando los últimos modelos que compraste en WallaPop.


        - Debes crear una clase Bicicleta con características como: Marca, Modelo, Velocidad Máxima, Si
        tiene marchas o no … (estas características puedes cambiarlas según tu gusto)


        - Puedes añadir métodos: tocar el claxon, pedalear, parar, girar, cambiar marchas, … H


        - Recordar que debe haber también un método constructor y un toString() H


        - Primero probar instanciar una o dos bicicletas sueltas H


        - Luego, probar a crear un arraylist  de bicicletas H


        - Y recorrer ese arraylist  para mostrarlo con bucle for y/o for-each H


        - También se puede mostrar una sola propiedad (o varias) de las bicicletas. Ej: mostrar solo marca y
        velocidad máxima de todas las bicicletas. H


        - Tema booleanos, probad a ponerlo como texto. Ej: “sí incluye cambio de marchas” (modificar el toString() )  H

        - Probar métodos set desde el main()

        +EXTRA: crear o cambiar o leer desde el scanner de usuario (con o sin bucle)
     */
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        //instanciamos un par de bicicletas
        Bicicleta b1 = new Bicicleta();
        Bicicleta b2 = new Bicicleta("Orbea", "Fénix v.1", 80, true, 26);

        System.out.println(b1);
        System.out.println();
        System.out.println(b2);

        //cumplimentar por teclado la bicicleta b1
        System.out.println("Marca:");
        String marca = tcl.nextLine();

        System.out.println("Modelo:");
        String modelo = tcl.nextLine();

        System.out.println("Velocidad Máx.:");
        int velo_max = tcl.nextInt();
        tcl.nextLine();

        System.out.println("Tiene marchas (false/true):");
        boolean tieneMarchas = tcl.nextBoolean();
        tcl.nextLine();

        System.out.println("Pulgadas Ruedas:");
        int pulgadas = tcl.nextInt();
        tcl.nextLine();

        //se actualizan los datos de la bicicleta 1
        b1.setMarca(marca);
        b1.setModelo(modelo);
        b1.setVelo_max(velo_max);
        b1.setMarchas(tieneMarchas);
        b1.setPulgadas_ruedas(pulgadas);

        //ArrayList de bicicletas
        ArrayList<Bicicleta> listaBicis = new ArrayList<>();

        listaBicis.add(b1);
        listaBicis.add(b2);

        //Recorrer la ArrayList

        //1. bucle for normal
        
        System.out.println("+++++++++++1. bucle for normal++++++++++++++++++++++++");
        for(int i=0; i<listaBicis.size();i++){
            System.out.println( ( i+1 ) + ": La bicicleta de la marca " + listaBicis.get(i).getMarca() + 
                               " tiene una velocidad máxima de " + listaBicis.get(i).getVelo_max() );
        }

        System.out.println();

        System.out.println("+++++++++++2. bucle for-each (elementos)++++++++++++++++++++++++");
        //2. bucle for-each (elementos)
        for (Bicicleta bicicleta : listaBicis) {
            System.out.println( "La bicicleta de la marca " + bicicleta.getMarca() + 
                               " tiene una velocidad máxima de " + bicicleta.getVelo_max() );
        }

        System.out.println("+++++++++++ToString mensaje marchas++++++++++++++++++++++++");
        System.out.println(b1.toString());
        System.out.println(b2.toString());

        System.out.println("+++++++++++Modificar++++++++++++++++++++++++");
        for (Bicicleta bicicleta : listaBicis) {
            System.out.println("Cambiar pulgadas de la bicicleta " + bicicleta.getMarca() + " " + bicicleta.getModelo() + 
                               " con ruedas de " + bicicleta.getPulgadas_ruedas() + " pulgadas:");
            pulgadas = tcl.nextInt();
            tcl.nextLine();

            bicicleta.setPulgadas_ruedas(pulgadas);
            System.out.println("Las pulgadas han cambiado a " + bicicleta.getPulgadas_ruedas());
            System.out.println("========");
        }

        tcl.close();
    }
}

/*Specialized.Trek.Scott.Canyon.Giant.Orbea.Cannondale.Pinarello. */