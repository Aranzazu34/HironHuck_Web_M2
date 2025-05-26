/*
 Necesitas crear el objeto Ordenador, con sus atributos correspondientes: marca, modelo, memoria RAM, capacidad del disco duro, precio ... etc 
 (cantidad y tipo de  atributos a tu gusto, pero poner al menos 3).

Debes añadir el método constructor, los getters y setters y el toString(). Recuerda no hacer copiar y pegar, ni buscar ningún método de generación 
de código automático. Hay que pensar y practicar, al menos por hoy!

Siéntete libre de modificar el toString a tu gusto.
 */

public class Ordenador {
    private String marca;
    private String modelo;
    private double ram;
    private double hd;
    private double precio;
    private boolean ult_modelo;

    //constructor
    public Ordenador(String marca, String modelo, double ram, double hd, double precio, boolean ult_modelo){
          this.marca = marca;
          this.modelo = modelo;
          this.ram = ram;
          this.hd = hd;
          this.precio = precio;
          this.ult_modelo = ult_modelo;
    }

    //GETTERS
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public double getRam(){
        return this.ram;
    }

    public double getHd(){
        return this.hd;
    }

    public double getPrecio(){
        return this.precio;
    }

    public boolean isUlt_Modelo(){
        return this.ult_modelo;
    }

    //SETTERS
    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setRam(double ram){
        this.ram = ram;
    }

    public void setHd(double hd){
        this.hd = hd;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setUlt_Modelo(boolean ult_modelo){
        this.ult_modelo = ult_modelo;
    }

    //TOSTRING
    @Override
    public String toString() {
        String cad = (this.ult_modelo) ? "Sí" : "No";

        return " Marca: " + this.marca + "\n" +
        " Modelo: " + this.modelo + "\n" +
        " RAM: " + this.ram + "\n" +
        " HD: " + this.hd + "\n" +
        " Precio: " + this.precio + "\n" +
        " Último Modelo: " +  cad;
    }

    /*+EXTRA: para quien ya conozca la creación de clases en Java, que pruebe a crear métodos en la clase Ordenador, como por ejemplo el método 
    oferta: le pasas un descuento como parámetro y te calcula el nuevo precio */
    public double oferta(double descuento){
        double dto = ((this.precio*descuento)/100);
        System.out.printf("Se aplicará un descuento de %.2f euros", dto);
        System.out.println();
        return (this.precio - dto);
    }
    
}