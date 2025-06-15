package Tickets;
/*
 * 2- CONTADOR DE TICKETS

Hay un concierto, y los asistentes reciben un ticket numerado, que es incremental por orden de llegada, y no puede repetirse.

Crea la clase Asistente que contenga nombre, apellido y numero de ticket.

En el main, instancia diversos asistentes y verifica que el numero de ticket es autoincremental
 */

public class App {
    public static void main(String[] args) throws Exception {
        Asistente a1 = new Asistente("Pablo", "de Noguera", null);
        System.out.println(a1.toString());  

        Asistente a2 = new Asistente("Nuria", "Curto", null);
        System.out.println(a2.toString());

        Asistente a3 = new Asistente("Me", "Too", null);
        System.out.println(a3.toString());

    }
    
}
