import java.util.Scanner;

public class App {
    /*
    Una vez definida la clase del ordenador, crea al menos 3 instancias y prueba a imprimir los objetos en dos maneras:

    1. Todas sus características

    2. Imprime solo características sueltas como la marca y el precio del ordenador elegido.

    3. Probar a cambiar una propiedad y volver a mostrarla.

    +EXTRA: para quien ya conozca la creación de clases en Java, que pruebe a crear métodos en la clase Ordenador, como por ejemplo el método 
    oferta: le pasas un descuento como parámetro y te calcula el nuevo precio

    +EXTRA: incluye un boolean como "disponibilidad". Cómo pasarías el valor true o false al string "hay disponibles" o "no hay disponibles?"

        HECHO EN LA PROPIA CLASE AL HACE COMO UN DECODE en Java y dentro del main línea 78

        (nOrdenador.isUlt_Modelo() ? "Sí" : "No" )
     */
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        char    salir = 'n';
        String opcion;

        System.out.println("Se va a iniciar el registro de Ordenadores:");
        System.out.println();

        String marca;
        String modelo;
        double ram;
        double hd;
        double precio;
        char    uModelo;
        boolean ult_modelo;

        double descuento;

        while (salir == 'n') {
            //por teclado se van solicitando los datos del Ordenador (marca, modelo, ram, hd, precio, ult_modelo)

            System.out.println("Marca:");
            marca = teclado.nextLine();

            System.out.println("Modelo:");
            modelo = teclado.nextLine(); 

            System.out.println("RAM:");
            ram = teclado.nextDouble(); 
            teclado.nextLine();

            System.out.println("HD:");
            hd = teclado.nextDouble(); 
            teclado.nextLine();       

            System.out.println("Precio:");
            precio = teclado.nextDouble(); 
            teclado.nextLine();  

            System.out.println("Es último Modelo (s/n):");
            uModelo = (char) System.in.read();
            uModelo = Character.toLowerCase(uModelo);

            if(uModelo=='s'){
                ult_modelo = true;
            }else{
                ult_modelo = false;
            }  
            
            //se crea la instancia del Objeto ordenador
            Ordenador nOrdenador = new Ordenador(marca, modelo, ram, hd, precio, ult_modelo);

            //1. Todas sus características
            System.out.println();
            System.out.println(nOrdenador.toString());    
            System.out.println();

            //2. Imprime solo características sueltas como la marca y el precio del ordenador elegido.
            System.out.println("Marca: " + nOrdenador.getMarca() + ", Precio: " +nOrdenador.getPrecio() + 
                               ", Últ. Modelo: "+ (nOrdenador.isUlt_Modelo() ? "Sí" : "No" )); 
            System.out.println();

            //3. Probar a cambiar una propiedad y volver a mostrarla.
            System.out.println("Precio nuevo:");
            precio = teclado.nextDouble(); 
            teclado.nextLine();  
            nOrdenador.setPrecio(precio);
            System.out.println("El precio nuevo del ordenador: " + nOrdenador.getPrecio());
            System.out.println();

            //EXTRA: descuento oferta
            System.out.println("Porcentaje dto:");
            descuento = teclado.nextDouble(); 
            teclado.nextLine();              
            System.out.printf("El precio nuevo con el descuento del %.2f es: %.2f", descuento, nOrdenador.oferta(descuento));
            System.out.println();            
            
            System.out.println("Desea registrar un Ordenador? (s/n)");
            opcion = teclado.nextLine();
            System.out.println();

            if (opcion.equalsIgnoreCase("n")) {
                salir = 's';
            }
            
        }

        teclado.close();
    }
}
