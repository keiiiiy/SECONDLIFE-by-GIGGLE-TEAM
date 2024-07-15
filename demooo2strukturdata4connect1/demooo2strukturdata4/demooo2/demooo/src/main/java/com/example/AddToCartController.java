package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddToCartController {

    @FXML
    private ImageView gambar;
    @FXML
    private Label nama;
    @FXML
    private Label harga;
    @FXML
    private Label deskripsi;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView MenuIcon;

    @FXML
    private Label SecondLife;

    @FXML
    private HBox navBar1;

    @FXML
    private ImageView SearchIcon;

    @FXML
    private TextField SearchField;

    @FXML
    private ImageView Keranjang;

    @FXML
    private ImageView Profil;

    @FXML
    private Button TombolTambahKeranjang;

    @FXML
    private ImageView VasBungaMotifHewan;

    @FXML
    private ImageView chat;

    @FXML
    private Label back;

    // // Metode untuk menginisialisasi data produk yang dipilih
    // public void initData(Product product) {
    //     // Set gambar produk
    //     gambar.setImage(new Image(product.getImageUrl()));

    //     // Set nama produk
    //     nama.setText(product.getName());

    //     // Set harga produk
    //     harga.setText(String.valueOf(product.getPrice()));

    //     // Set deskripsi produk
    //     deskripsi.setText(product.getDescription());
    // }

    private Product product; // Untuk menyimpan data produk yang ditambahkan

    public void initialize() {
        // Initialize the controller. This method is automatically called after the FXML file is loaded.
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        // Set up any event handlers for the UI components here
        TombolTambahKeranjang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (product != null) {
                    showAlert();
                    // Tambahan: Tambahkan produk ke keranjang atau lakukan operasi yang sesuai di sini
                    // Contoh: addToCart(product);
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Produk tidak ditemukan.");
                    alert.showAndWait();
                }
            }
        });

        // Set up event handler for chat ImageView
        chat.setOnMouseClicked(event -> switchToChatOnline());

        // Set up event handler for back label
        if (back != null) {
            back.setOnMouseClicked(event -> switchToSearchProduct());
        } else {
            System.out.println("Label 'back' is null. Please check your FXML file.");
        }
    }

    // public void initData(Product product) {
    //     this.product = product;
    //     displayProductDetails();
    // }

    private void displayProductDetails() {
        if (product != null) {
            // Tampilkan detail produk di sini sesuai dengan kebutuhan UI Anda
            // Contoh:
            SecondLife.setText(product.getName());
            try {
                Image image = new Image(product.getImageUrl());
                VasBungaMotifHewan.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Produk tidak ditemukan.");
            alert.showAndWait();
        }
    }

    private void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Produk anda berhasil ditambahkan ke keranjang!");
        alert.showAndWait();
        
        // Tampilkan halaman keranjang setelah menambahkan produk
        showCartPage();
    }

    private void showCartPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CartPage.fxml"));
            AnchorPane cartPage = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Keranjang Anda");
            stage.initModality(Modality.APPLICATION_MODAL); // Membuat halaman modal
            stage.setScene(new Scene(cartPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to switch to ChatOnline scene
    private void switchToChatOnline() {
        try {
            Parent chatOnlineRoot = FXMLLoader.load(getClass().getResource("ChatOnline.fxml"));
            Scene chatOnlineScene = new Scene(chatOnlineRoot);
            Stage stage = (Stage) chat.getScene().getWindow();
            stage.setScene(chatOnlineScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleProfilClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene1.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) Profil.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Method to switch back to SearchProduct scene
    private void switchToSearchProduct() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchProduct.fxml"));
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

    public void initData(Product product) {
        // Pastikan path gambar diubah menjadi URL yang benar
        String imageUrl = "file:/" + product.getImageUrl().replace("\\", "/");
        gambar.setImage(new Image(imageUrl));
        nama.setText(product.getName());
        harga.setText("Rp " + product.getPrice());
        deskripsi.setText(product.getDescription());
    }
    
}
