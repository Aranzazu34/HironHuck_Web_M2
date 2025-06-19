package DiosesOlimpo;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    public static void limpiarPantalla(){        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }     


    public static void introducirDioses(Scanner tcl, ArrayList<DiosesDelOlimpo> dolimpo, ArrayList<DiosesModernos>  dModernos){

        int opcion;
        boolean salir=false;

        String  nombre_dios;
        int     edad_dios;
        int     gfuerza_dios;

        String  poder;
        boolean relacion_humanos; 
        String  medio_natural; 
        String  salir2;
        

        do{

            System.out.println("\nIntroducir Dios tipo:\n");
            System.out.println("1 - Olimpo\n");
            System.out.println("2 - Moderno\n");
            opcion = tcl.nextInt();
            tcl.nextLine();    
            
            //System.out.println("opcion " + opcion);

            if (  !(opcion >= 1 && opcion <= 2) ){
                System.out.println("Opcion incorrecta.");
            }else{
                //datos comunes
                System.out.println("\nNombre:");
                nombre_dios = tcl.nextLine();
                
                System.out.println("\nEdad:");            
                edad_dios = tcl.nextInt();
                tcl.nextLine();

                System.out.println("\nGrado Fuerza:");
                gfuerza_dios = tcl.nextInt();
                tcl.nextLine();
        
                //datos específicos
                switch (opcion) {
                    case 1:    //Dios del Olimpo
                        System.out.println("\nPoder:");
                        poder = tcl.nextLine();

                        System.out.println("\nSe relaciona con humanos? (false/true)");
                        relacion_humanos = tcl.nextBoolean();
                        tcl.nextLine();

                        //se crea el objeto del tipo para añadirlo en su lista de Dioses del Olimpo
                        DiosesDelOlimpo d1 = new DiosesDelOlimpo(poder, relacion_humanos, nombre_dios, edad_dios, gfuerza_dios);
                        dolimpo.add(d1);

                        break;

                    case 2:    //Dios Moderno
                        System.out.println("\nMedio Natural: (Agua/Fuego/Tierra/Viento/Eletricidad)");
                        medio_natural = tcl.nextLine();  
                        
                        //se crea el objeto del tipo para añadirlo en su lista de Dioses del Olimpo
                        DiosesModernos d2 = new DiosesModernos(medio_natural, nombre_dios, edad_dios, gfuerza_dios);
                        dModernos.add(d2);                    
                
                        break;
                
                    default: 
                        System.out.println("\nOpcion incorrecta.");
                }
            }


            System.out.println("\nDesea dejar de introducir Dioses? (false/true)\n");
            salir2 = tcl.nextLine();

            if (salir2.equalsIgnoreCase("true")) {
                salir = true;
            } else if (salir2.equalsIgnoreCase("false")) {
                salir = false;
            } else {
                System.out.println("Valor incorrecto.");
                salir = false;
            }   

        }while(!salir);  

    }


    public static void mostrarDiosesOlimpo(ArrayList<DiosesDelOlimpo> lista){

        System.out.println("\nLista de Dioses del Olimpo:");
        System.out.println();

        for (DiosesDelOlimpo diosesDelOlimpo : lista) {

            System.out.println(diosesDelOlimpo.toString());
            
        }

    }

    public static void mostrarDiosesModernos(ArrayList<DiosesModernos> lista){

        System.out.println("\nLista de Dioses Modernos:");
        System.out.println();

        for (DiosesModernos diosesModernos : lista) {

            System.out.println(diosesModernos.toString());
            
        }

    }    

    //Se comparan los grados de fuerza de ambos personajes. Se imprimen los nombres de ambos, el ganador y la diferencia de puntos. 
    //Del tipo: “Poseidón gana a Belen Esteban por 367 puntos”.    
    public static void compararFuerzaDioses(Scanner tcl, ArrayList<DiosesDelOlimpo> dolimpo, ArrayList<DiosesModernos>  dModernos){
        System.out.println("\n==========COMPARAR FUERZA DIOSES=======================================");
        System.out.println("\nNombres de Dioses del Olimpo:");
        
        for (DiosesDelOlimpo dios : dolimpo) {
            System.out.println(dios.getNombre());            
        }

        boolean salir= false;
        String nombre_Olimpo;

        do{
            System.out.println("\nIntroducir nombre de un Dios del Olimpo:");
            nombre_Olimpo = tcl.nextLine();
            System.out.println();   

            for (DiosesDelOlimpo dios : dolimpo) {
                if( dios.getNombre().equalsIgnoreCase(nombre_Olimpo)){
                    salir = true;
                }
            }    

        }while(!salir);
        

        System.out.println("\nNombres de Dioses Modernos:");
        
        for (DiosesModernos dios : dModernos) {
            System.out.println(dios.getNombre());            
        } 

        salir= false;
        String nombre_Moderno;

        do{
            System.out.println("\nIntroducir nombre de un Dios Moderno:");
            nombre_Moderno = tcl.nextLine();
            System.out.println();   

            for (DiosesModernos dios : dModernos) {
                if( dios.getNombre().equalsIgnoreCase(nombre_Moderno)){
                    salir = true;
                }
            }    

        }while(!salir);        


        //encontrar la fuerza de cada tipo de Dios
        int gfuerza_olimpo=0;
        int gfuerza_moderno=0;

        //fuerza del Dios del Olimpo
        for (DiosesDelOlimpo dios : dolimpo) {
            if ( dios.getNombre().equalsIgnoreCase(nombre_Olimpo)){
                gfuerza_olimpo = dios.getGrado_fuerza();
            }                     
        }

        //fuerza del Dios Moderno
        for (DiosesModernos dios : dModernos) {
            if ( dios.getNombre().equalsIgnoreCase(nombre_Moderno)){
                gfuerza_moderno = dios.getGrado_fuerza();
            }           
        }    
        
        int diferencia=0;

        if ( gfuerza_olimpo == gfuerza_moderno){
            System.out.println(nombre_Moderno + " y " + nombre_Olimpo + ", tienen la misma fuerza de " + gfuerza_olimpo + " puntos.");
        }else{
            if ( Math.max(gfuerza_olimpo, gfuerza_moderno) == gfuerza_olimpo ){
                diferencia = gfuerza_olimpo - gfuerza_moderno;
                System.out.println(nombre_Olimpo + " gana a " + nombre_Moderno + ", por " + diferencia + " puntos.");
            }else if (  Math.max(gfuerza_olimpo, gfuerza_moderno) == gfuerza_moderno ){
                diferencia = gfuerza_moderno - gfuerza_olimpo;
                System.out.println(nombre_Moderno + " gana a " + nombre_Olimpo + ", por " + diferencia + " puntos.");            
            }     
        }


    }


}
