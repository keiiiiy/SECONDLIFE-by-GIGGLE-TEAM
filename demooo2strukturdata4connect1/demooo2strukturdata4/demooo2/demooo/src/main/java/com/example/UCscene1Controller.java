package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// import com.opencsv.CSVReader;

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

public class UCscene1Controller {

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

    @FXML
    private ImageView back;

    @FXML
    private Label username1;

    @FXML
    private Label username2;

    @FXML
    private Label email;

    @FXML
    private Label password;

    @FXML
    private Label nohp;



    // Initialize method
    @FXML
    public void initialize() {
        // Initialize any necessary variables or setup here
        try {
            String[] userData = CSVReader.readLastLine("C:\\Users\\BEST LAPTOP\\Documents\\EXPO GIGGLE TEAM\\demo1\\users.csv");

            if (userData.length >= 4) {
                
                username1.setText(userData[0]+" "+userData[1]);
                username2.setText("Username : "+userData[0]+userData[1]);
                email.setText("Email : "+userData[3]);
                password.setText("Password : "+userData[4]);
                nohp.setText("Phone Number : "+userData[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set event handler untuk back ImageView
        back.setOnMouseClicked(event -> handleBackClick());
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

    @FXML
    private void handleBackClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProductBaru.fxml"));
            Parent root = loader.load();

            // Jika perlu, Anda bisa mendapatkan controller dari scene baru
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
