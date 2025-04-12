/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
   public class CambioEstado {
    private GestionTicket gestionTicket;

    public CambioEstado(GestionTicket gestionTicket) {
        this.gestionTicket = gestionTicket;
    }

    // Cambiar el estado de un ticket
    public void cambiarEstado(int numeroTicket, String nuevoEstado) {
        Ticket ticket = gestionTicket.buscarTicket(numeroTicket);
        ticket.setEstado(nuevoEstado);
        System.out.println("Estado del Ticket " + numeroTicket + " cambiado a: " + nuevoEstado);
    }
}