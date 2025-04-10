/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
public class Usuario extends Persona {
    public Usuario(String nombreCompleto,String nombreUsuario,String email,String contraseña){
        super(nombreCompleto,nombreUsuario, email, contraseña);
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("Usuario: " + getNombreCompleto());
    }
}
