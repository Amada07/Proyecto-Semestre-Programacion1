/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;
        
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Amada
 */
public class TicketCRUD {
    public static void main(String[] args) {
        TicketCRUD ticketCRUD = new TicketCRUD();

        try {
            // Crear un nuevo ticket
            Ticket nuevoTicket = new Ticket(1, "Usuario", "Error grave", "IT", "Alta");
            ticketCRUD.crearTicket(nuevoTicket);

            // Actualizar un ticket
            ticketCRUD.actualizarTicket(1, "Error crítico", "Actualización del problema", 2, 4, "Media");

            // Eliminar un ticket
            ticketCRUD.eliminarTicket(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crearTicket(Ticket ticket) throws SQLException {
    String query = "INSERT INTO ticket (descripcion, estado, nivel_prioridad, fecha_creacion) VALUES (?, ?, ?, ?)";
    try (Connection conexion = (Connection) ConexionDB.obtenerConexion();
        PreparedStatement stmt = conexion.prepareStatement(query)) {
        stmt.setString(1, ticket.getDescripcion());
        stmt.setString(2, ticket.getEstado());
        stmt.setString(3, ticket.getPrioridad());
        stmt.setDate(4, new java.sql.Date(ticket.getFechaCreacion().getTime()));
        stmt.executeUpdate();
        System.out.println("Ticket creado en la base de datos.");
    }
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
    
     public static void actualizarEstadoTicket(int numeroTicket, String nuevoEstado) {
    String query = "UPDATE tickets SET estado = ? WHERE id = ?";

    try (Connection conexion = ConexionDB.obtenerConexion();
         PreparedStatement stmt = conexion.prepareStatement(query)) {

        stmt.setString(1, nuevoEstado);
        stmt.setInt(2, numeroTicket);
        stmt.executeUpdate();

        System.out.println("Estado del ticket actualizado.");
    } catch (SQLException e) {
        System.err.println("Error al actualizar estado del ticket: " + e.getMessage());
     }
    }
    public static List<Ticket> obtenerTicketsPendientes() {
    List<Ticket> lista = new ArrayList<>();
    try {
        Connection conexion = ConexionDB.obtenerConexion();
        String sql = "SELECT * FROM tickets WHERE estado = 'Pendiente'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ticket ticket = new Ticket(
                rs.getInt("numeroTicket"),
                rs.getString("solicitante"),
                rs.getString("descripcion"),
                rs.getString("departamento"),
                rs.getString("prioridad")
            );
            //  Agregar las otras propiedades
            ticket.setEstado(rs.getString("estado"));
            ticket.setTecnicoAsignado(rs.getString("tecnicoAsignado"));
            // Agrega a la lista
            lista.add(ticket);
        }
        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
 }
}
 

       
    



