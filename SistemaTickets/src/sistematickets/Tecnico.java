/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
public class Tecnico extends Persona {
    private String departamento;
    
    public Tecnico(String nombreCompleto,String nombreUsuario,String email,String contraseña,String departamento){
        super(nombreCompleto, nombreUsuario,email,contraseña);
        this.departamento=departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void mostrarDetalles() {
         System.out.println("Técnico: " + getNombreCompleto() + ", Departamento: " + departamento);
    }
    
    
}
