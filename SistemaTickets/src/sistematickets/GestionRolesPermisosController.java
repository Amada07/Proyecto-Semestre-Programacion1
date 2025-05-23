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
    
    // Metodo para obteber el ID de un rol por su nombre
    public int obtenerIdRolPorNombre(String nombreRol) {
        String sql = "SELECT id_rol FROM rol WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreRol);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_rol");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de rol: " + e.getMessage());
        }
        return -1;
    }

    // Método para obtener el ID de un permiso por su nombre
    public int obtenerIdPermisoPorNombre(String nombrePermiso) {
        String sql = "SELECT id_permiso FROM permiso WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombrePermiso);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_permiso");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de permiso: " + e.getMessage());
        }
        return -1;
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
 public boolean asignarPermisoARol(int idRol, int idPermiso, String usuarioModificador) {
    // Asegurar que la tabla `rol_permiso` existe antes de insertar
  

    String sql = "INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (?, ?)";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idRol);
        stmt.setInt(2, idPermiso);
        stmt.executeUpdate();
        registrarCambio("Asignación de permiso", usuarioModificador);
        return true;
    } catch (SQLException e) {
        System.out.println("Error al asignar permiso: " + e.getMessage());
        return false;
    }
 } 
   // Método para crear la tabla `rol_permiso` si no existe
    private void crearTablaRolPermiso() {
    String sql = """
        CREATE TABLE IF NOT EXISTS rol_permiso (
            id_rol INT REFERENCES rol(id_rol),
            id_permiso INT REFERENCES permiso(id_permiso),
            PRIMARY KEY (id_rol, id_permiso)
        )
    """;
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.executeUpdate();
        System.out.println("Tabla rol_permiso creada correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al crear la tabla rol_permiso: " + e.getMessage());
    }
}

// Método para eliminar un rol
public boolean eliminarRol(int idRol) {
    String sql = "DELETE FROM rol WHERE id_rol = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idRol);
        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar rol: " + e.getMessage());
        return false;
    }
}

// Método para eliminar un permiso
public boolean eliminarPermiso(int idPermiso) {
    String sql = "DELETE FROM permiso WHERE id_permiso = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idPermiso);
        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar permiso: " + e.getMessage());
        return false;
    }
}
public boolean eliminarRelacionRolPermisoIndividual(int idRol, int idPermiso) {
    String sql = "DELETE FROM rol_permiso WHERE id_rol = ? AND id_permiso = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idRol);
        stmt.setInt(2, idPermiso);
        int filasEliminadas = stmt.executeUpdate();
        return filasEliminadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar relación rol-permiso: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

   //Para obtener todos los roles 
 public List<Rol> obtenerRoles() {
    List<Rol> roles = new ArrayList<>();
    String sql = "SELECT id_rol, nombre, descripcion FROM rol";
    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            roles.add(new Rol(rs.getInt("id_rol"), rs.getString("nombre"), rs.getString("descripcion")));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener roles: " + e.getMessage());
    }
    return roles;
}

   
   // Método para obtener todos los permisos disponibles
   public List<Permiso> obtenerTodosLosPermisos() {
    List<Permiso> permisos = new ArrayList<>();
    String sql = "SELECT id_permiso, nombre, descripcion FROM permiso";
    try (PreparedStatement stmt = conexion.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            permisos.add(new Permiso(rs.getInt("id_permiso"), rs.getString("nombre"), rs.getString("descripcion")));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener permisos: " + e.getMessage());
    }
    return permisos;
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
   // Método para registrar cambios en la base de datos
    private void registrarCambio(String accion, String usuario) {
        String sql = "INSERT INTO historial_cambios (accion, usuario, fecha) VALUES (?, ?, NOW())";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, accion);
            stmt.setString(2, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar cambio: " + e.getMessage());
        }
    }
   public Rol obtenerRolPorId(int idRol) {
    String sql = "SELECT id_rol, nombre, descripcion FROM rol WHERE id_rol = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idRol);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Rol(rs.getInt("id_rol"), rs.getString("nombre"), rs.getString("descripcion"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el rol por ID: " + e.getMessage());
    }
    return null; // Retorna null si no encuentra el rol
}
public Permiso obtenerPermisoPorId(int idPermiso) {
    String sql = "SELECT id_permiso, nombre, descripcion FROM permiso WHERE id_permiso = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setInt(1, idPermiso);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Permiso(rs.getInt("id_permiso"), rs.getString("nombre"), rs.getString("descripcion"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el permiso por ID: " + e.getMessage());
    }
    return null; 
}
public boolean actualizarRol(int idRol, String nuevoNombre, String nuevaDescripcion) {
    String sql = "UPDATE rol SET nombre = ?, descripcion = ? WHERE id_rol = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nuevoNombre);
        stmt.setString(2, nuevaDescripcion);
        stmt.setInt(3, idRol);
        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar el rol: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
public boolean actualizarPermiso(int idPermiso, String nuevoNombre, String nuevaDescripcion) {
    String sql = "UPDATE permiso SET nombre = ?, descripcion = ? WHERE id_permiso = ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, nuevoNombre);
        stmt.setString(2, nuevaDescripcion);
        stmt.setInt(3, idPermiso);
        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al actualizar el permiso: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

}
   
  


