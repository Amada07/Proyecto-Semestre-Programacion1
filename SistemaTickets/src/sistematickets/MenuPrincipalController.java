/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author Amada
 */

public class MenuPrincipalController implements Initializable {

    @FXML private Tab tabConfigSistema;
    @FXML private Tab tabRegistrarUsuarios;
    @FXML private Tab tabRolesPermisos;
    @FXML private Tab tabTickets;
    @FXML private Tab tabDepartamentos;
    @FXML private Tab tabEstados;
    @FXML private Tab tabFlujos;  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void ajustarTabsPorRol(String tipoUsuario) {
        if ("Administrador".equals(tipoUsuario)) {
            tabConfigSistema.setDisable(false);
            tabRegistrarUsuarios.setDisable(false);
            tabRolesPermisos.setDisable(false);
            tabTickets.setDisable(false);
            tabDepartamentos.setDisable(false);
            tabEstados.setDisable(false);
            tabFlujos.setDisable(false);
        } else if ("Tecnico".equals(tipoUsuario)) {
            tabConfigSistema.setDisable(true);
            tabRegistrarUsuarios.setDisable(true);
            tabRolesPermisos.setDisable(true);
            tabTickets.setDisable(false);
            tabDepartamentos.setDisable(true);
            tabEstados.setDisable(false);
            tabFlujos.setDisable(true);
        } else if ("Usuario".equals(tipoUsuario)) {
            tabConfigSistema.setDisable(true);
            tabRegistrarUsuarios.setDisable(true);
            tabRolesPermisos.setDisable(true);
            tabTickets.setDisable(false);
            tabDepartamentos.setDisable(true);
            tabEstados.setDisable(false);
            tabFlujos.setDisable(true);
        }
    }
}

