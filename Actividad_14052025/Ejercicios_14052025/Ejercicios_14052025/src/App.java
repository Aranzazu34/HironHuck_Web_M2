import java.util.Scanner;

public class App {
    
    /*
     * 1- SWITCH:
       
       Preguntas estación del año. Mediante un switch, respondes una cosa u otra. Ejemplo "primavera". Respuesta: "la primavera me alteraaa".
     */
    public static void ejercicio1(Scanner tcl){
        System.out.println("Selecciona una estación del año:\n\na. Invierno\nb. Primavera\nc. Verano\nd. Otoño\n\n");
        String opcion = tcl.nextLine(); //una letra de las opciones

        switch (opcion) {
            case "a":
                System.out.println("Saldrá la marmota el 05/02!.");
                break;
            case "b":
                System.out.println("En primavera tiempo de flora.");
                break;
            case "c":
                System.out.println("A partir de San Luis!.");
                break;
            case "d":
                System.out.println("Tiempo de recoger castañas.");
                break;                                        
            default:
                System.out.println("Salimos.");
        }

    }

    /*2- WHILE:

    Una asociación benéfica te envía a pedir caridad. Preguntas "una ayudita?", y si te dicen que sí, preguntas cuánto quieren poner. 
    Si te dicen que no, te deprimes y te vas para tu casa.

    Al final, tienes que decir cuánta gente te ha ayudado y cuánto dinero has recaudado.
    */
    public static void ejercicio2(Scanner tcl){
        int personas=0;
        int recaudacion=0;

        System.out.println("Una ayudita? (si/no)");
        String opcion = tcl.nextLine(); 

        boolean salir=false;
        boolean recaudar=true;

        while (!salir) {
            
            switch (opcion ) {
                case "si":
                    System.out.println("Cantidad a aportar?");
                    recaudacion += tcl.nextInt(); 
                    tcl.nextLine();
                    System.out.println("\n");

                    personas +=1;
                    //recaudar = true;
                    break;
                case "no":
                    recaudar = false;
                default:
                    break;
            }

            //System.out.println("\n");
            
            if (!recaudar) {
                salir = true;
            }else{
                System.out.println("Una ayudita? (si/no)");
                opcion = tcl.nextLine(); 
            } 
        }

        if(personas == 0){
            System.out.println("No ha participado en la recaudación nadie!");
        }else
            System.out.println("Han participado en la recaudación "+ personas + " personas, y conseguido una recaudación de "+recaudacion + " euros.");
    }

    /*
     * 3- SWITCH  - WHILE:

        El archivo sonoro!

        Usando una variable byte, preguntas cuál de los sonidos quieres escuchar. Cuando eligen un número, aparece la onomatopeya de ese sonido. 
        Luego le preguntas: quieres escuchar otro? Y sigue hasta que diga no.

        Ejemplo: elige 1- cohete, y suena ziuuum!, elige 3- moto, y suena brrrmmm!

        Puedes probar la opción do...while para asegurar de que pregunta al menos una vez
     * 
     */
    public static void ejercicio3(Scanner tcl){  
        boolean salir=false;
        byte    opcion=-1; //bucle do...while, no hace falta inicializar opcion
        String  otraPregunta;
        boolean seguir=true;

        do{
            
                System.out.println("Elige el sonido a escuchar:\n1- Cohete\n2- Agua\n3- moto\n4- pajaros\n0- salir");
                opcion = tcl.nextByte();
                tcl.nextLine();          
       

                switch (opcion) {
                    case 1:
                        System.out.println("Suena ziuuum!\n");
                        break;
                    case 2:
                        System.out.println("Suena como poic, ploc, plic, glu...!\n");
                        break;
                    case 3:
                        System.out.println("Suena brrrmmm!\n");
                        break; 
                    case 4:
                            System.out.println("Suena pío!\n");
                            break; 
                    case 0:
                            salir = true;
                            seguir = false;
                            break;                                                                           
                    default:
                        System.out.println("Numero del 0 al 4\n");
                        // no se pone para que prosiga 
                        seguir = false;
                        break;
                }
            
System.out.println(seguir);
                while (seguir) {
                    System.out.println("quieres escuchar otro sonido? (s/n)\n");
                    otraPregunta = tcl.nextLine();                

                    switch (otraPregunta) {
                        case "n":
                        case "N":
                            salir = true;
                            seguir = false;
                            break; 
                        case "s":
                        case "S":
                            seguir = false;
                            break;
                        default:
                            break;
                    }

                }

                seguir = true;
        }while (!salir);

    }

    public static void extra(Scanner tcl){
        int i = 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        //ejercicio1(teclado);
        //ejercicio2(teclado);
        ejercicio3(teclado);
        //extra();

        teclado.close();

    }
}
