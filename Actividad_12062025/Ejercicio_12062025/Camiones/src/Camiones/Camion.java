package Camiones;

public class Camion {

    private static int ruedas = 6;
    private String marca;
    private String martricula;
    private boolean buen_estado; //true / false


    public Camion() {
    }


    public Camion(String marca, String martricula, boolean buen_estado) {
        this.marca = marca;
        this.martricula = martricula;
        this.buen_estado = buen_estado;
    }


    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMartricula() {
        return this.martricula;
    }

    public void setMartricula(String martricula) {
        this.martricula = martricula;
    }

    public boolean isBuen_estado(){
        return this.buen_estado;
    }

    public void setBuen_estado(boolean buen_estado){
        this.buen_estado = buen_estado;
    }


    //acelerar() y frenar()
    public static void acelerar(Camion ca) {

        System.out.println( "El camión " + ca.marca + " está acelerando!");
        
    }


    public static void frenar(Camion ca) {

        System.out.println( "El camión " + ca.marca + " está frenando!");
        
    }

    public static int getRuedas(){
        return ruedas;
    }


    


    @Override
    public String toString() {
        return "El camión es de la marca " + getMarca() + ". Matrícula: " +  getMartricula() + ". Num ruedas: " + ruedas + 
               " Buen estado: " + (isBuen_estado() ? "Sí." : "No." );
    }

}
