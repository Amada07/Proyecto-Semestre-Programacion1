/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amada
 */
public class GestionRolesPermisosController {
    
    private Connection conexion;
    
    public GestionRolesPermisosController(){
        this.conexion = ConexionDB.obtenerConexion();
        
    }    
  //Para crear un rol 
  public boolean crearRol(String nombre, String descripcion) {
        String sql = "INSERT INTO rol (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear rol: " + e.getMessage());
            return false;
        }
    }
  
  //Para crear un permiso
  public boolean crearPermiso(String nombre, String descripcion) {
        String sql = "INSERT INTO permiso (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear permiso: " + e.getMessage());
            return false;
        }
  }
        
  //Para asignar permiso a un rol 
   public boolean asignarPermisoARol(int idRol, int idPermiso) {
        String sql = "INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idRol);
            stmt.setInt(2, idPermiso);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al asignar permiso: " + e.getMessage());
            return false;
        }
    }
   
   
   //Para obtener todos los roles 
   public List<String> obtenerRoles() {
        List<String> roles = new ArrayList<>();
        String sql = "SELECT nombre FROM rol";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                roles.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener roles: " + e.getMessage());
        }
        return roles;
    }
   
   //Obtener permisos de un rol 
   public List<String> obtenerPermisosPorRol(int idRol) {
        List<String> permisos = new ArrayList<>();
        String sql = "SELECT p.nombre FROM permiso p " +
                     "JOIN rol_permiso rp ON p.id_permiso = rp.id_permiso " +
                     "WHERE rp.id_rol = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idRol);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                permisos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener permisos: " + e.getMessage());
        }
        return permisos;
    }
}
   
  


