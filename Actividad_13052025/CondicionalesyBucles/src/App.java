import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //condicionales IF..ELSE igual que javascript!
        Scanner teclado = new Scanner(System.in);
        System.out.println("eh, tú, qué edad tienes?");
        int edad = teclado.nextInt();

        if(edad > 18){
            System.out.println("Adelante!");
        }else if(edad == 18){
            System.out.println("por poco! Entra!");
        }else{
            System.out.println("hasta luego Lucas");
        }

        teclado.nextLine();

        //excepción: comparar dos strings con equals()
        System.out.println("como tellamas?");
        String nombre = teclado.nextLine();

        if (nombre.equals("jordi")){
            System.out.println("a ver, el carnet");            
        }else{
            System.out.println("lo siento, no tienes descuento, hoy es Sant Jordi");
        }

        int precioProducto;
        int sumaTotal = 0;

        //bucles FOR: igual que JSpero en vez de let i = 0 haces int i = 0
        for (int i=0;i<10;i++){
            System.out.println("cuanto vale el producto " + (i+1));
            precioProducto = teclado.nextInt();
            sumaTotal += precioProducto; //acumulador
        }

        System.out.println("te has gastado " + sumaTotal + " $");

        teclado.close();
    }
}
