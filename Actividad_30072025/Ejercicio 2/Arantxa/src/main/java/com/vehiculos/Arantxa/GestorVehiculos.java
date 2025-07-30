package com.vehiculos.Arantxa;

import java.sql.*;
import java.util.Scanner;

public class GestorVehiculos {

    public void gestorVehiculos() {
        // aquí irán todas las consultas mySQL
        // try intentará hacer la conexión y las consultas
        try {
            // 1. Cargar el driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Crear objeto de conexión que conecte con esa BD específica:
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbvehiculos", "root", "");

            // 3. Crear objeto Statement para las consultas:
            Statement stat1 = con1.createStatement(); // crea objeto para consultas en esa conexión
            System.out.println("*** conexión realizada! ***");

            // 4. Ya podemos hacer las consultas usando stat1:

            // contenido de la tabla VEHICULOS, que es ResultSet:
            ResultSet resultado1 = stat1.executeQuery("SELECT * FROM vehiculos");
            // System.out.println(resultado1); //solo imprime la dirección de memoria, no el
            // contenido!

            //
            //
  
            // INSERCIÓN VEHÍCULO
            String insert1 = "INSERT INTO vehiculos(marca, id_mecanico) VALUES('Mercedes', 3)";
            stat1.executeUpdate(insert1);
            System.out.println("*** vehiculo añadido! ***");

            //
            //

            System.out.println("*** LISTADO DE VEHICULOS ***");

            ResultSet resultado3 = stat1.executeQuery("SELECT * FROM vehiculos"); // debemos poner cada vez

            // id_vehiculo, marca, modelo, anio_fabricacion, id_mecanico
            // a de aparecer el último vehículo añadido 'Mercedes'
            while (resultado3.next()) {
                System.out.println("id_vehiculo: " + resultado3.getInt("id_vehiculo") + ": " + 
                                                     resultado3.getString("marca") + ": " + 
                                                     resultado3.getString("modelo")
                        + ", Año Fabricación: " + resultado3.getInt("anio_fabricacion"));
            }            

            //
            //

            // contenido de la tabla MECANICOS, que es ResultSet:
            ResultSet resultado2 = stat1.executeQuery("SELECT * FROM mecanicos");
            // System.out.println(resultado1); //solo imprime la dirección de memoria, no el
            // contenido!
            System.out.println("*** LISTADO DE MECÁNICOS ***");

            // id_mecanico, nombre, especialidad
            while (resultado2.next()) {
                System.out.println( "nombre: " + resultado2.getString("nombre") 
                        + ", especialidad: " + resultado2.getString("especialidad"));
            }

            //
            //

 
            /** para UPDATES:
            String update1 = "UPDATE juegos SET juegoname = 'Mario Kart' WHERE id = 7";
            stat1.executeUpdate(update1);
            System.out.println("*** juego modificado! ***");

            // para DELETES:
            String delete1 = "DELETE from juegos WHERE id= 7";
            stat1.executeUpdate(delete1);
            **/

            //
            //

            //  Con PreparedStatement:

            //
            //

            // ****** incluir los datos con variables ******* //
            Scanner sc = new Scanner(System.in);            

            // mejor usar PreparedStatement, que va con los interrogantes (?)
            String actualizar2 = "UPDATE vehiculos SET anio_fabricacion = ? WHERE id_vehiculo = ?";
            PreparedStatement ps = con1.prepareStatement(actualizar2); // ahí preparadito
            String salir="";
            int anio = 0;
            int id = 0;

            while (!salir.equalsIgnoreCase("salir")) {
                System.out.println("Si no se quiere continuar con el UPDATE, poner 'salir:'");
                salir = sc.nextLine();
                
                if (!salir.equalsIgnoreCase("salir")) {
                    System.out.println("Escribe el año de fabricación:");
                    anio = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    System.out.println("Escribe el id del vehiculo:");
                    id = sc.nextInt();
                    sc.nextLine(); // limpiar buffer                    

                    ps.setInt(1, anio); // qué hay en el interrogante 1
                    ps.setInt(2, id); // qué hay en el interrogante 2                      

                    ps.executeUpdate(); 

                    System.out.println("*** vehículo actualizado! ***");
                }
            }

            //
            //

            System.out.println("*** LISTADO DE VEHICULOS  FINAL ***");

            ResultSet resultado4 = stat1.executeQuery("SELECT * FROM vehiculos");

            // id_vehiculo, marca, modelo, anio_fabricacion, id_mecanico
            // a de aparecer el último vehículo añadido 'Mercedes'
            while (resultado4.next()) {
                System.out.println("id_vehiculo: " + resultado4.getInt("id_vehiculo") + ": " + 
                                                     resultado4.getString("marca") + ": " + 
                                                     resultado4.getString("modelo")
                        + ", Año Fabricación: " + resultado4.getInt("anio_fabricacion"));
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
