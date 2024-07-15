package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UCscene5Controller {
    @FXML
    private ImageView imageViewGaris;

    @FXML
    private ImageView imageViewSearch;

    @FXML
    private TextField textFieldSearch;

    @FXML
    private ImageView imageViewCart;

    @FXML
    private ImageView back;

    @FXML
    private ImageView imageViewAccount;

    @FXML
    private ImageView imageViewSuccess;

    @FXML
    private Label labelSuccess;

    @FXML
    private void handleSearchClick(MouseEvent event) {
        // Handle search click event
        System.out.println("Search button clicked!");
    }

    @FXML
    private void handleCartClick(MouseEvent event) {
        // Handle cart click event
        System.out.println("Cart button clicked!");
    }

    @FXML
    private void handleAccountClick(MouseEvent event) {
        // Handle account click event
        System.out.println("Account button clicked!");
    }

    @FXML
    private void handleSuccessClick(MouseEvent event) {
        // Handle success click event
        System.out.println("Success button clicked!");
    }

    @FXML
    public void handleBackClick() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene1.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) back.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
}