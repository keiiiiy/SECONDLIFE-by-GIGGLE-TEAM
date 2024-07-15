package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
// import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class PenjualScene8Controller {

    @FXML
    private ImageView account;


    @FXML
    private TextField search;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ImageView back;

    // Initialize method called after the FXML file has been loaded
    @FXML
    private void initialize() {
        // You can add initialization code here
        System.out.println("PenjualScene8Controller initialized");
        
        // Set event handler for back ImageView
    back.setOnMouseClicked(event -> handleBackClick());

        // Example: Add event handling for search field
        search.setOnAction(event -> handleSearch());
    }

    // Example method to handle search functionality
    private void handleSearch() {
        String query = search.getText();
        System.out.println("Searching for: " + query);
        // Implement search logic here
    }

    @FXML
private void handleBackClick() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProductBaru.fxml"));
        Parent root = loader.load();

        // Dapatkan controller dari scene yang baru
        SearchProductController controller = loader.getController();
        
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


    // Add more methods to handle other interactions as needed
}
