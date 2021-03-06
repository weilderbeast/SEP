package com.company;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

/**
 * The method that starts the application
 * @author Cirstoiu Bogdan-Florin
 * @version 1.0
 */
public class JavaFXGUI extends Application
{

  /**
   * Start method for the GUI
   * @param stage
   * @throws Exception
   */
  public void start(Stage stage) throws Exception
  {
    stage.setTitle("VIAFIT's Management System");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("GUI.fxml"));
    Scene scene = new Scene(loader.load(),-1,-1,true,SceneAntialiasing.BALANCED);
    stage.setScene(scene);
    stage.show();
  }
}
