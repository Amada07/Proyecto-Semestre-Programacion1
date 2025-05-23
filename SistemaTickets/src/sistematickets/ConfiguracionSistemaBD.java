/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Amada
 */
public class ConfiguracionSistemaBD {

    // Método para guardar o actualizar la configuración
    public static void guardarConfiguracion(ConfiguracionSistema config) {
        String query = """
            INSERT INTO configuracion_sistema (nombre_empresa, idioma_predeterminado, zona_horaria, tiempo_vencimiento_inactivos, nivel_prioridad_default)
            VALUES (?, ?, ?, ?, ?)
            ON CONFLICT (id_configuracion)
            DO UPDATE SET
                nombre_empresa = EXCLUDED.nombre_empresa,
                idioma_predeterminado = EXCLUDED.idioma_predeterminado,
                zona_horaria = EXCLUDED.zona_horaria,
                tiempo_vencimiento_inactivos = EXCLUDED.tiempo_vencimiento_inactivos,
                nivel_prioridad_default = EXCLUDED.nivel_prioridad_default;
        """;

        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, config.getNombreEmpresa());
            stmt.setString(2, config.getIdioma());
            stmt.setString(3, config.getZonaHoraria());
            stmt.setInt(4, config.getTiempoVencimiento());
            stmt.setString(5, config.getNivelesPrioridad());

            stmt.executeUpdate();
            System.out.println("Configuración guardada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar la configuración con un ID específico
    public static void actualizarConfiguracion(ConfiguracionSistema config) {
    String query = """
        UPDATE configuracion_sistema SET
            nombre_empresa = ?, idioma_predeterminado = ?, zona_horaria = ?,
            tiempo_vencimiento_inactivos = ?, nivel_prioridad_default = ?
        WHERE id_configuracion = ?
    """;

    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conexion.prepareStatement(query)) {

        stmt.setString(1, config.getNombreEmpresa());
        stmt.setString(2, config.getIdioma());
        stmt.setString(3, config.getZonaHoraria());
        stmt.setInt(4, config.getTiempoVencimiento());
        stmt.setString(5, config.getNivelesPrioridad());
        stmt.setInt(6, config.getIdConfiguracion()); 

        int filas = stmt.executeUpdate();
        if (filas > 0) {
            System.out.println("Configuración actualizada correctamente.");
        } else {
            System.out.println("No se encontró la configuración para actualizar.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Método para cargar la configuración desde la base de datos
public static ConfiguracionSistema cargarConfiguracion(int idConfiguracion) {
    String query = "SELECT * FROM configuracion_sistema WHERE id_configuracion = ?";

    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conexion.prepareStatement(query)) {
        
        stmt.setInt(1, idConfiguracion);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new ConfiguracionSistema(
                rs.getInt("id_configuracion"),
                rs.getString("nombre_empresa"),
                rs.getString("idioma_predeterminado"),
                rs.getString("zona_horaria"),
                rs.getInt("tiempo_vencimiento_inactivos"),
                rs.getString("nivel_prioridad_default")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}


