package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.event.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductController {

    @FXML
    private VBox productContainer;
    @FXML
    private TextField searchField;
    @FXML
    private Label kategoriFashion;
    @FXML
    private Label kategoriMiniature;
    @FXML
    private Label kategoriMainan;
    @FXML
    private Label kategoriFurnitur;
    @FXML
    private Label kategoriDekor;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView news;
    @FXML
    private ImageView keranjang;
    
    

    private List<Product> products;



    public void initialize() {
        products = loadProductsFromCsv();
        displayProducts(products);

        // Set event handler for keranjang ImageView
        keranjang.setOnMouseClicked(event -> handleKeranjangClick());

        // Set event handler untuk profile ImageView
        profile.setOnMouseClicked(event -> handleProfileClick());

        

    
    // Set event handler untuk news ImageView
    news.setOnMouseClicked(event -> handleNewsClick());

        
    }

    @FXML
    private void handleKeranjangClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CartPage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) keranjang.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
private void handleNewsClick() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualScene8.fxml"));
        Parent root = loader.load();

        // Dapatkan controller dari scene yang baru
        PenjualScene8Controller controller = loader.getController();
        
        // Transfer data jika diperlukan, contoh:
        // controller.initData(someData);

        Stage stage = (Stage) news.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    @FXML
    private void handleSearch() {
        String query = searchField.getText().toLowerCase();
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getName().toLowerCase().contains(query))
                .toList();
        displayProducts(filteredProducts);
    }

    @FXML
    private void handleCategoryClick(Event event) {
        String category = ((Label) event.getSource()).getText().toLowerCase();
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().toLowerCase().contains(category))
                .toList();
        displayProducts(filteredProducts);
    }

    private void displayProducts(List<Product> products) {
        productContainer.getChildren().clear();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        int row = 0;
        int col = 0;

        for (Product product : products) {
            VBox productBox = createProductBox(product);
            gridPane.add(productBox, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }
        productContainer.getChildren().add(gridPane);
    }

    private VBox createProductBox(Product product) {
        VBox box = new VBox(5);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 1px;");
    
        ImageView gambar = new ImageView();
        // Pastikan path gambar diubah menjadi URL yang benar
        String imageUrl = "file:/" + product.getImageUrl().replace("\\", "/");
        gambar.setImage(new Image(imageUrl));
        gambar.setFitHeight(140);
        gambar.setFitWidth(140);
    
        Label nama = new Label(product.getName());
        Label harga = new Label("Rp " + product.getPrice());
    
        box.getChildren().addAll(gambar, nama, harga);
    
        // Set userData ke VBox agar bisa diakses saat VBox diklik
        box.setUserData(product);
    
        // Menambahkan event handler untuk MouseEvent
        box.setOnMouseClicked(event -> handleProductClick(event));
    
        return box;
    }

    private List<Product> loadProductsFromCsv() {
        List<Product> products = new ArrayList<>();
        String csvFile = "C:\\Users\\ASUS\\Documents\\SEMESTER 2\\demo1\\demooo2strukturdata4connect1\\demooo2strukturdata4\\demooo2\\demooo\\target\\produk.csv"; 
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                // Parsing data sesuai dengan urutan kolom di CSV
                String name = data[0];
                String category = data[1];
                double price = Double.parseDouble(data[2]);
                String imageUrl = data[3];
                String description = data[4];
                String keywords = data[5];
                products.add(new Product(name, category, price, imageUrl, description, keywords));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    @FXML
    private void handleProfileClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UCscene1.fxml"));
            Parent root = loader.load();

            // Jika perlu, Anda bisa mendapatkan controller dari scene baru
            UCscene1Controller controller = loader.getController();

            // Transfer data jika diperlukan, contoh:
            // controller.initData(someData);

            Stage stage = (Stage) profile.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
private void handleProductClick(MouseEvent event) {
    // Mendapatkan produk yang dipilih dari VBox yang diklik
    VBox selectedVBox = (VBox) event.getSource();
    Product selectedProduct = (Product) selectedVBox.getUserData();

    // Memuat halaman AddToCart.fxml dengan data produk yang dipilih
    loadAddToCartPage(selectedProduct);
}


    // Metode untuk memuat halaman AddToCart.fxml dengan data produk yang dipilih
    private void loadAddToCartPage(Product product) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addtocarteditbenar.fxml"));
            Parent root = loader.load();
    
            AddToCartController controller = loader.getController();
            controller.initData(product);
    
            Stage stage = (Stage) profile.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
