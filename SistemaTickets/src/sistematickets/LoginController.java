/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Amada
 */
public class LoginController implements Initializable {
    
   @FXML
   private ComboBox<String> cmbTipoUsuario;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    cmbTipoUsuario.getItems().addAll("Administrador","Tecnico","Usuario");
    }    
    
}
