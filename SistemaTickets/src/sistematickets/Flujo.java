/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amada
 */

public class Flujo {
    private String nombre;
    private String descripcion;
    private Map<String, String[]> transiciones; // Estado actual -> Estados permitidos

    // Constructor
    public Flujo(String nombre, String descripcion) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del flujo no puede estar vacío.");
        }
        if (descripcion == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("La descripcion del flujo no puede estar vacío.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.transiciones = new HashMap<>();
    }

    // Métodos para definir las transiciones
    public void agregarTransicion(String estadoActual, String[] estadosPermitidos) {
        if (estadoActual == null || estadosPermitidos == null || estadosPermitidos.length == 0) {
            throw new IllegalArgumentException("El estado actual y los estados permitidos no pueden estar vacíos.");
        }
        this.transiciones.put(estadoActual, estadosPermitidos);
    }

    public String[] obtenerEstadosPermitidos(String estadoActual) {
        return this.transiciones.getOrDefault(estadoActual, new String[]{});
    }
}

