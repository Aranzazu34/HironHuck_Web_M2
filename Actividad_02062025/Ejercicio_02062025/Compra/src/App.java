import java.util.ArrayList;
import java.util.Scanner;

public class App {
/*
 * Instructions
Tienes un carrito de la compra donde puedas añadir, leer, modificar, borrar y BUSCAR elementos.
Crear menú con opciones. Si opción = ‘salir’ u opción 0, se acaba el programa.

Se propone que sean objetos Comida: nombre, origen, peso, precio.

Se aconseja en este caso realizar un switch dentro de un while. El switch sobre las opciones del menú del tipo:

1- Añadir comida (implica añadir por teclado todas las características del objeto)

2- Mostrar lista completa

3- Mostrar un producto específico por nombre (implica opción buscar)

4- Modificar por nombre. ¿Cuál quieres modificar? (implica opción buscar)

5- Borrar elemento por nombre (implica opción buscar)

0- Salir

Para buscar, se aconseja el método equalsIgnoreCase().

+EXTRA: poner todos los métodos en una clase aparte

*EXTRA: calcular precio final del producto según su peso y precio/Kg

Submission
 */

    private static ArrayList<Carrito> carritos = new ArrayList<>();
    //private static int numCarrito;

    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);

        //opciones Carrito de la Compra
        //Tienes un carrito de la compra donde puedas añadir, leer, modificar, borrar y BUSCAR elementos.
        //Crear menú con opciones. Si opción = ‘salir’ u opción 0, se acaba el programa.
        int opcion;

        do{

            System.out.println();
            System.out.println("Seleccionar una opción:");
            System.out.println("1 - Añadir Comida");
            System.out.println("2 - Listar Comidas");
            System.out.println("3 - Modificar Comida");
            System.out.println("4 - Eliminar Comida");
            System.out.println("5 - Buscar Comida");
            System.out.println("0 - Salir");
            opcion = tcl.nextInt();
            tcl.nextLine();

            System.out.println();

            switch (opcion) {
                case 1: //agregar comida a carrito existente o nuevo
                    System.out.println("Nombre Comida:");
                    String nombre = tcl.nextLine();
                    System.out.println("Origen:");
                    String origen = tcl.nextLine();                    
                    System.out.println("Peso:");
                    float peso = tcl.nextFloat();
                    tcl.nextLine();
                    System.out.println("Precio/kg:");
                    double precio = tcl.nextDouble();                                        
                    tcl.nextLine();

                    Comida co = new Comida(nombre, origen, peso, precio);
                    
                    String nombreCarrito = "";
                    int numCarrito;

                    if(carritos.isEmpty()){  //si no existe ningún carrito
                        numCarrito = 0;
                        
                        System.out.println("Nombre Carrito:");
                        nombreCarrito = tcl.nextLine(); 
                    }else{                  //si hay carrito/s, seleccionar al que se quiere agregar la Comida

                        //se listan los carritos
                        System.out.println();
                        System.out.println("Lista carritos:");
                        for(int i = 0; i<carritos.size(); i++){
                            System.out.println(i + " - " +carritos.get(i).getNombreCarrito());
                        }

                        System.out.println("Seleccione número de carrito o ingrese el próximo número de carrito después del último:");
                        numCarrito = tcl.nextInt(); 
                        tcl.nextLine();

                        if(numCarrito > (carritos.size()-1) ){ //es nuevo carrito
                            System.out.println("Nombre Carrito:");
                            nombreCarrito = tcl.nextLine(); 
                        }                        
                    }

                    agregarComida(numCarrito, nombreCarrito, co);

                    break;
                case 2:  //Listar comidas de un carrito
                    
                    System.out.println("Seleccionar un Carrito de la compra:");
                    for (int i = 0; i < carritos.size(); i++) {
                        System.out.println(i + " - " + carritos.get(i).getNombreCarrito());
                    }

                    System.out.println(carritos.size() + " - Mostrar todos los carros");

                    System.out.println();
                    numCarrito = tcl.nextInt();
                    tcl.nextLine();

                    //System.out.println("Valor numCarrito: " +  numCarrito);
                    mostrarComida(numCarrito);
                    break;
                case 3: //3 - Modificar Comida
                    modificarComida(tcl);                    
                    break;
                case 4:                    
                    eliminarComida(tcl);
                    break;
                case 5:                    
                    buscarComida(tcl);
                    break;                                                                                
                case 0:
                    System.out.println("Salir del programa.");
                    break;            
                default:
                    System.out.println("La opción es incorrecta.");
            }

        }while (opcion != 0);


        tcl.close();
    }


    //métodos para gestionar los Carritos de la Compra

    public static void seleccionarCarrito(Scanner tcl, int numCarrito){
        System.out.println("Seleccionar un Carrito de la compra:");
        for (int i = 0; i < carritos.size(); i++) {
            System.out.println(i + " - " + carritos.get(i).getNombreCarrito());
        }

        System.out.println(carritos.size() + " - Mostrar todos los carros");

        System.out.println();
        numCarrito = tcl.nextInt();
        tcl.nextLine();
    }


    public static void agregarComida(int numeroCarrito, String nombreCarrito, Comida comida){

        if(numeroCarrito < carritos.size()){  //el carrito de comida existe
            carritos.get(numeroCarrito).agregarComidaEnCarrito(comida);
        }else{                                //si el carrito es NUEVO
            //1 se crea  el carrito
            Carrito ca = new Carrito(nombreCarrito);
            ca.agregarComidaEnCarrito(comida);
            
            //2 se añade a la lista de carritos
            carritos.add(ca);
        }

        //mostrar carritos
        for (int i = 0; i < carritos.size(); i++) {
            carritos.get(i).mostrarComidas();
        }


    }

    public static void mostrarComida(int numeroCarrito){

        System.out.println("mostrarComida: " +numeroCarrito);
        System.out.println("carritos size: " +carritos.size());

        if ( numeroCarrito != carritos.size() ){
            //recorrer los carritos y mostrar las comidas del indicado
            for (int i = 0; i < carritos.size(); i++) {

                if ( numeroCarrito == i){
                    carritos.get(i).mostrarComidas();
                }
                
            }
        }else{
            mostrarComidaCarros();         
        }
    }

    public static void mostrarComidaCarros(){
        
        //recorrer los carritos y mostrar las comidas del indicado
        for (int i = 0; i < carritos.size(); i++) {
                System.out.println();
                //System.out.println(carritos.get(i).toString());
                //System.out.println("=======================");
                carritos.get(i).mostrarComidas();
                System.out.println();            
        } 

    }

    public static void comunDatos(Scanner tcl, int numCarrito, String nombreComida){
        System.out.println("Lista carritos:");
        System.out.println(carritos.toString());

        System.out.println("Selecciona el numero de carro:");
        numCarrito = tcl.nextInt();
        tcl.nextLine();

        System.out.println();
        mostrarComida(numCarrito);
        System.out.println();

        //Escribir la comida a buscar, para modificar datos
        System.out.println("Introduce el nombre de comida a eliminar del carro");
        nombreComida = tcl.nextLine();        
    }



    public static void modificarComida(Scanner tcl){
        System.out.println("Lista carritos:");        
        for (int i = 0; i < carritos.size(); i++) {
            System.out.println(i + " - " + carritos.get(i).getNombreCarrito());
            
        }

        System.out.println("Selecciona el numero de carro:");
        int numCarrito = tcl.nextInt();
        tcl.nextLine();

        System.out.println();
        mostrarComida(numCarrito);
        System.out.println();

        //Escribir la comida a buscar, para modificar datos
        System.out.println("Introduce el nombre de comida a eliminar del carro");
        String nombreComida = tcl.nextLine();

        for (int i = 0; i < carritos.size(); i++) { //recorrer los carros para actualizar el/los dato/s

            if ( i == numCarrito ){ //se encuentra el carro y se procederá a modificar el alimento
                carritos.get(i).modificarComida(tcl, nombreComida);
                i += carritos.size(); //así finalizará el bucle
            }
        
        }

        System.out.println("Lista de comidas actualizada, después de modificar:");
        System.out.println();
        mostrarComidaCarros();       

    }

    public static void eliminarComida(Scanner tcl){           
        System.out.println("Lista carritos:");
        System.out.println(carritos.toString());
        
        System.out.println("Selecciona el numero de carro:");
        int numCarrito = tcl.nextInt();
        tcl.nextLine();

        seleccionarCarrito(tcl, numCarrito);

        System.out.println();
        mostrarComida(numCarrito);
        System.out.println();

        

        //Escribir la comida a buscar, para eliminar datos
        System.out.println("Introduce el nombre de comida a eliminar del carro");
        String nombreComida = tcl.nextLine();

        for (int i = 0; i < carritos.size(); i++) { //recorrer los carros para actualizar el/los dato/s

            if ( i == numCarrito ){ //se encuentra el carro y se procederá a eliminar el alimento
                carritos.get(i).eliminarComida(nombreComida);
                i += carritos.size(); //así finalizará el bucle
            }
        
        }

        System.out.println();
        System.out.println("Lista de comidas actualizada, después de eliminar:");
        System.out.println();
        mostrarComidaCarros();  
        System.out.println();         

    }

    public static void buscarComida(Scanner tcl){
        //Escribir la comida a buscar dentro de los carros
        System.out.println("Introduce el nombre de comida a mostrar en que carros está:");
        String nombreComida = tcl.nextLine();

        boolean existe=false;
        System.out.println("La comida " + nombreComida + ", se encuentra en los carritos:");

        for (int i = 0; i < carritos.size(); i++) { //recorrer los carros para actualizar el/los dato/s

            existe =carritos.get(i).buscarComida(nombreComida);

        }

    }
}
