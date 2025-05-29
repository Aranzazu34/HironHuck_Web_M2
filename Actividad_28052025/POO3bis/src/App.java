import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * tenemos una clase circulo
         * tres metodos:
         * calcular cicunferencia
         * calcular area circulo
         * decir si es longitud circunferencia normal, pequeña o grande
         * ej: <=5(cm) demasiado pequeña / >500 demasiado grande
         */
        Scanner sc = new Scanner(System.in);
        

        System.out.println("\nCIRCULO 1");
        Circulo c1 = new Circulo(10);
        System.out.println(c1.toString());
        System.out.print("circunferencia= ");
        System.out.println(c1.calcularCircunferencia());
        System.out.print("area= ");
        System.out.println(c1.calcularArea());
        c1.evaluarCircunferencia();

        c1.cambiarRadio(sc);
        System.out.println(c1.toString());

        /************************ */
        
        Circulo c2 = new Circulo(-22);
        System.out.println("\nCIRCULO 2");
        System.out.println(c2.toString());
        System.out.print("circunferencia= ");
        System.out.println(c2.calcularCircunferencia());
        System.out.print("area= ");
        System.out.println(c2.calcularArea());
        c2.evaluarCircunferencia();
        
    }
}
