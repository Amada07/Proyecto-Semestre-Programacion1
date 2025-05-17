/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioCRUD {

    // Crear un nuevo usuario
    public void crearUsuario(String nombre, String correo, String contraseña, int rolId, int departamentoId) throws Exception {
        String sql = "INSERT INTO usuario (nombre, correo, contraseña, rol_id, departamento_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contraseña);
            stmt.setInt(4, rolId);
            stmt.setInt(5, departamentoId);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    // Leer usuarios
    public void listarUsuarios() throws Exception {
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") + ", Nombre: " + rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
    }

    // Actualizar usuario
    public void actualizarUsuario(int idUsuario, String nuevoNombre, String nuevoCorreo) throws Exception {
        String sql = "UPDATE usuario SET nombre = ?, correo = ? WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoCorreo);
            stmt.setInt(3, idUsuario);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // Eliminar usuario
    public void eliminarUsuario(int idUsuario) throws Exception {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}