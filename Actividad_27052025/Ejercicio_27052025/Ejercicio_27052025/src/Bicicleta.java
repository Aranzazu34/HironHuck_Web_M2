public class Bicicleta {
    private String marca;
    private String modelo;
    private int    velo_max;
    private boolean marchas;
    private int     pulgadas_ruedas;

    //constructores

    public Bicicleta() {
    }

    public Bicicleta(String marca, String modelo, int velo_max, boolean marchas, int pulgadas_ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.velo_max = velo_max;
        this.marchas = marchas;
        this.pulgadas_ruedas = pulgadas_ruedas;
    }
    
    //GETTERS / SETTERS


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

    public int getVelo_max() {
        return this.velo_max;
    }

    public void setVelo_max(int velo_max) {
        this.velo_max = velo_max;
    }

    public boolean isMarchas() {
        return this.marchas;
    }

    public boolean getMarchas() {
        return this.marchas;
    }

    public void setMarchas(boolean marchas) {
        this.marchas = marchas;
    }

    public int getPulgadas_ruedas() {
        return this.pulgadas_ruedas;
    }

    public void setPulgadas_ruedas(int pulgadas_ruedas) {
        this.pulgadas_ruedas = pulgadas_ruedas;
    }


    //métodos propios de funciones de la bicicleta
    //- Puedes añadir métodos: tocar el claxon, pedalear, parar, girar, cambiar marchas, …

    public void tocarClaxon(){
        System.out.println("Mooc, moooc");
    }

    public void pedalear(){
        System.out.println("Comienza a pedalear");
    }

    public void parar(){
        System.out.println("Parada técnica!");
    }

    //giro: derecha/izquierda
    public void girar(String giro){
        System.out.println("Vamos a girar a la " + giro);
    }

    //tipo: corta/larga
    public void cambiarMarchas(int tipo){
        System.out.println("Cambiar a marcha " + tipo);
    }
    
    //TOSTRING

    @Override

    public String toString() {
        String tieneMarchas = (isMarchas()==true) ? " sí incluye cambio de marchas" : " sin marchas";        

        return "La Bicicleta es de la marca=" + getMarca() + ", modelo=" + getModelo() + ", con una velocidad máxima de " + getVelo_max() + 
               ", " + tieneMarchas + ", con ruedas de " + getPulgadas_ruedas() + " pulgadas.";
    }




}
