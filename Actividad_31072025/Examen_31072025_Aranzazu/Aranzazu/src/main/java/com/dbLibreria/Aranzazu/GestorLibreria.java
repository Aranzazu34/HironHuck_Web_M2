package com.dbLibreria.Aranzazu;

import java.sql.*;
import java.util.Scanner;

public class GestorLibreria {

    public void gestorLibreria() {

        // aquí irán todas las consultas mySQL
        // try intentará hacer la conexión y las consultas
        try {
            // 1. Cargar el driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Crear objeto de conexión que conecte con esa BD específica:
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dblibreria", "root", "");

            // 3. Crear objeto Statement para las consultas:
            Statement stat1 = con1.createStatement(); // crea objeto para consultas en esa conexión
            System.out.println("*** conexión realizada! ***");

            // 4. Ya podemos hacer las consultas usando stat1:

            /**
            5-(1 pto) JDBC: usa tu propia plantilla JDBC o la que te pase el profesor. Realiza una consulta para ver todos 
                            los titulos y los autores de todos los libros desde un statement normal directo. 
                            
                            Del tipo: ResultSet resultado1 = stat1.executeQuery(“SELECT * FROM juegos”);
            **/

            //campos libros: id_libro, titulo, autor, anio_publicacion, id_cliente
            System.out.println("*** LISTADO DE LIBROS --> TÍTULO Y AUTOR ***");

            ResultSet resultado1 = stat1.executeQuery("SELECT * FROM libros order by titulo"); // debemos poner cada vez

            //campos libros: id_libro, titulo, autor, anio_publicacion, id_cliente
            while (resultado1.next()) {
                System.out.println( "- " +resultado1.getString("titulo") + ", autor: " + 
                                    resultado1.getString("autor") );
            }            

            
            //
            //


            /**
            6- (1 pto) JDBC. Sobre esa misma plantilla, realiza un insert con un PreparedStatement para registrar una 
                             nueva  la en en la tabla Clientes. Veri ca que aparece el nuevo cliente en la base de datos. 
                             
                             Del tipo: String insert3 = “INSERT INTO juegos(juegoname, anio) VALUES(?, ?)”;            
            **/

            // campos clientes: id_cliente, nombre, email
  
            //  Con PreparedStatement:

            // ****** incluir los datos con variables ******* //
            Scanner sc = new Scanner(System.in);            

            // mejor usar PreparedStatement, que va con los interrogantes (?)
            String insert3 = "INSERT INTO clientes(nombre, email) VALUES(?, ?)";
            PreparedStatement ps = con1.prepareStatement(insert3); // ahí preparadito
            boolean salir=false;
            String nombre = "";
            String email = "";

            //while (!nombre.equalsIgnoreCase("salir")) {
            while (!salir) {
                    System.out.println("Nombre de Cliente (poner salir para no continuar):");
                    nombre = sc.nextLine();

                    if (!nombre.equalsIgnoreCase("salir")) {

                        System.out.println("E-mail:");
                        email = sc.nextLine();

                        ps.setString(1, nombre); // qué hay en el interrogante 1
                        ps.setString(2, email); // qué hay en el interrogante 2                      

                        ps.executeUpdate(); 

                        System.out.println("*** Cliente añadido! ***");
                    }else{
                        salir = true;
                    }
            }

            //
            //

            //mostrar la lista de clientes para ver el/los último/s añadido/s
            System.out.println("*** LISTADO DE CLIENTES FINAL ***");

            ResultSet resultado2 = stat1.executeQuery("SELECT * FROM clientes");

            // campos clientes: id_cliente, nombre, email
            while (resultado2.next()) {
                System.out.println( "Id Cliente: " + resultado2.getInt("id_cliente") + 
                                    " Nombre: " + resultado2.getString("nombre") + 
                                    " E-mail: " + resultado2.getString("email")  );
            }            

            //
            //

            sc.close();

        } catch (Exception e) {
            System.out.println(" *** algo no funciona :-( ***");
            e.printStackTrace();
        }

    }    

}
