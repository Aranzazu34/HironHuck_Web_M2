import java.util.ArrayList;
import java.util.Scanner;

/**

Tienes un programa principal de gestión inmobiliaria, que gestiona tres tipos de inmuebles:

Características en común: superficie, precio, ubicación. Opcional: se puede añadir tipo: casa, piso, trastero
como un campo más en vez de buscar la clase.

Características personalizadas:

- Casa => es adosada?
- Piso => en que planta está? Tiene ascensor?
- Trastero => tiene seguridad?

Crear una clase abstracta Edificio, o Inmueble, u otro nombre, de la cual hereden el resto.


- Instanciar al menos dos de cada tipo (casa, piso , trastero).


- Dos tipos de consulta: una que muestre solo tipo y ubicación: ‘casa en Santa Coloma’


- Y otra que muestre todas las características. Mostrar casas


• Probar constructor vacío y luego llenarlo en el main


• Probar sobrecarga de métodos (método solo con tipo y ubicación) por parámetro y que modifique ambos datos!!!


• Verificar qué ocurre con los toString() en cada caso. No vale decir: ascensor=true. Tiene que ser
frase completa: ‘Es una casa de 100m2 en Sta. Coloma que vale 400.000E y está adosada’

• Probar a crear un atributo final en una de las clases hijas.


+EXTRA: añadir datos por entrada de teclado

+EXTRA: probar a hacer un diagrama UML para plantear las clases

**/


public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Inmueble> inmuebles = new ArrayList<>();

        Scanner tcl = new Scanner(System.in);

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();            

        //Instanciar al menos dos de cada tipo (casa, piso , trastero).

        int opcion;

        float   superficie=0;
        double  precio=0;
        String  ubicacion="";
        String  tipo="";

        boolean adosada=false;

        int planta=0;
        boolean ascensor=false;

        boolean seguridad=false;

        do{

            System.out.println();
            System.out.println("Añadir inmuebles:");
            System.out.println("1 - Casa");
            System.out.println("2 - Piso");
            System.out.println("3 - Trastero");
            System.out.println("0 - Salir");
            opcion = tcl.nextInt();
            tcl.nextLine();

            System.out.println();   

            //datos comunes del inmueble
            if ( opcion > 0 && opcion <= 3){
                System.out.println("Superfície:");
                superficie = tcl.nextFloat();
                tcl.nextLine();

                System.out.println("Precio:");
                precio = tcl.nextFloat();                    
                tcl.nextLine();

                System.out.println("Ubicacion:");
                ubicacion = tcl.nextLine();
                    
                System.out.println("Tipo:");
                tipo = tcl.nextLine();
            }
                            
            switch (opcion) {
                case 1:
                    System.out.println("Adosada (true/false):");
                    adosada = tcl.nextBoolean();
                
                    Casa casa = new Casa();

                    casa.setSuperficie(superficie);
                    casa.setPrecio(precio);
                    casa.setUbicacion(ubicacion);
                    casa.setTipo(tipo);

                    casa.setAdosada(adosada);

                    inmuebles.add(casa);
                    
                    break;
                case 2:
                    System.out.println("Nº Planta:");
                    planta = tcl.nextInt();
                    tcl.nextLine();

                    System.out.println("Ascensor (true/false):");
                    ascensor = tcl.nextBoolean();

                
                    Piso piso = new Piso();

                    piso.setSuperficie(superficie);
                    piso.setPrecio(precio);
                    piso.setUbicacion(ubicacion);
                    piso.setTipo(tipo);   
                    
                    piso.setPlanta(planta);
                    piso.setAscensor(ascensor);

                    inmuebles.add(piso);
                    
                    break;
                case 3:
                    System.out.println("Seguridad (true/false):");
                    seguridad = tcl.nextBoolean();
                
                    Trastero trastero = new Trastero();

                    trastero.setSuperficie(superficie);
                    trastero.setPrecio(precio);
                    trastero.setUbicacion(ubicacion);
                    trastero.setTipo(tipo); 
                    
                    trastero.setSeguridad(seguridad);

                    inmuebles.add(trastero);

                    break;  
                case 0:
                    System.out.println("Salir de introducir inmuebles.");
                    break;            
                default:
                    System.out.println("La opción es incorrecta.");
            }        

        }while (opcion != 0);

        System.out.println("================================");
        System.out.println();
        
        System.out.println("Mostrar Caracteristicas de los Inmuebles:");
        System.out.println("================================");

        // Iterar sobre el ArrayList y llamar a los métodos de las clases hijas
        for (Inmueble inmueble : inmuebles) {
            // Usar instanceof para verificar el tipo de objeto
            if (inmueble instanceof Casa) {
                Casa ca = (Casa) inmueble; // Casting
                ca.mostrarCaracteristicas();
                
                System.out.println();
                ca.inmuebleTipoUbicacion();
                System.out.println();

                System.out.println("===Modificar dato de ubicacion (modificarDatos CASA)");
                System.out.println();
                ca.modificarDatos(tcl);

                System.out.println();                
                System.out.println(ca.toString());                
                System.out.println("================================");
            }else if (inmueble instanceof Piso) {
                Piso pi = (Piso) inmueble; // Casting
                pi.mostrarCaracteristicas();
                
                System.out.println();
                pi.inmuebleTipoUbicacion();
                System.out.println();
                
                System.out.println("===Modificar dato de ubicacion (modificarDatos PISO)");
                System.out.println("Ubicacion:");
                ubicacion = tcl.nextLine();
                System.out.println();

                pi.modificarDatos(ubicacion);
                
                System.out.println();
                System.out.println(pi.toString());   
                System.out.println("================================");       
            }else if (inmueble instanceof Trastero) {
                Trastero tr = (Trastero) inmueble; // Casting
                tr.mostrarCaracteristicas();
                
                System.out.println();
                tr.inmuebleTipoUbicacion();
                System.out.println();

                System.out.println("===Modificar dato de ubicacion (modificarDatos TRASTERO)");
                System.out.println("Tipo:");
                tipo = tcl.nextLine();
                System.out.println();   

                System.out.println("Ubicacion:");
                ubicacion = tcl.nextLine();
                System.out.println();

                tr.modificarDatos(tipo, ubicacion);

                System.out.println();
                System.out.println(tr.toString());
                System.out.println("================================"); 
            }

            
        }

        System.out.println();


        tcl.close();

    }

}
