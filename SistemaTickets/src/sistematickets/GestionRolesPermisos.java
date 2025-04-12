/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Amada
 */

public class GestionRolesPermisos {
    private Map<String, Set<String>> rolesPermisos; // Rol -> Lista de permisos

    public GestionRolesPermisos() {
        this.rolesPermisos = new HashMap<>();
    }

    // Crear un nuevo rol
    public void crearRol(String rol) {
        if (rol == null || rol.isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacío.");
        }
        rolesPermisos.putIfAbsent(rol, new HashSet<>());
    }

    // Asignar permisos a un rol
    public void asignarPermiso(String rol, String permiso) {
        if (!rolesPermisos.containsKey(rol)) {
            throw new IllegalArgumentException("El rol no existe.");
        }
        rolesPermisos.get(rol).add(permiso);
    }

    // Obtener los permisos de un rol
    public Set<String> obtenerPermisos(String rol) {
        if (!rolesPermisos.containsKey(rol)) {
            throw new IllegalArgumentException("El rol no existe.");
        }
        return rolesPermisos.get(rol);
    }

    // Listar todos los roles
    public Set<String> listarRoles() {
        return rolesPermisos.keySet();
    }
}

