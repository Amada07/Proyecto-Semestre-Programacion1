/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistematickets;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;



/**
 *
 * @author Amada
 */
public class SistemaTickets extends Application {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void start (Stage primaryStage) throws IOException  {
   
    Parent root = FXMLLoader.load(getClass().getResource("/sistematickets/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Tickets");
        primaryStage.show();
    }
    
   public static void main(String []args){
      Connection connection = ConexionDB.obtenerConexion();
       launch (args);
   } 
}