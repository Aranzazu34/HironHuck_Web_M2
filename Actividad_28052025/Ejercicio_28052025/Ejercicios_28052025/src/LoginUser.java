import java.util.Scanner;

public class LoginUser {
    private String usuario;
    private final String clave; //constante para cada usuario (no se puede cambiar una vez creada, y se crea al hacer new LogInUser() y 
                                //pasarle los parámetros).
    private boolean bloqueado;

//Condición: el usuario debe introducir la clave correcta en maximo 3 intentos, si hace tres, el boolean bloqueado queda como TRUE y no funciona 
//más el método, (solo para decirle que ha hecho demasiados intentos y el acceso está bloqueado)

    //constructores

    //PORQUÉ ME DA ERROR!!! 
    //public LoginUser() {        
    //}


    public LoginUser(String usuario, String clave, boolean bloqueado) {
        this.usuario = usuario;
        this.clave = clave; 
        this.bloqueado = bloqueado;
    }

    //GETTER y SETTERS

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }
    
    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    //métodos

    //Crear la contraseña de máximo 10
    public void comprobarLoginUser(Scanner tc){
        String salir = "n";

        while(salir == "n"){
            System.out.println("Introducir Usuario:");
            String user = tc.nextLine();
            System.out.println();

            if (user.equalsIgnoreCase(this.usuario)){
                int i=0; //intentos de introducir la contraseña, hasta 3
                int veces=0;
                String pswd;

                //maximo 3 intentos, si hace tres, el boolean bloqueado queda como TRUE
                do{
                    System.out.println("Introducir Clave (longitud máx 10):");
                    pswd = tc.nextLine();
                    System.out.println();

                    if (pswd.length() > 10) {
                        System.out.println("Has de introducir Clave hasta 10 caracteres\n");
                        i += 1;
                    }else{
                        if (pswd.equals(this.clave)){
                            veces = i;  //para saber en que momento acertó                            
                            i = 5;
                        }else{
                            System.out.println("Contraseña incorrecta\n");
                            i += 1;
                        }
                    }
                    
                    System.out.println("veces: " +veces);
                    System.out.println("i: " +i);

                }while(i<3);
                
                if(veces==0){
                    this.bloqueado = true;
                    System.out.println("El usuario queda bloqueado después de realizar los 3 intentos."); 
                }else{
                    System.out.printf("Acceso correcto! (intento %dº)", (veces+1));
                }

                System.out.println();
                salir = "s";

            }else{
                System.out.printf("El usuario %s, no existe\n", user);
                System.out.println("Quiere volver a introducir el nombre de usuario? (s/n)\n");
                salir = tc.nextLine().toLowerCase();
                
                //es lo contrario a la condición del bucle!!!
                switch (salir) {
                    case "s":
                        salir = "n";
                        break;
                    case "n":
                        salir = "s";
                        break;                
                    default:
                        break;
                }
            }
        }
    
    }


    //TOSTRING

    @Override
    public String toString() {
        return "usuario = " + getUsuario() + 
            ", clave = " + getClave() +
            ", bloqueado = " + (isBloqueado() ? "Sí" : "No" );
    }




    
}
