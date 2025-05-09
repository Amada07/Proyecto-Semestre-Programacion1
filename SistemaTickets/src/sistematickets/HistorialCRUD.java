/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Amada
 */

public class HistorialCRUD {
   public static void guardarCambio(int idTicket, String cambio) throws SQLException {
    String query = "INSERT INTO Historial (idTicket, cambio) VALUES (?, ?)";
   
    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conexion.prepareStatement(query)) {
    
        stmt.setInt(1, idTicket);
        stmt.setString(2, cambio);
    
        stmt.executeUpdate();
    
        System.out.println("Cambio guardado en el historial.");
    } catch (SQLException e) {
        System.err.println("Error al guardar cambio: " + e.getMessage());
        throw e; // Propagar la excepción si es necesario
    }
 }
}