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
     private int idEstado;
    private String nombre;
    private String descripcion;
    private boolean estadoFinal;
    private ArrayList<String> estadosPermitidos;

    // Constructor
    public Estado(int idEstado,String nombre, String descripcion, boolean estadoFinal) {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre del estado debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoFinal = estadoFinal;
          this.estadosPermitidos = new ArrayList<>();
    }
    // Constructor alternativo SIN ID (para nuevos estados)
    public Estado(String nombre, String descripcion, boolean estadoFinal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoFinal = estadoFinal;
    }
    
    public int getIdEstado() {
        return idEstado;
    }

    // Getters y Setters
    public void setIdEstado(int idEstado) {    
        this.idEstado = idEstado;
    }

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

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
        
    }
    public ArrayList<String> getEstadosPermitidos() {
        return estadosPermitidos;
    }

    public void agregarEstadoPermitido(String estadoPermitido) {
        if (estadoPermitido == null || estadoPermitido.isEmpty()) {
            throw new IllegalArgumentException("El técnico no puede estar vacío.");
        }
        this.estadosPermitidos.add(estadoPermitido);
    }
}
    

