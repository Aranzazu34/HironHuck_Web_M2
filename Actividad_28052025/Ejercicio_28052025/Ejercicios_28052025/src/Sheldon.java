
/*
 * Enhorabuena! Sheldon Cooper te encarga que le hagas un listado de sus números favoritos.

Pero con las siguientes condiciones:

- El número debe ser par

- Ser mayor de 37 y menor de 173

- Que no termine en cero

- Y por supuesto, que incluya el 73
 */

import java.util.ArrayList;

public class Sheldon {
    private ArrayList<Integer> lista_Sheldon = new ArrayList<>();  //pares

    //constructores

    public Sheldon() {
    }


    public Sheldon(ArrayList<Integer> lista_Sheldon) {
        this.lista_Sheldon = lista_Sheldon;

        crear_Lista_Sheldon();  //pruebo a crear la lista en el propio constructor        
    }


    //GETTERS AND SETTERS

    public ArrayList<Integer> getLista_Sheldon() {
        return this.lista_Sheldon;
    }

    public void setLista_Sheldon(ArrayList<Integer> lista_Sheldon) {
        this.lista_Sheldon = lista_Sheldon;
    }


    //método que crea la lista de numeros Sheldon, en base a las condiciones que han de cumplir:
    /* 
       - El número debe ser par
       - Ser mayor de 37 y menor de 173
       - Que no termine en cero
       - Y por supuesto, que incluya el 73
     */
    public void crear_Lista_Sheldon(){
        String numChar;
        char   ult_digito;

        for(int i=38; i<173; i++){

            if(i%2 == 0){ //si cumple que es par
                //comprobar que NO termina en cero
                numChar = i + "";
                //System.out.println("Numero a comprobar acaba en 0: " + numChar);
                ult_digito = numChar.charAt((numChar.length()-1) );   //divisor de 10                 

                if (ult_digito != '0'){
                    //System.out.println("Último dígito: " + ult_digito);
                    this.lista_Sheldon.add(i);
                }
            }else{
                if(i == 73){  //si es este numero incluir en la lista
                    //System.out.println("Añadir: " + i);
                    this.lista_Sheldon.add(i);
                }
            }
        }

    }

    //ver si un numero está dentro de la lista Sheldon
    public String numero_Valido(int numero){
        
        if(this.lista_Sheldon.contains(numero)){  //probar con equals
            return "El numero " + numero + ", se incluye en la lista Sheldon";
        }else{
            return "El numero " + numero + ", no se incluye en la lista Sheldon";
        }   
        
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Lista de numeros de Sheldon='" + getLista_Sheldon() ;
    }




    
}
