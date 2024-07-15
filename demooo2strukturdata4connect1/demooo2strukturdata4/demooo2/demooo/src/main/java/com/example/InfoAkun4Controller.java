package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InfoAkun4Controller {

    @FXML
    private ImageView cart;

    @FXML
    private ImageView account;

    @FXML
    private ImageView back;

    @FXML
    private Button editProfileButton;

    @FXML
    private TextField namaPenggunaTextField;

    @FXML
    private TextField kataSandiTextField;

    @FXML
    private TextField konfirmasiKataSandiTextField;

    @FXML
    private TextField nomorHandphoneTextField;

    @FXML
    private TextField alamatTextField;

    @FXML
    public void handleCartClick() {
        // handle cart click event
    }

    @FXML
    public void handleAccountClick() {
        // handle account click event
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

    @FXML
    public void handleEditProfileClick() {
        // handle edit profile button click event
    }
}