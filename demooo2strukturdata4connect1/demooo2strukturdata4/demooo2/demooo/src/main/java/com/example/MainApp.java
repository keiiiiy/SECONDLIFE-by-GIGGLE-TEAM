package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        Parent root = loader.load();
        
        // Create a scene with the preferred size
        Scene scene = new Scene(root, 650, 500);
        
        // Bind the root node's scale properties to the scene's width and height
        root.scaleXProperty().bind(scene.widthProperty().divide(650));
        root.scaleYProperty().bind(scene.heightProperty().divide(500));
        
        stage.setScene(scene);
        stage.setTitle("SecondLife E-commerce");

        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
