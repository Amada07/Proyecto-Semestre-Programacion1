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

public class GestionTicket {
    private List<Ticket> tickets;

    public GestionTicket() {
        this.tickets = new ArrayList<>();
    }

    // Crear un nuevo ticket
    public void crearTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("El ticket no puede ser nulo.");
        }
        this.tickets.add(ticket);
    }

    // Buscar ticket por número
    public Ticket buscarTicket(int numeroTicket) {
        for (Ticket ticket : tickets) {
            if (ticket.getNumeroTicket() == numeroTicket) {
                return ticket;
            }
        }
        throw new IllegalArgumentException("No se encontró un ticket con el número: " + numeroTicket);
    }

    // Listar todos los tickets
    public List<Ticket> listarTickets() {
        return tickets;
    }

    // Modificar un ticket existente
    public void modificarTicket(int numeroTicket, String nuevoEstado, String nuevaDescripcion) {
        Ticket ticket = buscarTicket(numeroTicket);
        ticket.setEstado(nuevoEstado);
        ticket.setDescripcion(nuevaDescripcion);
    }

    // Eliminar un ticket
    public void eliminarTicket(int numeroTicket) {
        Ticket ticket = buscarTicket(numeroTicket);
        tickets.remove(ticket);
    }
}

