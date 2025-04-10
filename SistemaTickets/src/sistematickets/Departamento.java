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

public class Departamento {
    private String idDepartamento;
    private String nombre;
    private String descripcion;
    private ArrayList<String> tecnicosAsignados;

    // Constructor
    public Departamento(String idDepartamento, String nombre, String descripcion) {
       if (idDepartamento == null || idDepartamento.isEmpty() || idDepartamento.length() < 3) {
            throw new IllegalArgumentException("El ID  del departamento debe tener al menos 3 caracteres.");
        }
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre del departamento debe tener al menos 3 caracteres.");
        }
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tecnicosAsignados = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getIdDepartamento() {
        return idDepartamento;
    }
    
    public void setIdDepartamento(String idDepartamento) {    
         if (idDepartamento == null || idDepartamento.isEmpty() || idDepartamento.length() < 3) {
            throw new IllegalArgumentException("El ID  del departamento debe tener al menos 3 caracteres.");
        }
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre del departamento debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getTecnicosAsignados() {
        return tecnicosAsignados;
    }

    public void agregarTecnico(String tecnico) {
        if (tecnico == null || tecnico.isEmpty()) {
            throw new IllegalArgumentException("El técnico no puede estar vacío.");
        }
        this.tecnicosAsignados.add(tecnico);
    }
}

