
    /*
     * 1- DISCOS DE VINILO

Crear un arraylist con al menos 5 discos, con los datos: Artista, título, año, duración (pueden ser otros).


- Mostrar todos los discos, con todos los datos. Que esto sea un método externo al main


- Mostrar uno determinado: por ejemplo el año del tercer disco (esto lo podría pedir el cliente, o no)


- Cambiar ese mismo año (esto lo podría pedir el cliente, o no) y mostrar ese cambio.


- Etc hacer pruebas


EXTRA: método buscador con contains() o con equals(). Que el usuario escriba nombre de artista y me diga si está, y en qué posición está.


+EXTRA:
Que todos estos datos los entre el cliente: usuario entra Artista, título, año y duración (no hace falta hacer un CRUD entero).
     */

import java.util.Scanner;

public class Vinilo {
    private String artista;
    private String titulo;
    private int    anyo;
    private double duracion;

    public Vinilo(){        
    }


    public Vinilo(String artista, String titulo, int anyo, double duracion, String estilo) {
        this.artista = artista;
        this.titulo = titulo;
        this.anyo = anyo;
        this.duracion = duracion;
    }

    //GETTERS / SETTERS


    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getDuracion() {
        return this.duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    //MÉTODOS
    //método para introducir inicialmente los 5 vinilos
    public void introVinilo(Scanner tcl, int numVinilo){

        System.out.printf("Albúm numero %d ", numVinilo);
        System.out.println();

        //datos a introducir

        System.out.println("Artista:");
        setArtista(tcl.nextLine());
        System.out.println();

        System.out.println("Título:");
        setTitulo(tcl.nextLine());
        System.out.println();

        System.out.println("Año:");
        setAnyo(tcl.nextInt());
        tcl.nextLine();
        System.out.println();
        
        System.out.println("Duración álbum:");
        setDuracion(tcl.nextDouble());
        tcl.nextLine();
        System.out.println();          

    }

    //- Mostrar uno determinado: por ejemplo el año del tercer disco (esto lo podría pedir el cliente, o no)
    private void DatoVinilo(int dato, int numVinilo){
    
        switch (dato) {
            case 1:  //Artista
                System.out.printf("El artista del Vinilo numero %d es %s.", numVinilo, getArtista());
                break;
            case 2:  //Título
                System.out.printf("El artista del Vinilo numero %d es %s.", numVinilo, getTitulo());
                break;
            case 3:  //Año
                System.out.printf("El artista del Vinilo numero %d es %d.", numVinilo, getAnyo());
                break;
            case 4:  //Duración
                //System.out.println("El artista del Vinilo numero %d es %i", (numVinilo-1), (int) getDuracion()); 
                //NO ME FUNCIONO el i, PARA MOSTRAR EL DOUBLE COMO ENTERO!!!

                System.out.println("El artista del Vinilo numero " + numVinilo + ", es "+ ((int) getDuracion()) );
                break; 
            case 0: 
                System.out.println("Fin consulta dato!");
                break;                                                  
            default:
                System.out.println("Opción incorrecta!");
                break;
        }

    }

    public void mostrarDatoVinilo(int dato, int numVinilo){
         DatoVinilo(dato, numVinilo);
    }

    public void modificarDato(int dato, int numVinilo, Scanner tcl){
        String tipoDato = ( (dato == 1) ? "Artista" : ((dato == 2) ? "Título" : ((dato == 3) ? "Año" : ((dato == 4) ? "Duración" : "-" ))));
        System.out.println("Introduzca el dato a cambiar para "+ tipoDato + "\n");

        String cadena="";
        int    numerico=0;

        switch (dato) {
                case 1:  //Artista
                case 2:  //Título                    
                    cadena = tcl.nextLine();
                    break;
                case 3:  //Año
                case 4:  //Duración
                    numerico = tcl.nextInt();
                    break;                                     
                default:
                    System.out.println("No se cambia nada");
                    break;
        }

        //se actualiza el dato
        switch (dato) {
                case 1:  //Artista
                    setArtista(cadena);
                    break;
                case 2:  //Título                    
                    setTitulo(cadena);
                    break;
                case 3:  //Año
                    setAnyo(numerico);
                case 4:  //Duración
                    setDuracion(numerico);
                    break;                                     
                default:
                    break;
        }

        //mostrar la información del álbum
        System.out.println("Se ha cambiado el dato del vinilo " + numVinilo);
        System.out.println();        
        System.out.println(toString());
        System.out.println();

    }


    //TOSTRING

    @Override
    public String toString() {
        return "Álbum: " + getTitulo() + " del artista='" + getArtista() + ", año " + getAnyo() + " (duración de "+ getDuracion()+")\n";
    }


    


    
}
