/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

/**
 *
 * @author Amada
 */
   public class Permiso {
    private int idPermiso;
    private String nombre;
    private String descripcion;

    public Permiso(int idPermiso, String nombre, String descripcion) {
        this.idPermiso = idPermiso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdPermiso() { return idPermiso; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
 
