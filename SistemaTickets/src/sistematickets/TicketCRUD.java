/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
public class TicketCRUD {
    public static void main(String[] args) {
        TicketCRUD ticketCRUD = new TicketCRUD();

        try {
            // Crear un nuevo ticket
            ticketCRUD.crearTicket("Error en sistema", "No se puede acceder", 1, 2, 1, "Alta", "Problema con el sistema de autenticación");
            ticketCRUD.listarTickets();

            // Actualizar un ticket
            ticketCRUD.actualizarTicket(1, "Error crítico", "Actualización del problema", 2, 4, "Media");

            // Eliminar un ticket
            ticketCRUD.eliminarTicket(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearTicket(String titulo, String descripcion, int departamentoId, int estadoId, int tecnicoId, String prioridad, String detalle) {
        // Aquí implementas la lógica real de creación
        System.out.println("Ticket creado:");
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Departamento ID: " + departamentoId);
        System.out.println("Estado ID: " + estadoId);
        System.out.println("Técnico ID: " + tecnicoId);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Detalle: " + detalle);
    }

    private void listarTickets() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void actualizarTicket(int i, String error_crítico, String actualización_del_problema, int i0, int i1, String media) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void eliminarTicket(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
