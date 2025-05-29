import java.util.Scanner;

public class Circulo {
    private double radio;
    private final double PI = 3.1416;
    private double circunferencia;

    public Circulo() {
    }

    public Circulo(double radio) {
        // si pedimos al usuario en el main,
        // se puede no enviar al constructor
         if(radio>0){
            System.out.println("\nnuevo círculo creado!");
            this.radio = radio;
        } else{
            System.out.println("\nradio NO asignado!");
            System.out.println("El radio debe ser mayor que cero");
        }
    }

    public double getRadio() {
        return this.radio;
    }

    public void setRadio(double radio) { 
            this.radio = radio;
    }

    public void cambiarRadio(Scanner sc) {
        System.out.println("Dime el nuevo radio del círculo:");
        this.radio = sc.nextDouble();
        System.out.println("radio cambiado!");
    }

    public double getPI() {
        return this.PI;
    }

    public double calcularCircunferencia() {
        // calcular 2 decimales con Math.round()
        circunferencia = (double) Math.round((2 * PI * this.radio) * 100) / 100;
        return circunferencia;
    }

    public double calcularArea() {
        return (double) Math.round((PI * (this.radio * this.radio) * 100)) / 100;
    }

    public void evaluarCircunferencia() {
        // circunferencia = calcularCircunferencia();
        if (circunferencia > 0) {
            System.out.println("la circunferencia es: " + circunferencia);

            if (circunferencia <= 5) {
                System.out.println("es demasiado corta");
            } else if (circunferencia >= 500) {
                System.out.println("es demasiado larga");
            } else {
                System.out.println("tiene una longitud adecuada");
            }
        } else {
            System.out.println("la circunferencia debe estar calculada, y el radio mayor de 0");
        }

    }

    @Override
    public String toString() {
        return " radio= " + getRadio();
    }

}
