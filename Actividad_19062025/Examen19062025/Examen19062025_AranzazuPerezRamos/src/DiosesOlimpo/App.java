package DiosesOlimpo;

import java.util.ArrayList;
import java.util.Scanner;

/*
Tienes una clase madre Dioses y dos clases hijas (DiosesDelOlimpo y DiosesModernos).

Los dioses modernos pueden incluir cualquier personaje de la farándula que salga en la TV o en Tik Tok o en otros medios.
Las dos clases hijas comparten propiedades y métodos de la clase madre: Nombre, edad y GradoFuerza, y al mismo tiempo cada clase hija posee 
al menos una propiedad particular aparte (tu imaginación al poder).
A partir de estas premisas: 
    - Debe instanciarse un dios de cada tipo, pidiendo al usuario que introduzca esos datos.
    - Se muestran todas las características de ambos dioses
    - Se comparan los grados de fuerza de ambos personajes. Se imprimen los nombres de ambos, el ganador y la diferencia de puntos. 
      Del tipo: “Poseidón gana a Belen Esteban por 367 puntos”.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        ArrayList<DiosesDelOlimpo> dolimpo = new ArrayList<>();
        ArrayList<DiosesModernos>  dModernos = new ArrayList<>();

        Metodos.limpiarPantalla();
        
        Metodos.introducirDioses( tcl, dolimpo, dModernos);

        //mostrar los Dioses existentes 
        Metodos.mostrarDiosesOlimpo(dolimpo);

        System.out.println("===============AAAA================");
        System.out.println();

        Metodos.mostrarDiosesModernos(dModernos);
        System.out.println();
        System.out.println();

        boolean salir = false;

        do{
            Metodos.compararFuerzaDioses(tcl, dolimpo, dModernos);

            System.out.println("\nDesea salir de comparar Dioses? (false/true)\n");
            salir = tcl.nextBoolean();
            tcl.nextLine();              

        }while(!salir);
        


        tcl.close();

    }
}
