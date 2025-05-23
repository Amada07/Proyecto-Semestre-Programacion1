/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
    public class Rol {
    private int idRol;
    private String nombre;
    private String descripcion;

    public Rol(int idRol, String nombre, String descripcion) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdRol() { return idRol; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}


