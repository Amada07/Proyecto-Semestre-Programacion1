/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */

 public class GestionNotas {
    private GestionTicket gestionTicket;

    public GestionNotas(GestionTicket gestionTicket) {
        this.gestionTicket = gestionTicket;
    }

    // Agregar una nota a un ticket
    public void agregarNota(int numeroTicket, String nota) {
        Ticket ticket = gestionTicket.buscarTicket(numeroTicket);
        ticket.agregarNota(nota);
    }

    // Obtener las notas de un ticket
    public void mostrarNotas(int numeroTicket) {
        Ticket ticket = gestionTicket.buscarTicket(numeroTicket);
        System.out.println("Notas del Ticket " + numeroTicket + ": ");
        for (String nota : ticket.getNotas()) {
            System.out.println("- " + nota);
        }
    }
}   

