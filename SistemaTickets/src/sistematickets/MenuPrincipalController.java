/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;




/**
 * FXML Controller class
 *
 * @author Amada
 */
public class MenuPrincipalController implements Initializable {

    // Estas son las pestañas que están en el Menú Principal
    @FXML private Tab tabConfigSistema;
    @FXML private Tab tabRegistrarUsuarios;
    @FXML private Tab tabRolesPermisos;
    @FXML private Tab tabTickets;
    @FXML private Tab tabDepartamentos;
    @FXML private Tab tabEstados;
    @FXML private Tab tabFlujos;

    // Campos de la interfaz para Roles 
    @FXML private TextField txtIdRol;
    @FXML private TextField txtNombreRol;
    @FXML private TextArea txtDescripcionRol;
    @FXML private Button btnLimpiarR;
   @FXML private Button btnEliminarRol;
   @FXML private Button btnBuscarRol;
  @FXML private Button btnBuscarPermiso;
  @FXML private Button btnEliminarRelacion;
   @FXML private Button btnGuardarRol;
   @FXML private Button btnGuardarPermiso;
  
    //Campos para la interfaz de Permisos
    @FXML private TextField txtIdPermiso;
    @FXML private TextField txtNombrePermiso;
    @FXML private TextArea txtDescripcionPermiso;
    @FXML private Button btnLimpiarP;
    @FXML private ComboBox<String> comboRoles;
    @FXML private ComboBox<String> comboPermisos;
    @FXML private Button btnAsignarPermiso;
    @FXML private Button btnCrearPermiso;
    @FXML private Button btnEliminarPermiso;
   
    // Campos de la interfaz Configuración del Sistema
    @FXML private TextField txtIdConfiguracion;
    @FXML private TextField txtNombreEmpresa;
    @FXML private ComboBox<String> comboIdioma;
    @FXML private ComboBox<String> comboZonaHora;
    @FXML private Spinner<Integer> spinnerTiempoVencimiento;
    @FXML private ComboBox<String> comboListaPrioridad;
    @FXML private Button btnGuardar;
     @FXML private Button btnActualizar;
    @FXML private Button btnLimpiar;
    @FXML private Button btnBuscar;

    // Controlador para Roles y Permisos
    private GestionRolesPermisosController gestor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Inicializar controlador de Roles y Permisos
        gestor = new GestionRolesPermisosController();
       
        // Ajustar pestañas según el rol del usuario
        ajustarTabsPorRol("");

        // Cargar roles al iniciar
        cargarRoles();
        cargarPermisos();
        actualizarComboRoles();
        actualizarComboRoles();

        
         // Verificar si hay un rol seleccionado antes de actualizar la tabla de permisos
         String rolSeleccionado = comboRoles.getValue();
         int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado);
         actualizarTablaPermisos(idRol);

    
    actualizarTablaRoles();

         
        // Inicializar funcionalidades de Configuración del Sistema
        inicializarConfiguracionSistema();
    }
      
    
    // Método para ajustar pestañas según el rol del usuario
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

    // Métodos para Configuración del Sistema
    private void inicializarConfiguracionSistema() {
        // Inicializar ComboBoxes
        comboIdioma.getItems().addAll("Español", "Inglés", "Francés");
        comboZonaHora.getItems().addAll("UTC-6", "UTC-5", "UTC+1");
        comboListaPrioridad.getItems().addAll("Alta", "Media", "Baja");

        // Configurar Spinner
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 365, 30);
        spinnerTiempoVencimiento.setValueFactory(valueFactory);

        // Configurar acciones de los botones
        btnGuardar.setOnAction(event -> guardarConfiguracion());
        btnLimpiar.setOnAction(event -> limpiarCampos());
        btnActualizar.setOnAction(event -> actualizarConfiguracion());
        btnBuscar.setOnAction(event -> buscarConfiguracion());
    }

   @FXML private void guardarConfiguracion() {
    String nombreEmpresa = txtNombreEmpresa.getText();
    String idioma = comboIdioma.getValue();
    String zonaHoraria = comboZonaHora.getValue();
    int tiempoVencimiento = spinnerTiempoVencimiento.getValue();
    String nivelPrioridad = comboListaPrioridad.getValue();

    try {
        ConfiguracionSistema config = new ConfiguracionSistema(
            nombreEmpresa, idioma, zonaHoraria, tiempoVencimiento, nivelPrioridad
        );

        ConfiguracionSistemaBD.guardarConfiguracion(config);
        System.out.println("Configuración guardada con éxito.");
    } catch (Exception e) {
        mostrarAlerta("Error al guardar en BD", e.getMessage());
    }
}

     // Método para actualizar configuración en la base de datos
@FXML private void actualizarConfiguracion() {
    int idConfiguracion;
    try {
        idConfiguracion = Integer.parseInt(txtIdConfiguracion.getText());
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "El ID debe ser un número válido.");
        return;
    }

    String nombreEmpresa = txtNombreEmpresa.getText();
    String idioma = comboIdioma.getValue();
    String zonaHoraria = comboZonaHora.getValue();
    int tiempoVencimiento = spinnerTiempoVencimiento.getValue();
    String nivelPrioridad = comboListaPrioridad.getValue();

    try {
        ConfiguracionSistema config = new ConfiguracionSistema(
            idConfiguracion, nombreEmpresa, idioma, zonaHoraria, tiempoVencimiento, nivelPrioridad
        );

        ConfiguracionSistemaBD.actualizarConfiguracion(config);
        System.out.println("Configuración actualizada con éxito.");
    } catch (Exception e) {
        mostrarAlerta("Error al actualizar en BD", e.getMessage());
    }
}

  @FXML private void buscarConfiguracion() {
    try {
        int idConfiguracion = Integer.parseInt(txtIdConfiguracion.getText());
        ConfiguracionSistema config = ConfiguracionSistemaBD.cargarConfiguracion(idConfiguracion);

        if (config != null) {
            txtNombreEmpresa.setText(config.getNombreEmpresa());
            comboIdioma.setValue(config.getIdioma());
            comboZonaHora.setValue(config.getZonaHoraria());
            spinnerTiempoVencimiento.getValueFactory().setValue(config.getTiempoVencimiento());
            comboListaPrioridad.setValue(config.getNivelesPrioridad());
            System.out.println("Configuración cargada correctamente.");
        } else {
            mostrarAlerta("Error", "No se encontró configuración con ese ID.");
        }
    } catch (Exception e) {
        mostrarAlerta("Error", "Hubo un problema al buscar la configuración.");
        e.printStackTrace();
    }
}
//Limpia campos de configuracion del sistema
      @FXML private void limpiarCampos() {
        txtIdConfiguracion.clear();
        txtNombreEmpresa.clear();
        comboIdioma.setValue(null);
        comboZonaHora.setValue(null);
        spinnerTiempoVencimiento.getValueFactory().setValue(30);
        comboListaPrioridad.setValue(null);
        System.out.println("Campos limpiados.");
    
    }

    
    // Métodos para Roles 
  @FXML private void crearRol() {
    String nombre = txtNombreRol.getText();
    String descripcion = txtDescripcionRol.getText();

    if (nombre.length() >= 3 && nombre.length() <= 50) {
        boolean exito = gestor.crearRol(nombre, descripcion);
        if (exito) {
            System.out.println("Rol creado exitosamente.");
            actualizarComboRoles(); 
            limpiarCamposR(); 
            mostrarAlerta("Error", "No se pudo crear el rol. Verifica los datos.");
        }
    } else {
        mostrarAlerta("Error de Validación", "El nombre del rol debe tener entre 3 y 50 caracteres.");
    }

    btnLimpiarR.setOnAction(event -> limpiarCamposR());
}

     

     @FXML private void limpiarCamposR() {
        txtIdRol.clear();
         txtNombreRol.clear();
        txtDescripcionRol.clear();
        System.out.println("Campos de rol limpiados.");
    }
     
      //Metodo para Permisos 
  @FXML private void crearPermiso() {
    String nombre = txtNombrePermiso.getText();
    String descripcion = txtDescripcionPermiso.getText();

    if (nombre.length() >= 3 && nombre.length() <= 50) {
        boolean exito = gestor.crearPermiso(nombre, descripcion);
        if (exito) {
            System.out.println("Permiso creado exitosamente.");
            actualizarComboPermisos(); 
        } else {
            mostrarAlerta("Error", "No se pudo crear el permiso. Verifica los datos.");
        }
    } else {
        mostrarAlerta("Error de Validación", "El nombre del Permiso debe tener entre 3 y 50 caracteres.");
    }

    btnCrearPermiso.setOnAction(event -> crearPermiso());
    btnLimpiarP.setOnAction(event -> limpiarCamposP());
}
    @FXML private void limpiarCamposP() {
        txtIdPermiso.clear();
        txtNombrePermiso.clear();
        txtDescripcionPermiso.clear();
        System.out.println("Campos de Permisos limpiados.");
      }

    // Métodos para gestión de roles y permisos
   @FXML private void cargarRoles() {
    List<Rol> roles = gestor.obtenerRoles();
    comboRoles.getItems().clear();

    // Transformar la lista de objetos Rol en una lista de nombres (String)
    List<String> nombresRoles = roles.stream().map(Rol::getNombre).toList();

    comboRoles.getItems().addAll(nombresRoles); 
}

   @FXML private void cargarPermisos() {
        List<Permiso> permisos = gestor.obtenerTodosLosPermisos();
        comboPermisos.getItems().clear();
 List<String> permisosString = permisos.stream().map(Permiso::getNombre).toList();
comboPermisos.getItems().addAll(permisosString);
    }
  @FXML private void actualizarTablaRoles() {
    List<Rol> roles = gestor.obtenerRoles(); 
    ObservableList<String> listaRolesString = FXCollections.observableArrayList(
        roles.stream().map(Rol::getNombre).toList() // 
    );

}

    @FXML private void actualizarComboRoles() {
    List<Rol> roles = gestor.obtenerRoles();
    comboRoles.getItems().clear();
    List<String> nombresRoles = roles.stream().map(Rol::getNombre).toList();
    comboRoles.getItems().addAll(nombresRoles);
}
   @FXML private void actualizarComboPermisos() {
    List<Permiso> permisos = gestor.obtenerTodosLosPermisos();
    comboPermisos.getItems().clear();
    List<String> nombresPermisos = permisos.stream().map(Permiso::getNombre).toList();
    comboPermisos.getItems().addAll(nombresPermisos);
} 
     
    @FXML private void actualizarTablaPermisos(int idRol) {
    List<String> permisos = gestor.obtenerPermisosPorRol(idRol);
    btnAsignarPermiso.setOnAction(event -> asignarPermisoARol());
}

       
      @FXML private void asignarPermisoARol() {
        String rolSeleccionado = comboRoles.getValue();
        String permisoSeleccionado = comboPermisos.getValue();
        String usuarioModificador = "Admin"; 

        if (rolSeleccionado != null && permisoSeleccionado != null) {
            int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado);
            int idPermiso = gestor.obtenerIdPermisoPorNombre(permisoSeleccionado);

            boolean exito = gestor.asignarPermisoARol(idRol, idPermiso, usuarioModificador);
            if (exito) {
                System.out.println("Permiso asignado correctamente.");
                actualizarTablaPermisos(idRol);
            } else {
                mostrarAlerta("Error", "No se pudo asignar el permiso.");
            }
        } else {
            mostrarAlerta("Error", "Selecciona un rol y un permiso antes de asignar.");
        }
    }

@FXML private void eliminarRol() {
    String rolSeleccionado = comboRoles.getValue();
    if (rolSeleccionado != null) {
        int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado);
        boolean exito = gestor.eliminarRol(idRol);

        if (exito) {
            System.out.println("Rol eliminado correctamente.");
            comboRoles.getItems().remove(rolSeleccionado); 
            limpiarCamposR(); 
        } else {
            mostrarAlerta("Error", "No se pudo eliminar el rol.");
        }
    } else {
        mostrarAlerta("Error", "Selecciona un rol antes de eliminar.");
    }
    btnEliminarRol.setOnAction(event -> eliminarRol()); 
}


@FXML private void eliminarPermiso() {
    String permisoSeleccionado = comboPermisos.getValue();
    if (permisoSeleccionado != null) {
        int idPermiso = gestor.obtenerIdPermisoPorNombre(permisoSeleccionado);
        boolean exito = gestor.eliminarPermiso(idPermiso);

        if (exito) {
            System.out.println("Permiso eliminado correctamente.");
            comboPermisos.getItems().remove(permisoSeleccionado); 
            limpiarCamposP(); 
        } else {
            mostrarAlerta("Error", "No se pudo eliminar el permiso.");
        }
    } else {
        mostrarAlerta("Error", "Selecciona un permiso antes de eliminar.");
    }
    btnEliminarPermiso.setOnAction(event -> eliminarPermiso()); 

}
    @FXML private void eliminarRelacion() {
    String rolSeleccionado = comboRoles.getValue();
    String permisoSeleccionado = comboPermisos.getValue();

    if (rolSeleccionado != null && permisoSeleccionado != null) {
        int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado);
        int idPermiso = gestor.obtenerIdPermisoPorNombre(permisoSeleccionado);

        boolean exito = gestor.eliminarRelacionRolPermisoIndividual(idRol, idPermiso); // ✅ Borra relación específica
        if (exito) {
            System.out.println("Relación eliminada correctamente.");
            actualizarTablaPermisos(idRol); // ✅ Actualiza la tabla
        } else {
            mostrarAlerta("Error", "No se pudo eliminar la relación.");
        }
    } else {
        mostrarAlerta("Error", "Selecciona un rol y un permiso antes de eliminar la relación.");
    }
     btnEliminarRelacion.setOnAction(event -> eliminarRelacion());
}
  
      @FXML private void seleccionarRol() {
    String rolSeleccionado = comboRoles.getValue(); 
    if (rolSeleccionado != null) {
        int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado); 
        Rol rol = gestor.obtenerRolPorId(idRol); 

        if (rol != null) {
            txtNombreRol.setText(rol.getNombre());
            txtDescripcionRol.setText(rol.getDescripcion());
        } else {
            System.out.println("No se encontró información para el rol seleccionado.");
        }
    }
}
   @FXML private void seleccionarPermiso() {
    String permisoSeleccionado = comboPermisos.getValue(); 
    if (permisoSeleccionado != null) {
        int idPermiso = gestor.obtenerIdPermisoPorNombre(permisoSeleccionado); 
        Permiso permiso = gestor.obtenerPermisoPorId(idPermiso); 

        if (permiso != null) {
            txtNombrePermiso.setText(permiso.getNombre());
            txtDescripcionPermiso.setText(permiso.getDescripcion());
        } else {
            System.out.println("No se encontró información para el permiso seleccionado.");
        }
    }
    // se asocia a los combobox
  comboRoles.setOnAction(event -> seleccionarRol());
  comboPermisos.setOnAction(event -> seleccionarPermiso());

}
   //para el boton buscar rol 
   @FXML private void buscarRol() {
    String rolSeleccionado = comboRoles.getValue();
    if (rolSeleccionado != null) {
        int idRol = gestor.obtenerIdRolPorNombre(rolSeleccionado);
        Rol rol = gestor.obtenerRolPorId(idRol);

        if (rol != null) {
            txtNombreRol.setText(rol.getNombre());
            txtDescripcionRol.setText(rol.getDescripcion());
        } else {
            mostrarAlerta("Error", "No se encontró información para el rol seleccionado.");
        }
    } else {
        mostrarAlerta("Error", "Selecciona un rol antes de buscar.");
    }
}
   //para buscar permiso
@FXML private void buscarPermiso() {
    String permisoSeleccionado = comboPermisos.getValue();
    if (permisoSeleccionado != null) {
        int idPermiso = gestor.obtenerIdPermisoPorNombre(permisoSeleccionado);
        Permiso permiso = gestor.obtenerPermisoPorId(idPermiso);

        if (permiso != null) {
            txtNombrePermiso.setText(permiso.getNombre());
            txtDescripcionPermiso.setText(permiso.getDescripcion());
        } else {
            mostrarAlerta("Error", "No se encontró información para el permiso seleccionado.");
        }
    } else {
        mostrarAlerta("Error", "Selecciona un permiso antes de buscar.");
    }
    btnBuscarRol.setOnAction(event -> buscarRol());
    btnBuscarPermiso.setOnAction(event -> buscarPermiso());
}
@FXML private void buscarRolPorId() {
    try {
        int idRol = Integer.parseInt(txtIdRol.getText()); // Obtiene el ID del campo de texto
        Rol rol = gestor.obtenerRolPorId(idRol); // Busca el rol en la BD

        if (rol != null) {
            txtNombreRol.setText(rol.getNombre());
            txtDescripcionRol.setText(rol.getDescripcion());
            comboRoles.setValue(rol.getNombre()); // Actualiza el ComboBox
        } else {
            mostrarAlerta("Error", "No se encontró un rol con ese ID.");
        }
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "Ingresa un ID válido.");
    }
}
@FXML private void buscarPermisoPorId() {
    try {
        int idPermiso = Integer.parseInt(txtIdPermiso.getText()); //  Obtiene el ID del campo de texto
        Permiso permiso = gestor.obtenerPermisoPorId(idPermiso); // Busca el permiso en la BD

        if (permiso != null) {
            txtNombrePermiso.setText(permiso.getNombre());
            txtDescripcionPermiso.setText(permiso.getDescripcion());
            comboPermisos.setValue(permiso.getNombre()); //  Actualiza el ComboBox
        } else {
            mostrarAlerta("Error", "No se encontró un permiso con ese ID.");
        }
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "Ingresa un ID válido.");
    }
 btnBuscarRol.setOnAction(event -> buscarRolPorId());
btnBuscarPermiso.setOnAction(event -> buscarPermisoPorId());

}
@FXML private void guardarModificacionRol() {
    try {
        int idRol = Integer.parseInt(txtIdRol.getText());
        String nuevoNombre = txtNombreRol.getText();
        String nuevaDescripcion = txtDescripcionRol.getText();

        boolean exito = gestor.actualizarRol(idRol, nuevoNombre, nuevaDescripcion);
        if (exito) {
            System.out.println("Rol actualizado correctamente.");
            actualizarComboRoles();
            limpiarCamposR();
        } else {
            mostrarAlerta("Error", "No se pudo actualizar el rol.");
        }
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "Ingresa un ID válido.");
    }
}
@FXML private void guardarModificacionPermiso() {
    try {
        int idPermiso = Integer.parseInt(txtIdPermiso.getText());
        String nuevoNombre = txtNombrePermiso.getText();
        String nuevaDescripcion = txtDescripcionPermiso.getText();

        boolean exito = gestor.actualizarPermiso(idPermiso, nuevoNombre, nuevaDescripcion);
        if (exito) {
            System.out.println("Permiso actualizado correctamente.");
            actualizarComboPermisos();
            limpiarCamposP();
        } else {
            mostrarAlerta("Error", "No se pudo actualizar el permiso.");
        }
    } catch (NumberFormatException e) {
        mostrarAlerta("Error", "Ingresa un ID válido.");
    }
 btnGuardarRol.setOnAction(event -> guardarModificacionRol());
btnGuardarPermiso.setOnAction(event -> guardarModificacionPermiso());

}

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}