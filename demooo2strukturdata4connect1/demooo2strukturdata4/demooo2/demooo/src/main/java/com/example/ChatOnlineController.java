package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatOnlineController implements Initializable {

    @FXML
    private Button buttonKirim;

    @FXML
    private TextField messageField;

    @FXML
    private Pane chatOnline1;

    @FXML
    private Pane chatOnline2;

    @FXML
    private Label labelOnlineStatus;

    @FXML
    private Label hailandShopLabel;

    @FXML
    private VBox paneChat;

    @FXML
    private ImageView back;

    @FXML
    public void initialize() {
        // Initialize any necessary data or components here

        back.setOnMouseClicked(event -> handleBackClick());
    }

    @FXML
    private void handleSendMessage() {
        if (messageField != null && !messageField.getText().trim().isEmpty()) {
            String message = messageField.getText().trim();
            System.out.println("Sending message: " + message);

            // Create a new message pane for the sent message
            Pane messagePane = createMessagePane(message, true); // true indicates sent message

            // Add the message pane to paneChat
            paneChat.getChildren().add(messagePane);

            // Clear the message field after sending
            messageField.clear();

            // Simulate receiving a reply message after sending
            String replyMessage = simulateReplyFromRecipient(message);
            receiveReply(replyMessage);
        } else {
            System.out.println("Message field is null or empty.");
        }
    }

    // Simulate receiving a reply message from the recipient
    private String simulateReplyFromRecipient(String messageSent) {
        String lowerCaseMessage = messageSent.toLowerCase();

        // Example replies based on the message sent
        if (lowerCaseMessage.contains("halo kakk") || lowerCaseMessage.contains("hai kak,mau tanya")) {
            return "Halo! Ada yang bisa saya bantu?";
        } else if (lowerCaseMessage.contains("size m nya ada?")) {
            return "Ready kak, silahkan order!";
        } else if (lowerCaseMessage.contains("warna hitamnya ada kah?")) {
            return "kosong kak";
        } else if (lowerCaseMessage.contains("kira2 restock kapan?")) {
            return "belum tahu nih kak";
        } else if (lowerCaseMessage.contains("okey kak makasih")) {
            return "sama-sama kak";
        } else {
            return "Maaf, saya tidak mengerti.";
        }
    }

    // Method to simulate receiving and displaying a reply message
    private void receiveReply(String replyMessage) {
        // Create a new message pane for the received reply
        Pane messagePane = createMessagePane(replyMessage, false); // false indicates received message
        paneChat.getChildren().add(messagePane);
    }

    private Pane createMessagePane(String message, boolean isSentByUser) {
        HBox hbox = new HBox();
        hbox.setPrefHeight(38.0);
        hbox.setPrefWidth(250.0);

        // Set alignment for sent and received messages
        hbox.setAlignment(isSentByUser ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);

        Pane pane = new Pane();
        pane.setPrefHeight(38.0);
        pane.setPrefWidth(200.0);
        pane.setStyle(
                "-fx-background-radius: 25; -fx-background-color: " + (isSentByUser ? "#C3B9EA" : "#FFFFFF") + ";");

        Label label = new Label(message);
        label.setLayoutX(5.0);
        label.setLayoutY(5.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(180.0);
        label.setWrapText(true);

        pane.getChildren().add(label);
        hbox.getChildren().add(pane);

        return hbox;
    }

    @FXML
    private void switchToChatOnline1() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ChatOnline.fxml"));
            Stage stage = (Stage) chatOnline2.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBackClick() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addtocarteditbenar.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
}
