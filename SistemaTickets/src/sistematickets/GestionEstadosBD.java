/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


    

/**
 *
 * @author Amada
 */
public class GestionEstadosBD {

    private Connection conexion; 

    public GestionEstadosBD() {
        this.conexion = ConexionDB.obtenerConexion(); 
    }

    // Crear estado en la BD
   public boolean crearEstado(String nombre, String descripcion, boolean estadoFinal, String estadosPermitidos) {
    String sql = "INSERT INTO estado_ticket (nombre, descripcion, estado_final, estados_permitidos_siguientes) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setBoolean(3, estadoFinal);
        stmt.setString(4, estadosPermitidos);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al crear estado: " + e.getMessage());
        return false;
    }
}


    // Actualizar estado en la BD
    public boolean actualizarEstado(int idEstado, String nombre, String descripcion, boolean estadoFinal, String estadosPermitidos) {
    String sql = "UPDATE estado_ticket SET nombre = ?, descripcion = ?, estado_final = ?, estados_permitidos_siguientes = ? WHERE id_estado = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setBoolean(3, estadoFinal);
        stmt.setString(4, estadosPermitidos);
        stmt.setInt(5, idEstado);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar estado: " + e.getMessage());
        return false;
    }
}


    // Obtener estado por ID
   public Estado obtenerEstadoPorId(int idEstado) {
    String sql = "SELECT * FROM estado_ticket WHERE id_estado = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idEstado);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Estado(
                rs.getInt("id_estado"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getBoolean("estado_final")
            );
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener estado: " + e.getMessage());
    }
    return null;
}

public List<Estado> obtenerTodosLosEstados() {
    List<Estado> estados = new ArrayList<>();
    String sql = "SELECT * FROM estado_ticket";
    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
           estados.add(new Estado(
    rs.getInt("id_estado"), 
    rs.getString("nombre"),
    rs.getString("descripcion"),
    rs.getBoolean("estado_final")
));

        }
    } catch (SQLException e) {
        System.out.println("Error al obtener estados: " + e.getMessage());
    }
    return estados;
}

    // Eliminar estado
    public boolean eliminarEstado(int idEstado) {
        String sql = "DELETE FROM estado_ticket WHERE id_estado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEstado);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar estado: " + e.getMessage());
            return false;
        }
    }
}
