/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.util.ArrayList;

/**
 *
 * @author Amada
 */
public class Estado {
    private String nombre;
    private String descripcion;
    private boolean estadoFinal;
    private ArrayList<String> estadoPermitido;

    // Constructor
    public Estado(String nombre, String descripcion, boolean estadoFinal) {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre del estado debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoFinal = estadoFinal;
        this.estadoPermitido = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre del estado debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isestadoFinal() {
        return estadoFinal;
    }

    public void setestadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
        
    }
    public ArrayList<String> getEstadoPermitido() {
        return estadoPermitido;
    }

    public void agregarestadoPermitido(String estadoPermitido) {
        if (estadoPermitido == null || estadoPermitido.isEmpty()) {
            throw new IllegalArgumentException("El técnico no puede estar vacío.");
        }
        this.estadoPermitido.add(estadoPermitido);
    }
}
    

