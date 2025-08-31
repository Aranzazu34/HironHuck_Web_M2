import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
1- java sin POO: TRENES

Preguntas al usuario:

Cuantos Km recorridos? 536 km

Cuántas horas necesarias? 5 horas

Cuántos minutos necesarios? Y 32 minutos

Y partir de aquí, indicar la velocidad del tren en Km/h

**/


public class App {

    public static void calcularVelocidad(Scanner tcl){
        System.out.println("Calculo de la velocidad:\n");
        System.out.println(":\n");
        
        System.out.println("Km:\n");
        float nkm = tcl.nextFloat();
        tcl.nextLine();

        System.out.println("Horas:\n");
        float nhoras= tcl.nextFloat();
        tcl.nextLine();
        
        System.out.println("Minutos:\n");
        float nminutos = tcl.nextFloat();
        tcl.nextLine();

        float minutosHoras = nminutos / 60;
        System.out.println("minutosHoras: "+minutosHoras);

        float totalHoras = nhoras + minutosHoras;

        float velocidad;

        velocidad = nkm / totalHoras;
        velocidad = (float)Math.round(velocidad * 100) / 100.0f;

        System.out.println("La velocidad es: "+velocidad);
    }

//Velocidad = km/horas     


    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        
        calcularVelocidad(teclado);

        teclado.close();

    }
}