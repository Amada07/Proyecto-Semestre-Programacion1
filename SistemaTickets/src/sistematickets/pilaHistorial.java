/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedDeque;


/**
 *
 * @author Amada
 */
public class pilaHistorial {
      private ConcurrentLinkedDeque<String> pila;

    public pilaHistorial() {
        this.pila = new ConcurrentLinkedDeque<>();
    }

    // Registrar un cambio en el historial y sincronizar con la base de datos
    public synchronized void registrarCambio(int idTicket, String cambio) {
        if (cambio != null && !cambio.isEmpty()) {
            pila.push(cambio);
            sincronizarConBaseDeDatos(idTicket, cambio);
            System.out.println("Cambio registrado: " + cambio);
        } else {
            throw new IllegalArgumentException("El cambio no puede ser nulo o vacío.");
        }
    }

    // Deshacer el último cambio
    public synchronized String deshacerCambio() {
        if (!pila.isEmpty()) {
            String cambioDeshecho = pila.pop();
            System.out.println("Cambio deshecho: " + cambioDeshecho);
            return cambioDeshecho;
        } else {
            System.out.println("No hay cambios para deshacer.");
            return null;
        }
    }

    // Mostrar el historial de cambios
    public void mostrarHistorial() {
        if (!pila.isEmpty()) {
            System.out.println("Historial de cambios:");
            for (String cambio : pila) {
                System.out.println("Cambio: " + cambio);
            }
        } else {
            System.out.println("El historial de cambios está vacío.");
        }
    }

    // Sincronizar registro de cambios con la base de datos
  private void sincronizarConBaseDeDatos(int idTicket, String cambio) {
    try {
        HistorialCRUD.guardarCambio(idTicket, cambio);
    } catch (SQLException e) {
        System.err.println("Error al guardar cambio en la base de datos: " + e.getMessage());
    }
 }
}