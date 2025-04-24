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
private static final String url = "jdbc:postgresql://localhost:5432/sistema_tickets";
private static final String user= "postgres";
private static final String password= "#basededatos721";
 
    public  Connection getConnection() {
        Connection conexion = null;
        try {
          return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        System.out.println("Eror de conexion:"+ e.getMessage());
        }
        return null;
    }
} 
