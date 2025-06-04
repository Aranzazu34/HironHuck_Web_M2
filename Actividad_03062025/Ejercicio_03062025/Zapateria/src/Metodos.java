import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Metodos {

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