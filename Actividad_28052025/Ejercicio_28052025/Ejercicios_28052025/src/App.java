import java.util.ArrayList;
import java.util.Scanner;

public class App {

/*
1- NÚMEROS DE SHELDON

Enhorabuena! Sheldon Cooper te encarga que le hagas un listado de sus números favoritos.


Pero con las siguientes condiciones:

- El número debe ser par

- Ser mayor de 37 y menor de 173

- Que no termine en cero

- Y por supuesto, que incluya el 73

Realiza este LAB mediante el paradigma de la POO. Si no sabes cómo plantearlo, puedes empezar por un enfoque tradicional (programación 
estructurada) y después ver cómo lo pasarías a POO.


2- LOG-IN tres intentos

Crea la clase LogInUser, con las propiedades:

- String usuario

- String clave

- boolean bloqueado

Siendo clave final, es decir constante para cada usuario (no se puede cambiar una vez creada, y se crea al hacer new LogInUser() y pasarle los 
parámetros).

Condición: el usuario debe introducir la clave correcta en maximo 3 intentos, si hace tres, el boolean bloqueado queda como TRUE y no funciona 
más el método, (solo para decirle que ha hecho demasiados intentos y el acceso está bloqueado)
 */

    public static void main(String[] args) throws Exception {
        Scanner tcl =  new Scanner(System.in);        
        
        //Ejercicio 1
        System.out.println("============Ejercicio NUMEROS SHELDON========================");
        ArrayList<Integer> array_nums = new ArrayList<>();
        Sheldon s1 = new Sheldon(array_nums);

        //en el propio constructor con parámetros: s1.crear_Lista_Sheldon();
        System.out.println(s1.toString());
        System.out.println();

        //Comprobar a decir varios numeros y ver si se encuentran en la lista Sheldon!!!
        int numero;
        int i = 1;

        do{
            System.out.println("Dime un numero del (37 al 173), para ver si es Sheldon!");
            numero = tcl.nextInt();
            tcl.nextLine();

            System.out.println(s1.numero_Valido(numero));
            System.out.println();

            i += 1;

        }while(i < 4);
        

        //Ejercicio 2
        System.out.println("==============Ejercicio LOGIN USER==========================");
        System.out.println("Nombre de usuario:");
        String user = tcl.nextLine();

        System.out.println();
        String passw;

        do{
            System.out.println("Contraseña (longitud máx 10):");
            passw = tcl.nextLine();
            System.out.println();
        }while (passw.length() > 10);
        

        //iniciamos el login de usuario
        LoginUser lu = new LoginUser(user, passw, false);

        System.out.println(lu.toString());

        lu.comprobarLoginUser(tcl);

        tcl.close();
    }
}
