package Camiones;

public class App {
/*
 * 1- CAMIONES (entrenamiento opcional)

Tenemos una flota de camiones y creamos una variable estática (numRuedas, se entiende que todos tienen el mismo número de ruedas) y dos métodos 
estáticos:
acelerar() y frenar(), que también son igual para todos los camiones. El resto de atributos y métodos, son no-estáticos.


Desde el main, crear 3 camiones e imprimir su estado. Cómo muestras el número de ruedas?

Llamar a los métodos estáticos y mostrar “acelerando” o “frenando”.
 */
    public static void main(String[] args) throws Exception {
        
        Camion c1 = new Camion("Scania", "BRW 4093 JK", true);
        Camion c2 = new Camion("Volvo", "TGQ 2503 PQ", false);
        Camion c3 = new Camion("Iveco", "BME 6518 AO", true);

        

        System.out.println("Estado camiones");
        System.out.println("===========================");
        System.out.println("El " + c1.getMarca() + " se encuentra en " + 
                           (c1.isBuen_estado() ? "buen estado." : "mal estado." ) + " Y su numero de ruedas es: " + Camion.getRuedas() );
        System.out.println("El " + c2.getMarca() + " se encuentra en " + 
                           (c2.isBuen_estado() ? "buen estado." : "mal estado." ) + " Y su numero de ruedas es: " + Camion.getRuedas() );
        System.out.println("El " + c3.getMarca() + " se encuentra en " + 
                           (c3.isBuen_estado() ? "buen estado." : "mal estado." ) + " Y su numero de ruedas es: " + Camion.getRuedas() );

        
        System.out.println();
        Camion.acelerar(c1);
        
        System.out.println();
        Camion.frenar(c2);
        
        System.out.println();
        Camion.acelerar(c3);



    }
}
