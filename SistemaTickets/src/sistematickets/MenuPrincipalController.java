/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
    //Campos de la interfaz para roles y permisos
    @FXML private TextField txtNombreRol;
    @FXML private TextArea txtDescripcionRol;
    @FXML private TableView<String> tablaRoles;
    
    
    //Colocamos el controlador de roles y permisos
    private GestionRolesPermisosController gestor; 
    
    
    private ConfiguracionSistemaController configurarSistemaController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Aqui inicializamos el controlador de roles y permisos
       gestor=new GestionRolesPermisosController();
       //Podemos pasar el rol de usuario actual 
       ajustarTabsPorRol(""); 
      //Cargar roles al iniciar 
      actualizarTablaRoles();
       
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
     
    
    //Manejamos el boton "Crear Rol"
     @FXML private void crearRol(){
      String nombre = txtNombreRol.getText();
        String descripcion = txtDescripcionRol.getText();

        if (nombre.length() >= 3 && nombre.length() <= 50) {
            boolean exito = gestor.crearRol(nombre, descripcion);
            if (exito) {
                System.out.println("Rol creado exitosamente");
                actualizarTablaRoles(); // Actualiza la tabla después de crear   
          } else {
                mostrarAlerta("Error", "No se pudo crear el rol. Verifica los datos.");
            }
        } else {
            mostrarAlerta("Error de Validación", "El nombre del rol debe tener entre 3 y 50 caracteres.");
        }
    }
     
    // Actualiza la tabla de roles con los datos desde la base de datos
    private void actualizarTablaRoles() {
        List<String> roles = gestor.obtenerRoles();
        tablaRoles.getItems().clear();
        tablaRoles.getItems().addAll(roles);
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
 
   
     


