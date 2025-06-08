
//Tienes un carrito de la compra donde puedas añadir, leer, modificar, borrar y BUSCAR elementos.

import java.util.ArrayList;
import java.util.Scanner;

public class Carrito {
    private String nombreCarrito;
    private ArrayList<Comida> comidas = new ArrayList<>();



    public Carrito(String nombreCarrito) {
        this.nombreCarrito = nombreCarrito;
    }


    public void agregarComidaEnCarrito(Comida comida){
        this.comidas.add(comida);
    }

    public void mostrarComidas(){
        System.out.println(toString());
        System.out.println("================");
        for (int j = 0; j < comidas.size(); j++) {
            System.out.println(comidas.get(j)); //toda la información de la comida
        }        
    }

    public void modificarComida(Scanner tcl, String nombreComida){

        //se recorre la lista de comidas para modificar el/los dato/s
        for (int i = 0; i < comidas.size(); i++) {
            //se encuentra la comida y se procede a revisar los datos
            if ( comidas.get(i).getNombre().equalsIgnoreCase(nombreComida)){
                
                //se solicita la información de los datos a cambiar

                System.out.println("La comida "+ nombreComida + ", se encuentra en el carro "+
                                    getNombreCarrito() + ".");

                int opcion;

                do{
                    
                        System.out.println();
                        System.out.println("Seleccionar un dato a modificar:");
                        System.out.println("1 - Nombre Comida");
                        System.out.println("2 - Origen Comidas");
                        System.out.println("3 - Peso Comida");
                        System.out.println("4 - Precio/kg Comida");
                        System.out.println("0 - Salir");
                        opcion = tcl.nextInt();
                        tcl.nextLine();  

                        switch (opcion) {
                            case 1:
                                System.out.println("Nombre:");
                                String nombre = tcl.nextLine();  
                                
                                comidas.get(i).setNombre(nombre);

                                break;
                            case 2:
                                System.out.println("Origen:");
                                String origen = tcl.nextLine();  

                                comidas.get(i).setOrigen(origen);

                                break; 
                            case 3:                   
                                System.out.println("Peso:");
                                float peso = tcl.nextFloat();

                                comidas.get(i).setPeso(peso);

                                tcl.nextLine();  
                                break;                                                         
                            case 4:                   
                                System.out.println("Precio/kg:");
                                double precio = tcl.nextDouble();
                                
                                comidas.get(i).setPrecio(precio);

                                tcl.nextLine();   

                                break;                       
                            default:
                                System.out.println("Opción errónea");
                        }

                        System.out.println();
                    
                }while(opcion != 0);

                System.out.println("Datos actualizados de la comida " + nombreComida + " por:");
                System.out.println(comidas.get(i));
                System.out.println();

            }else{
                System.out.println("El alimento " + nombreComida + ", no existe.");
            }

        }

    }

    public void buscarComida(String nombre){

        for (int i = 0; i < comidas.size(); i++) {
            //se encuentra la comida y se procede a revisar los datos
            if ( comidas.get(i).getNombre().equalsIgnoreCase(nombre)){   
                System.out.println(toString());
            }            
        }
    }

    public void eliminarComida(String nombre){

        //se recorre la lista de comidas para modificar el/los dato/s
        for (int i = 0; i < comidas.size(); i++) {
            //se encuentra la comida y se procede a revisar los datos
            if ( comidas.get(i).getNombre().equalsIgnoreCase(nombre)){   
                comidas.remove(i);

                i += comidas.size(); //para salir una vez eliminada la comida
            }
        }     
        
    }

    public String getNombreCarrito() {
        return this.nombreCarrito;
    }

    public void setNombreCarrito(String nombre) {
        this.nombreCarrito = nombre;
    }


    @Override
    public String toString() {
        return "Carrito: " + getNombreCarrito();
    }


    
}
