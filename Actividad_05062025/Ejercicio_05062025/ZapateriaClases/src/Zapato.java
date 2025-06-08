import java.util.ArrayList;
import java.util.Scanner;

public class Zapato {
    private String  marca;
    private String  modelo;
    private String  talla;
    private Double  precio;


    public Zapato() {
    }


    public Zapato(String marca, String modelo, String talla, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;
    }

    

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return this.talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void introducirZapato(ArrayList<Zapato> lista, Scanner tcl){
        boolean salir = false;

        do{        
            System.out.println();
            System.out.println("Qué tipo de zapato va a introducir?");        
            System.out.println("1- Casual\n2- Deporte\n3- Elegante\n4- Salir");
            int  opcion = tcl.nextInt();
            tcl.nextLine();
            
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("===Casual===");   
                    break;
                case 2:
                    System.out.println("===Deporte===");
                    break;
                case 3:
                    System.out.println("===Elegante===");
                    break;
                case 4:
                    System.out.println("No se introducen más Zapatos.");
                    salir = true;
                    break;
                default:
                    System.out.println();
            }            

            //datos comunes
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                    //común a los distintos Arrays
                    System.out.println("Marca:");
                    String marca = tcl.nextLine();

                    System.out.println("Modelo:");
                    String modelo = tcl.nextLine();

                    System.out.println("Talla:");
                    String talla = tcl.nextLine();

                    System.out.println("Precio:");
                    double precio = tcl.nextDouble();
                    tcl.nextLine();            

                    //ahora según el tipo de Zapato, sus atributos de Clase
                    switch (opcion) {
                        case 1:
                            System.out.println("Material:");                            
                            String material = tcl.nextLine(); 

                            Casual ca = new Casual(marca, modelo, talla, precio, material);
                            System.out.println();
                            System.out.println(ca.toString());

                            lista.add(ca);

                            break;
                        case 2:
                            System.out.println("Especialidad:");
                            String especialidad = tcl.nextLine(); 

                            System.out.println("Es última Tendencia? (true/false)");
                            boolean ult_tendencia = tcl.nextBoolean();
                            tcl.nextLine();

                            Deporte de = new Deporte(marca, modelo, talla, precio, especialidad, ult_tendencia);
                            System.out.println();
                            System.out.println(de.toString());

                            lista.add(de);

                            break;
                        case 3:
                            System.out.println("Tiene hebilla? (true/false)");
                            boolean tieneHebilla = tcl.nextBoolean();
                            tcl.nextLine();

                            Elegante el = new Elegante(marca, modelo, talla, precio, tieneHebilla);
                            System.out.println();
                            System.out.println(el.toString());

                            lista.add(el);

                            break;
                    }
                default:
                System.out.println();
            }
        
        }while (!salir);

    }


    @Override
    public String toString() {
        return "\nEl zapato es de la marca " + getMarca() + ", modelo " + getModelo() + " de la talla " + getTalla() + 
               ". Tiene un precio de " + getPrecio() + ".\n";
    }



    
}
