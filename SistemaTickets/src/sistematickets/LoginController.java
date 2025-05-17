/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amada
 */
public class LoginController implements Initializable {
    
   @FXML
   private ComboBox<String> cmbTipoUsuario;
   
   @FXML
   private TextField txtUsuario;
   
   @FXML
   private PasswordField txtContraseña;
   
   @FXML
   private Button btnIniciarSesion;
   
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    cmbTipoUsuario.getItems().addAll("Administrador","Tecnico","Usuario");
   
    }    
    
    @FXML
   private void iniciarSesion(javafx.event.ActionEvent event){
      System.out.println("Boton Iniciar Sesion presionado");
 
       String tipo = cmbTipoUsuario.getValue();
       String usuario = txtUsuario.getText();
       String contraseña = txtContraseña.getText();
       
       boolean acceso = false;
       if("Administrador".equals(tipo)&& "Amada".equals(usuario)&& "admin".equals(contraseña)){
           acceso = true;
       }else if ("Tecnico".equals(tipo)&& "Pedro".equals(usuario)&& "tec".equals(contraseña)){
           acceso = true;   
       }else if ("Usuario".equals(tipo)&& "Flor".equals(usuario)&& "usuario".equals(contraseña)){
           acceso = true;  
   }
     if (acceso) {
            abrirMenuPrincipal(tipo);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario o Contraseña incorrectos");
            alert.showAndWait();
        }
    }

    private void abrirMenuPrincipal(String tipoUsuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuPrincipal.fxml"));
            Parent root = loader.load();
            
      // se configura el controlador con el tipo de usuario
            MenuPrincipalController controller = loader.getController();
            controller.ajustarTabsPorRol(tipoUsuario);

            
           //se un stage para que abra la ventana del Menu Principal
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Menú Principal - " + tipoUsuario);
        stage.show();
           
            // Cierra la ventana de login
            ((Stage) btnIniciarSesion.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
