public class Instrumento {
    //propiedades sin inicializar
    // se aconseja que las propiedades sean de tipo privado
    // solo puede accederse a su valor desde esa clase Instrumento
    private String nombre;
    private String marca;
    private double precio;
    private String codigo;
    private boolean dispo;

    public Instrumento(String nombre2, String marca2, double precio2, 
                String codigo2, boolean dispo2){

        this.nombre = nombre2;
        this.marca = marca2;
        this.precio = precio2;
        this.codigo = codigo2;
        this.dispo = dispo2;                

        //o en este caso sin this por llamarse los parámetros distintos a 
        //los tributos de la clase

    }

    //mostrar las propiedades del elemento instanciado (el objeto)
    @Override  //sobreescribe el método
    public String toString() {
        return "Nombre: " + this.nombre + 
        " Marca: " + this.marca +
        " Precio: " + this.precio +
        " Código: " + this.codigo +
        " Disponibilidad: " + this.dispo;
    }

    // los métodos públicos gestionan los atributos privados:
    // se usan los GETTER para leer
    // y los SETTERS para modificar

    // leer: retorna el dato
    public String getNombre(){
        return this.nombre;
    }

    // modificar: no retorna nada, pero cambia el dato por lo que 
    // recibe el argumento para cambiarlo
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //excepcion con el GET
    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }




}
