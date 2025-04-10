/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets;

   
/**
 *
 * @author Amada
 */
public abstract class Persona {
   private String nombreCompleto;
   private String nombreUsuario;
   private String email;
   private String contraseña;
   
   //constructor
   public Persona(String nombreCompleto,String nombreUsuario,String email, String contraseña){
       if(nombreCompleto == null || nombreCompleto.isEmpty()|| nombreCompleto.length()<3){
           throw new IllegalArgumentException("El nombre completo debe tener al meno 3 caracteres");
       }
       if (nombreUsuario == null || nombreUsuario.isEmpty()|| nombreUsuario.length()<5){
           throw new IllegalArgumentException("El nombre de usuario debe ser unico y contener al menos 5 caracteres");
           
       }
       if (contraseña== null || !email.contains ("@")){
           throw new IllegalArgumentException("La correo electronico no es valido ");
       }
       if (contraseña == null || contraseña.length()<8){
           throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres ");
       }
       
       this.nombreCompleto= nombreCompleto;
       this.nombreUsuario= nombreUsuario;
       this.email = email;
       this.contraseña = contraseña;
   }
   
   //Getters y Setters 

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
      if(nombreCompleto == null || nombreCompleto.isEmpty() || nombreCompleto.length()<3){
     throw new IllegalArgumentException("El nombre completo debe tener al meno 3 caracteres");
       }
       this.nombreCompleto = nombreCompleto;
     }
        
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
         if (nombreUsuario == null || nombreUsuario.isEmpty()|| nombreUsuario.length()<5){
           throw new IllegalArgumentException("El nombre de usuario debe ser unico y contener al menos 5 caracteres"); 
       }
      this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (contraseña== null || !email.contains ("@")){
           throw new IllegalArgumentException("La correo electronico no es valido ");
       }
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
       if (contraseña == null || contraseña.length()<8){
           throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres ");
       } 
        this.contraseña = contraseña;
    }
   //Metdo Abstracto 
   public abstract void mostrarDetalles();
}
