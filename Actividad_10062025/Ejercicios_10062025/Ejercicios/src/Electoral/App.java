package Electoral;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 3- (difícil) BARRAS RESULTADOS ELECTORALES

Son las elecciones! Se van a mostrar gráficamente los resultados de cada partido.

Crea una clase Partido con los datos: nombre y porcentaje. Instancia al menos 5 partidos.

Pedir el porcentaje de votos recibido para cada uno de los partidos. Impide que se escriba un tipo diferente mediante hasNext() (ej: si se pide un 
entero, usar teclado.hasNextInt() )

Cuando estén introducidos todos los resultados, crear un método que muestre barras de resultado para cada uno de los participantes. Puedes escoger 
cualquier carácter alfanumérico habitual, como *, o #.

Cuando acabe que pregunte: ¿Actualizar resultados (S/N)? (*) Si dice que sí, limpia el terminal y vuelve a preguntar los resultados. Si dice que 
no, limpia el terminal y escribe “hasta la próxima!” y se acaba el programa. Debe existir una clase Metodos, que contenga los métodos:

(*) probad a hacerlo con tipo char. Para recordar cómo pides el char por scanner, y cómo lo comparas con si o no (s/n) (mayúsculas y minúsculas)

- mostrarResultado()

- limpiarPantalla() borra la consola,

- aprietaEnter(). le dice “para seguir, aprieta enter”.

Son en total tres clases: principal, Partido y Metodos.

+EXTRA se pueden añadir controles del tipo: suma la cantidad más del 100% ?
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);
        boolean repetir=true;

        ArrayList<Partido> partidos = new ArrayList<>();

        Metodos.limpiarPantalla();

        
        while (repetir) {
            Metodos.introducirPartido(tcl, partidos);
            //Metodos.aprietaEnter(tcl);

            Metodos.mostrarResultado(partidos);
            repetir = Metodos.accion(tcl, partidos);

            //System.out.println(repetir);

            if( repetir){
                //vaciamos para volver a empezar
                /*for (int i = 0; i < partidos.size(); i++) {
                    partidos.remove(i);        
                }
                */

                partidos.clear();

                if( partidos.isEmpty()){
                    repetir = true;            
                }else{
                    System.out.println("No se ha reiniciado la lista de partidos");
                }

                
            }
            
        }

        tcl.close();
    }
}
