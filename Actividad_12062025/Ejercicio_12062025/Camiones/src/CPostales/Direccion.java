package CPostales;

public class Direccion {
    private String Calle;
    private String ciudad;
    private int    cpostal;


    public Direccion() {
    }


    public Direccion(String Calle, String ciudad, int cpostal) {
        this.Calle = Calle;
        this.ciudad = ciudad;
        this.cpostal = cpostal;
    }



    public String getCalle() {
        return this.Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCpostal() {
        return this.cpostal;
    }

    public void setCpostal(int cpostal) {
        this.cpostal = cpostal;
    }




    @Override
    public String toString() {
        return "Calle " + getCalle() + ", de la ciudad " + getCiudad() + "." +
            " Código postal='" + getCpostal();
    }




}
