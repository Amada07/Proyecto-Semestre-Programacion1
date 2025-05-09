/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Amada
 */
public class colaTickets {
   private ConcurrentLinkedQueue<Ticket> cola;
   
   public colaTickets() {
        this.cola = new ConcurrentLinkedQueue<>();
    }

    // Agregar ticket a la cola y sincronizar con la base de datos
    public synchronized void agregarTicket(Ticket ticket) {
        if (ticket != null) {
            cola.add(ticket);
            sincronizarConBaseDeDatos(ticket, "agregar");
            System.out.println("Ticket agregado: " + ticket.getNumeroTicket());
        } else {
            throw new IllegalArgumentException("El ticket no puede ser nulo.");
        }
    }

    // Atender ticket (remover el primer ticket de la cola) y sincronizar con base de datos
    public synchronized Ticket atenderTicket() {
        Ticket ticketAtendido = cola.poll();
        if (ticketAtendido != null) {
            sincronizarConBaseDeDatos(ticketAtendido, "atender");
            System.out.println("Ticket atendido: " + ticketAtendido.getNumeroTicket());
        } else {
            System.out.println("No hay tickets en la cola.");
        }
        return ticketAtendido;
    }

    // Sincronizar con la base de datos según la operación
    private void sincronizarConBaseDeDatos(Ticket ticket, String operacion) {
        try {
            if ("agregar".equals(operacion)) {
                // Llamar al método crearTicket de TicketCRUD
                TicketCRUD.crearTicket(ticket);
            } else if ("atender".equals(operacion)) {
                // Actualizar el estado del ticket en la base de datos
                TicketCRUD.actualizarEstadoTicket(ticket.getNumeroTicket(), "Atendido");
            }
        } catch (Exception e) {
            System.err.println("Error al sincronizar con la base de datos: " + e.getMessage());
        }
    }

    // Mostrar todos los tickets en la cola
    public void mostrarTickets() {
        if (!cola.isEmpty()) {
            System.out.println("Tickets en la cola:");
            for (Ticket ticket : cola) {
                System.out.println("Ticket ID: " + ticket.getNumeroTicket() + ", Descripción: " + ticket.getDescripcion());
            }
        } else {
            System.out.println("La cola de tickets está vacía.");
        }
    }

    // Cargar tickets pendientes desde la base de datos al iniciar
    public void cargarTicketsPendientes() {
        try {
            ConcurrentLinkedQueue<Ticket> ticketsPendientes = new ConcurrentLinkedQueue<>(TicketCRUD.obtenerTicketsPendientes());
            cola.addAll(ticketsPendientes);
            System.out.println("Tickets pendientes cargados desde la base de datos.");
        } catch (Exception e) {
            System.err.println("Error al cargar tickets pendientes: " + e.getMessage());
        }
    }
}
    
    

