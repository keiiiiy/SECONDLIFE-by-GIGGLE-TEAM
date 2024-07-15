package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InfoAkun1Controller {

    @FXML
    private ImageView cart;

    @FXML
    private ImageView account;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView search;

    @FXML
    private ImageView profile;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private ImageView pencil;

    @FXML
    private TextField viewOrderHistory;

    @FXML
    private ImageView clipboard;

    @FXML
    private ImageView dikemas;

    @FXML
    private ImageView bintang;

    @FXML
    private ImageView dikirim;

    @FXML
    private ImageView belumBayar;

    @FXML
    private Label belumBayarLabel;

    @FXML
    private Label dikemasLabel;

    @FXML
    private Label dikirimLabel;

    @FXML
    private Label beriPenilaianLabel;

    @FXML
    private Button click1; 

    // Initialize method
    @FXML
    public void initialize() {
        // Initialize any necessary variables or setup here
    }

    @FXML
    public void handlePencilClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene4.fxml"));
            Parent root = loader.load();
    
            Stage stage = (Stage) pencil.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Event handlers for buttons and other interactive elements
    @FXML
    public void handleSearchButtonAction() {
        // Handle search button action here
    }

    @FXML
    public void handleViewOrderHistoryAction() {
        // Handle view order history action here
    }

   // Other methods and event handlers as needed

    // Method to handle click1 button action and switch scene
    @FXML
    public void handle1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene2.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) click1.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}