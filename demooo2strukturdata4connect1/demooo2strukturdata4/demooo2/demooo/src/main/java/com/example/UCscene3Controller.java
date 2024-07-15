package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class UCscene3Controller {

    @FXML
    private TextField searchField;

    @FXML
    private ImageView search;

    @FXML
    private ImageView cart;

    @FXML
    private ImageView account;

    @FXML
    private void initialize() {
        // Initialization code here
    }

    @FXML
    private void handleSearch() {
        String searchQuery = searchField.getText();
        System.out.println("Searching for: " + searchQuery);
        // Implement search logic here
    }

    @FXML
    private void handleCart() {
        System.out.println("Cart clicked");
        // Implement cart logic here
    }

    @FXML
    private void handleAccount() {
        System.out.println("Account clicked");
        // Implement account logic here
    }

    @FXML
    private void handleConfirm() {
        System.out.println("Confirm clicked");
        // Implement confirmation logic here
    }
}