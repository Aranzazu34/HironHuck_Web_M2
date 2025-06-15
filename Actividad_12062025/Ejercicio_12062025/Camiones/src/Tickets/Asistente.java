package Tickets;

import java.util.UUID;

public class Asistente {
    private String nombre;
    private String apellido;
    private UUID    numero;


    public Asistente() {
    }


    public Asistente(String nombre, String apellido, Long numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = UUID.randomUUID();
    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public UUID getNumero() {
        return this.numero;
    }

    public void setNumero(UUID numero) {
        this.numero = numero;
    }




    @Override
    public String toString() {
        return "El asistente con código " + getNumero() +
            ", se llama " + getNombre() + " " + getApellido() + "."
            ;
    }



}
