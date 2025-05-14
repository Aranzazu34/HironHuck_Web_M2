import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        //switch es una manera de hacer un condicional en forma de lista, para casos concretos
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("dime un año de 2020 a 2025 y te diré el desastre del año\n");

        int year = teclado.nextInt();
        teclado.nextLine();

        switch (year) {
            case 2020:
                System.out.println("cierto virus en China nos chafó");
                break;

            case 2021:
                System.out.println("en vez de Odisea del Espacio");
                break;

            case 2022:
                System.out.println("Guerra y paz no, solo guerra");
                break;

            case 2023:
                System.out.println("otra crisis");
                break; 

            case 2024:
                System.out.println("DANA");
                break;  

            case 2025:
                System.out.println("Apagón!");
                break; 
        
            default:
                System.out.println("defecto");
                break;
        }

     String animal = "";

     /* 
        // opcion 1: usar COMPARACION

        System.out.println("Dime un animal. para salir, escribe 'salir'");
        animal = teclado.nextLine();
        System.out.println("interesante animal: " + animal);

        while (!animal.equalsIgnoreCase("salir")) {
            System.out.println("Dime un animal. para salir, escribe 'salir'");
            animal = teclado.nextLine();

            if (!animal.equalsIgnoreCase("salir"))
               System.out.println("interesante animal: " + animal);  
        }
*/               

        /* opcion 2: usar booleano */

        // o es TRUE o es FALSE
        boolean salir = false;

        /*
        while (!salir) {
            System.out.println("Dime un animal. para salir, escribe 'salir'");
            animal = teclado.nextLine();

            if (animal.equalsIgnoreCase("salir"))
               salir = true;
            else
               System.out.println("interesante animal: " + animal);  

        }

        */

        // byte opcion = -1;

        // while (!salir) {
        //     System.out.println("Elige una opcion:\n1-Playa\n2-Montaña\n3-Tú casa\n0-Salir\n");
        //     opcion = teclado.nextByte();

        //     switch (opcion) {
        //         case 1:
        //             System.out.println("Gran elección\n");
        //             break;
        //         case 2:
        //             System.out.println("La que elijo fijo\n");
        //             break;
        //         case 3:
        //             System.out.println("Me va a ir bien\n");
        //             break; 
        //        case 0:
        //             System.out.println("Hasta la próxima!\n");
        //             salir = true;
        //             break;                                                       
        //         default:
        //             System.out.println("Numero del 0 al 3\n");
        //             // no se pone para que prosiga break;
        //     }
        // }
        
        /*do... while te asegura que el c odigo se ejecuta al menos una vez, aunque la
         * condición no se cumpla
         */
        byte opcion; //bucle do...while, no hace falta inicializar opcion

        do{
            System.out.println("Elige una opcion:\n1-Playa\n2-Montaña\n3-Tú casa\n0-Salir\n");
            opcion = teclado.nextByte();

            switch (opcion) {
                case 1:
                    System.out.println("Gran elección\n");
                    break;
                case 2:
                    System.out.println("La que elijo fijo\n");
                    break;
                case 3:
                    System.out.println("Me va a ir bien\n");
                    break; 
               case 0:
                    System.out.println("Hasta la próxima!\n");
                    salir = true;
                    break;                                                       
                default:
                    System.out.println("Numero del 0 al 3\n");
                    // no se pone para que prosiga break;
            }
        }while (!salir);

        teclado.close();

    }
}
