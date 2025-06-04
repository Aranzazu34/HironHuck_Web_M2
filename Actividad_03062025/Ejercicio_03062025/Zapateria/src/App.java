import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    /*
     * Instructions
EJERCICIO TIENDA ZAPATERIA (primera parte)
Tienes una zapatería con tres categorías de zapatos: Elegante, Casual, Deporte (una clase cada uno).


Todos tienen las mismas características: marca, modelo, material, talla y precio. De momento, no hay propiedades
distintas.


En el programa principal, crear al menos dos instancias de cada categoría (zapatos en concreto).
Se listan todos los zapatos con sus características.

Primero se pregunta al usuario qué tipo de zapato quiere comprar, del tipo:

"Que tipo de zapatos quieres comprar?\n1-ELEGANTES\n2-CASUAL\n3-DEPORTIVOS"


Luego se pregunta al usuario qué modelo quiere comprar. Lo que vale ese modelo, se va sumando al
gastoTotal, y se sigue preguntando qué modelo quiere comprar hasta que escribe ‘salir’.


Cuando sale, se le da el gasto total y un mensaje de ‘hasta la próxima’. El gasto total también se
puede ir mostrando dentro del bucle mientras se va sumando.

     */
    public static void main(String[] args) throws Exception {
        Scanner  tcl = new Scanner(System.in);

        //se definen 3 arrays de los distintos tipos de Zapato
        ArrayList<Casual> casuales = new ArrayList<>();
        ArrayList<Deporte> deportivos = new ArrayList<>();
        ArrayList<Elegante> elegantes = new ArrayList<>();

        //introducir los zapatos de los 3 tipos
        int i = 0;
        while (i<1) {            
            introZapatoCasual(casuales,  tcl);
            
            System.out.println();
            i +=1;
            //System.out.println(i);
        }

        i = 0;
        while (i<1) {            
            introZapatoDeporte(deportivos,  tcl);
            
            System.out.println();
            i +=1;
            //System.out.println(i);
        }

        i = 0;
        while (i<1) {
            introZapatoElegante(elegantes, tcl);
            
            System.out.println();
            i +=1;
            //System.out.println(i);
        }           

        //mostrar los zapatos
        System.out.println();
        mostrarZapatosCasuales(casuales);       

        System.out.println();
        mostrarZapatosDeportivos(deportivos);
        
        System.out.println();
        mostrarZapatosElegantes(elegantes);

        System.out.println();


        //gestion de compra
        System.out.println("=================COMPRAR======================");
        
        String comprar = "si";
        int tipo;
        Double gastoTotal= 0.0;
        Double gastoCompra = 0.0;

        while(comprar.equalsIgnoreCase("si")){
                System.out.println("Que tipo de zapatos quiere comprar?\n1-ELEGANTES\n2-CASUAL\n3-DEPORTIVOS");
                tipo = tcl.nextInt();
                tcl.nextLine();

                System.out.println();

                switch (tipo) {
                    case 1:
                        mostrarZapatosElegantes(elegantes);
                        System.out.println();
                        gastoCompra = (Double) comprarZapatoElegante(elegantes, tcl);
                        break;
                    case 2:                        
                        mostrarZapatosCasuales(casuales); 
                        System.out.println();
                        gastoCompra = (Double) comprarZapatoCasual(casuales, tcl);  
                        break;                
                    case 3:
                        mostrarZapatosDeportivos(deportivos);
                        System.out.println();
                        gastoCompra = (Double) comprarZapatoDeportivo(deportivos, tcl);                       
                        break;                                        
                    default:
                        System.out.println("Opción de compra incorrecta!");
                        break;
                }


                System.out.println("gasto compra: " +gastoCompra);
                gastoTotal = gastoTotal + gastoCompra; 

                System.out.println();
                System.out.println("Lleva un gasto de: " + gastoTotal);
                System.out.println();
                System.out.println("Quiere seguir comprando?\nsi\nsalir");
                comprar = tcl.nextLine();
                System.out.println();

        }

        if ( gastoTotal > 0){
            System.out.println("Ha realizado una compra de: " + gastoTotal + " euros.");
        }

        System.out.println("Hasta la próxima!");


        tcl.close();

    }

 
    //metodos para introducir los zapatos de cada tipo.... SE PUEDE REDUCIR??? con ArrayList<Object> lista???
    public static void introZapatoCasual(ArrayList<Casual> lista, Scanner tcl){
        System.out.println("===Zapato Casual===");
        System.out.println("Marca:");
        String marca = tcl.nextLine();

        System.out.println("Modelo:");
        String modelo = tcl.nextLine();

        System.out.println("Talla:");
        String talla = tcl.nextLine();

        System.out.println("Precio:");
        double precio = tcl.nextDouble();
        tcl.nextLine();

        Casual zaCasual = new Casual(marca, modelo, talla, precio);
        lista.add(zaCasual);
    }

    public static void introZapatoDeporte(ArrayList<Deporte> lista, Scanner tcl){
        System.out.println("===Zapato Deporte===");
        System.out.println("Marca:");
        String marca = tcl.nextLine();

        System.out.println("Modelo:");
        String modelo = tcl.nextLine();

        System.out.println("Talla:");
        String talla = tcl.nextLine();

        System.out.println("Precio:");
        double precio = tcl.nextDouble();
        tcl.nextLine();

        Deporte zaDeporte = new Deporte(marca, modelo, talla, precio);
        lista.add(zaDeporte);
    }

    public static void introZapatoElegante(ArrayList<Elegante> lista, Scanner tcl){
        System.out.println("===Zapato Elegante===");
        System.out.println("Marca:");
        String marca = tcl.nextLine();

        System.out.println("Modelo:");
        String modelo = tcl.nextLine();

        System.out.println("Talla:");
        String talla = tcl.nextLine();

        System.out.println("Precio:");
        double precio = tcl.nextDouble();
        tcl.nextLine();

        Elegante zElegante = new Elegante(marca, modelo, talla, precio);
        lista.add(zElegante);
    }    

    //mostrar lista de zapatos tipo  COMO REDUCIR???

    public static void mostrarZapatosCasuales(ArrayList<Casual> lista){
        System.out.println("Lista de Zapatos Casuales:");
        System.out.println();
        for (Casual elemento : lista) {
            System.out.println(elemento);
        }
    }

    public static void mostrarZapatosDeportivos(ArrayList<Deporte> lista){
        System.out.println("Lista de Zapatos Deportivos:");
        System.out.println();
        for (Deporte elemento : lista) {
            System.out.println(elemento);
        }
    }    

    public static void mostrarZapatosElegantes(ArrayList<Elegante> lista){
        System.out.println("Lista de Zapatos Elegantes:");
        System.out.println();
        for (Elegante elemento : lista) {
            System.out.println(elemento);
        }
    }    
    
    //COMPRA DE TIPOS DE ZAPATOS

    public static Double comprarZapatoCasual(ArrayList<Casual> lista, Scanner tcl){
        System.out.println("Que modelo quiere comprar?\n");
        String modelo = tcl.nextLine();
       
        Iterator<Casual> it = lista.iterator();
        
        // Loop through a collection
        while(it.hasNext()) {
            Casual zCasual = it.next();
            if(zCasual.getModelo().equalsIgnoreCase(modelo)){
                System.out.println("El precio del modelo es de " + zCasual.getPrecio());
                return (Double) zCasual.getPrecio();
            }            
        }  

        return 0.0;
      
    }    
    public static Double comprarZapatoDeportivo(ArrayList<Deporte> lista, Scanner tcl){
        System.out.println("Que modelo quiere comprar?\n");
        String modelo = tcl.nextLine();
       
        Iterator<Deporte> it = lista.iterator();
        
        // Loop through a collection
        while(it.hasNext()) {
            Deporte zDeporte = it.next();
            if(zDeporte.getModelo().equalsIgnoreCase(modelo)){
                System.out.println("El precio del modelo es de " + zDeporte.getPrecio());
                return (Double) zDeporte.getPrecio();
            }            
        }
        
        return 0.0;
      
    }    

    public static Double comprarZapatoElegante(ArrayList<Elegante> lista, Scanner tcl){
        System.out.println("Que modelo quiere comprar?\n");
        String modelo = tcl.nextLine();
       
        Iterator<Elegante> it = lista.iterator();
        
        // Loop through a collection
        while(it.hasNext()) {
            Elegante zElegante = it.next();
            if(zElegante.getModelo().equalsIgnoreCase(modelo)){
                System.out.println("El precio del modelo es de " + zElegante.getPrecio());
                return (Double) zElegante.getPrecio();
            }            
        }

        return 0.0;    
      
    }
    
}
