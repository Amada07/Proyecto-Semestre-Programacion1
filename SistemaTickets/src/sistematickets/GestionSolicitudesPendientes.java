/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amada
 */

public class GestionSolicitudesPendientes {
    private GestionTicket gestionTicket;

    public GestionSolicitudesPendientes(GestionTicket gestionTicket) {
        this.gestionTicket = gestionTicket;
    }

    // Filtrar solicitudes pendientes por estado
    public List<Ticket> filtrarPorEstado(String estado) {
        List<Ticket> pendientes = new ArrayList<>();
        for (Ticket ticket : gestionTicket.listarTickets()) {
            if (ticket.getEstado().equalsIgnoreCase(estado)) {
                pendientes.add(ticket);
            }
        }
        return pendientes;
    }

    // Filtrar solicitudes por prioridad
    public List<Ticket> filtrarPorPrioridad(String prioridad) {
        List<Ticket> resultados = new ArrayList<>();
        for (Ticket ticket : gestionTicket.listarTickets()) {
            if (ticket.getPrioridad().equalsIgnoreCase(prioridad)) {
                resultados.add(ticket);
            }
        }
        return resultados;
    }
}

