/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amada
 */

   
public class Ticket {
    private int numeroTicket;
    private String solicitante;
    private String descripcion;
    private String departamento;
    private String estado; // Pendiente, En Proceso, Cerrado
    private String prioridad; // Alta, Media, Baja
    private ArrayList<String> notas; // Historial de notas
    private Date fechaCreacion;
    private String tecnicoAsignado;

    // Constructor
    public Ticket(int numeroTicket, String solicitante, String descripcion, String departamento, String prioridad) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción del ticket no puede estar vacía.");
        }
        if (prioridad == null || (!prioridad.equals("Alta") && !prioridad.equals("Media") && !prioridad.equals("Baja"))) {
            throw new IllegalArgumentException("La prioridad debe ser Alta, Media o Baja.");
        }

        this.numeroTicket = numeroTicket;
        this.solicitante = solicitante;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.estado = "Pendiente"; // Estado inicial
        this.prioridad = prioridad;
        this.notas = new ArrayList<>();
        this.fechaCreacion = new Date(); // Fecha actual
    }

    // Getters y Setters
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        if (!prioridad.equals("Alta") && !prioridad.equals("Media") && !prioridad.equals("Baja")) {
            throw new IllegalArgumentException("La prioridad debe ser Alta, Media o Baja.");
        }
        this.prioridad = prioridad;
    }

    public void agregarNota(String nota) {
        if (nota == null || nota.isEmpty()) {
            throw new IllegalArgumentException("La nota no puede estar vacía.");
        }
        this.notas.add(nota);
    }

    public ArrayList<String> getNotas() {
        return notas;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(String tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }
}

