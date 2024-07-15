package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private void handleSignUp() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String emailAddress = emailAddressField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Passwords do not match");
            return;
        }

        User newUser = new User(firstName, lastName, phoneNumber, emailAddress, password);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true))) {
            writer.write(newUser.getFirstName() + "," +
                         newUser.getLastName() + "," +
                         newUser.getPhoneNumber() + "," +
                         newUser.getEmailAddress() + "," +
                         newUser.getPassword());
            writer.newLine();
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful!", "Welcome " + firstName);
            switchToSearchProduct(); // Panggil method untuk pindah scene setelah registrasi berhasil
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Failed to save user data");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    private void switchToSearchProduct() {
        try {
            Parent searchProductRoot = FXMLLoader.load(getClass().getResource("SearchProductBaru.fxml"));
            Scene searchProductScene = new Scene(searchProductRoot);
            Stage stage = (Stage) signUpButton.getScene().getWindow();
            stage.setScene(searchProductScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signUpButton.setOnMouseClicked(event -> handleSignUp());
    }
}
