package com.example;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CartPageController {

    @FXML
    private AnchorPane mainPane;
    
    @FXML
    private ImageView MenuIcon;
    
    @FXML
    private ImageView SearchIcon;
    
    @FXML
    private ImageView Keranjang;
    
    @FXML
    private ImageView Profil;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private Label SecondLife;

    @FXML
    private TableView<CartItem> tableview;

    @FXML
    private TableColumn<CartItem, String> tcitem;

    @FXML
    private TableColumn<CartItem, Double> tcprice;

    @FXML
    private TableColumn<CartItem, Integer> tcquantity;

    @FXML
    private TableColumn<CartItem, Double> tctotal;

    @FXML
    private ImageView back;


    @FXML
    private void initialize() {
        // Initialize any required data or event handlers
        System.out.println("CartPageController initialized");

        // Example: Add event handling for search field
        searchField.setOnAction(event -> handleSearch());

        // Set event handler for MenuIcon, Keranjang, and Profil
        MenuIcon.setOnMouseClicked(event -> handleMenuClick());
        Keranjang.setOnMouseClicked(event -> handleCartClick());
        Profil.setOnMouseClicked(event -> handleProfileClick());

        // Load data from CSV file into TableView
        loadCSVData();
    }

    @FXML
    private void handleBackButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProductBaru.fxml"));
            Parent root = loader.load();
           SearchProductController controller = loader.getController();
            
            // Optionally, you can pass data or initialize something in the controller
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow(); // or any other node in your current scene
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as needed
        }
    }

    // Method to handle search functionality
    private void handleSearch() {
        String query = searchField.getText();
        System.out.println("Searching for: " + query);
        // Implement search logic here
    }

    // Method to handle MenuIcon click
    private void handleMenuClick() {
        System.out.println("Menu Icon clicked");
        // Implement menu handling logic here
    }

    // Method to handle Keranjang (Cart) click
    private void handleCartClick() {
        System.out.println("Cart Icon clicked");
        // Implement cart handling logic here
    }

    // Method to handle Profil (Profile) click
    private void handleProfileClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));
            Parent root = loader.load();

            // If needed, you can get the controller of the new scene
            // ProfilePageController controller = loader.getController();

            Stage stage = (Stage) Profil.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCSVData() {
        ObservableList<CartItem> data = FXCollections.observableArrayList();

        String csvFile = "C:\\Users\\ASUS\\Documents\\SEMESTER 2\\demo1\\demooo2strukturdata4connect1\\demooo2strukturdata4\\demooo2\\demooo\\target\\test-classes\\cart_data.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);

                String itemName = items[0];
                double price = Double.parseDouble(items[1]);
                int quantity = Integer.parseInt(items[2]);
                double total = Double.parseDouble(items[3]);

                data.add(new CartItem(itemName, price, quantity, total));
            }

            // Set data to TableView
            tableview.setItems(data);

            // Set cell value factories for each TableColumn
            tcitem.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
            tcprice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
            tcquantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
            tctotal.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

