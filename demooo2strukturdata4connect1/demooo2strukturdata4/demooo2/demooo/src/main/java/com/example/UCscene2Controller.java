package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class UCscene2Controller {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView pencil;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView back;

    @FXML
    private TabPane tabPane;

    @FXML
    private Pane accountInfoPane;

    @FXML
    private Button bayar;

    // Initialize method
    @FXML
    public void initialize() {
        // Initialize your controller here
        // Set event handler untuk back ImageView
        back.setOnMouseClicked(event -> handleBackClick());
        bayar.setOnAction(event -> handleBayarClick());
    }

    @FXML
    private void handleBayarClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene3.fxml"));
            Parent root = loader.load();

            UCscene3Controller controller = loader.getController();

            // Transfer data jika diperlukan
            // controller.initData(someData);

            Stage stage = (Stage) bayar.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle back ImageView click and switch scene
    @FXML
    private void handleBackClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene1.fxml"));
            Parent root = loader.load();

            // Jika perlu, Anda bisa mendapatkan controller dari scene baru
            UCscene1Controller controller = loader.getController();

            // Transfer data jika diperlukan, contoh:
            // controller.initData(someData);

            Stage stage = (Stage) back.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods and event handlers can be added here
}
