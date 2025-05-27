/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amada
 */

public class ConexionDB {
private static final String url = "jdbc:postgresql://ep-crimson-union-a5cd9wkb-pooler.us-east-2.aws.neon.tech:5432/chinook";
private static final String user= "neondb_owner";
private static final String password= "npg_PQlT8bUkJDp0";
 
    public  static Connection obtenerConexion()  {
       Connection conexion = null;
   
        try {
   
          conexion = DriverManager.getConnection(url, user, password);
          System.out.println("Conexion exitosa a la base de datos");
          return conexion;
        } catch (SQLException e) {
        System.out.println("Eror de conexion:"+ e.getMessage());
        }
        return null;
        
        
  

    }
} 
