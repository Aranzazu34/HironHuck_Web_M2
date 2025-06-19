package SorteoTienda;

import java.util.ArrayList;

public class Papeleria extends GrupoTienda{
    private ArrayList<Cliente> clientes_sorteo = new ArrayList<>();


    public Papeleria() {
    }


    public Papeleria(ArrayList<Cliente> clientes_sorteo) {
        this.clientes_sorteo = clientes_sorteo;
    }



    public ArrayList<Cliente> getClientes_sorteo() {
        return this.clientes_sorteo;
    }

    public void setClientes_sorteo(ArrayList<Cliente> clientes_sorteo) {
        this.clientes_sorteo = clientes_sorteo;
    }



    //El método inscribirDatos() da una bienvenida personalizada al tipo de tienda, y pide inscribir los datos del cliente: nombre y telefono.
    public void inscribirDatosCliente(){
        System.out.println("mensaje");
    }

    //El método darNumero() hace un random, por ejemplo número del 1 al 10000,y lo asigna a ese cliente
    public void darNumero(){
        System.out.println("mensaje");
    }

    //El método ComunicarResultadoSorteo() hace un random y dice qué número ha ganado, con una frase personalizada del tipo: "La papelería PaperPepa 
    //te comunica que ha salido ganador el número: ". No hace falta ver si le ha tocado el premio a un cliente específico
    public void comunicarResultadoSorteo(){
        System.out.println("mensaje");
    }



    @Override
    public String toString() {
        String cadena = "La  " + getClass().getSimpleName().toLowerCase() + " tiene los siguientes Clientes:\n\n";

        for (Cliente cliente : getClientes_sorteo()) {

            cadena += " - " + cliente.toString() + "\n";            
            
        }

        return cadena;                
    }




}
