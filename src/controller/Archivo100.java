package controller;

import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

       

public class Archivo100 extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage stage) throws Exception {
        
        URL url = getClass().getClassLoader().getResource("archivo.fxml");

        //Parent root = FXMLLoader.load(getClass().getResource(""));
        Parent root =FXMLLoader.load(getClass().getResource("archivo.fxml"));
        //stage.initStyle(StageStyle.UNDECORATED);
           
      
        
       
        //set mouse pressed
        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        //set mouse drag
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);

       scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        stage.setTitle("INVENTARIO DOCUMENTARIO - GSP");
        stage.getIcons().add(new Image("img/icono.png")); 
        //esto es si pones un icono cuan se habra  la aplicacion
        
        stage.setScene(scene);
        stage.show();
        
        
    }
  

}
