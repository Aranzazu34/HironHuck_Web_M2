package Iva;

import java.util.Scanner;

/*
1- (facil) Métodos: Cálculo IVA:
Diferentes tipos de IVA:
- General = 21% (ej. Ropa);
- Reducido = 10% (bono-metro);
- Super-reducido = 4% (huevos);
- Exento = 0% (dentista)

- Para el cálculo, hacer cuatro CONSTANTES para cada tipo de IVA.
- Pides el precio de producto, el tipo de IVA, y pasas estos dos parámetros a la función
calcularPrecioFinal(), y ésta te DEVUELVE el precio final (int o float), y se imprime en el main().

- Ejemplo: para el 21%, el precio final sería precioProducto + (precioProducto*0.21);
Ejemplo de constante para IVA21 = 0.21;
 */


public class App {

    //constantes
    public static final float IGENERAL = 21;
    public static final float IREDUCIDO = 10;
    public static final float ISREDUCIDO = 4;
    public static final float IEXENTO = 0;

    public static void main(String[] args) throws Exception {
        Scanner tcl = new Scanner(System.in);        

        // limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush(); 


        float   precio_producto;        
        String  tipoIva;
        float   porcentaje=0;
        float   precio_final;
        boolean salir=false;

        do{
            System.out.println("Introduce Precio del Producto:");
            precio_producto = tcl.nextFloat();
            tcl.nextLine();

            System.out.println("Tipo IVA (GENERAL/REDUCIDO/SUPER_REDUCIDO/EXENTO):");
            tipoIva = tcl.nextLine();
            System.out.println();


            precio_final = calcularPrecioFinal(precio_producto, tipoIva);



            if (precio_final == -1){
                System.out.println("No se ha realizado correctamente el cálculo del importe final, porque un dato es incorrecto");
            }else{

                switch (tipoIva) {
                    case "GENERAL":
                        porcentaje = getIGENERAL();

                        break;
                    case "REDUCIDO":
                        porcentaje = getIREDUCIDO();
                        
                        break;
                    case "SUPER_REDUCIDO":
                        porcentaje = getISREDUCIDO();
                        
                        break;
                    case "EXENTO":
                        porcentaje = getEXENTO();
                        
                        break;                                                        
                }

                System.out.println("El precio del producto es de "+precio_producto+", se le ha aplicado un iva del "+ porcentaje +
                                   " %. El precio final es de "+ precio_final);

                System.out.println();
            }

            System.out.println("Quiere salir? (true/false)");
            salir = tcl.nextBoolean();
            tcl.nextLine();   
            System.out.println();

        }while(!salir)
        ;

        tcl.close();
    }


    public static float getIGENERAL(){
        return IGENERAL;
    }

    public static float getIREDUCIDO(){
        return IREDUCIDO;
    }

    public static float getISREDUCIDO(){
        return ISREDUCIDO;
    }

        public static float getEXENTO(){
        return IEXENTO;
    }

    public static float calcularPrecioFinal(float precio, String tipoIva){
        float porcentaje;


        switch (tipoIva) {
            case "GENERAL":
                porcentaje = IGENERAL / 100;

                break;
            case "REDUCIDO":
                porcentaje = IREDUCIDO / 100;
                
                break;
            case "SUPER_REDUCIDO":
                porcentaje = ISREDUCIDO / 100;
                
                break;
            case "EXENTO":
                porcentaje = 0;
                
                break;                                                        
            default:
                System.out.println("Dato incorrecto, no consta como Iva.");
                return -1;                
        }  

        return precio + (precio * porcentaje);
    }
}
