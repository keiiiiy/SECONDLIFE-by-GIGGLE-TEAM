package com.example;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class SellerCentreController {

    @FXML
    private Button ButtonStatusPesanan;

    @FXML
    private MenuButton ButtonTahun;

    @FXML
    private Button ButtonUnduhData;

    @FXML
    private Text PusatBantuan;

    @FXML
    private Button Penjualan;

    @FXML
    private Button Pesanan;

    @FXML
    private Button PesananDibatalkan;

    @FXML
    private Button TotalPengunjung;

    @FXML
    private Button ProdukDilihat;

    @FXML
    private LineChart<?, ?> GrafikKriteria;

    @FXML
    private Button ButtonChat;

    @FXML
    public void initialize() {
        // Inisialisasi dan event handler
        initializeMenuButton();
        
        ButtonStatusPesanan.setOnAction(event -> handleStatusPesanan());
        ButtonUnduhData.setOnAction(event -> handleUnduhData());
        PusatBantuan.setOnMouseClicked(event -> handlePusatBantuan());
        Penjualan.setOnAction(event -> handlePenjualan());
        Pesanan.setOnAction(event -> handlePesanan());
        PesananDibatalkan.setOnAction(event -> handlePesananDibatalkan());
        TotalPengunjung.setOnAction(event -> handleTotalPengunjung());
        ProdukDilihat.setOnAction(event -> handleProdukDilihat());
        ButtonChat.setOnAction(event -> handleChat());
    }

    private void initializeMenuButton() {
        MenuItem action1 = new MenuItem("2021");
        MenuItem action2 = new MenuItem("2022");
        MenuItem action3 = new MenuItem("2023");

        ButtonTahun.getItems().addAll(action1, action2, action3);

        action1.setOnAction(event -> handleTahun("2021"));
        action2.setOnAction(event -> handleTahun("2022"));
        action3.setOnAction(event -> handleTahun("2023"));
    }

    private void handleStatusPesanan() {
        // Logika untuk menangani Status Pesanan
        System.out.println("Status Pesanan clicked");
    }

    private void handleUnduhData() {
        // Logika untuk menangani Unduh Data
        System.out.println("Unduh Data clicked");
    }

    private void handlePusatBantuan() {
        // Logika untuk menangani Pusat Bantuan
        System.out.println("Pusat Bantuan clicked");
    }

    private void handlePenjualan() {
        // Logika untuk menangani Penjualan
        System.out.println("Penjualan clicked");
    }

    private void handlePesanan() {
        // Logika untuk menangani Pesanan
        System.out.println("Pesanan clicked");
    }

    private void handlePesananDibatalkan() {
        // Logika untuk menangani Pesanan Dibatalkan
        System.out.println("Pesanan Dibatalkan clicked");
    }

    private void handleTotalPengunjung() {
        // Logika untuk menangani Total Pengunjung
        System.out.println("Total Pengunjung clicked");
    }

    private void handleProdukDilihat() {
        // Logika untuk menangani Produk Dilihat
        System.out.println("Produk Dilihat clicked");
    }

    private void handleChat() {
        // Logika untuk menangani Chat
        System.out.println("Chat clicked");
    }

    private void handleTahun(String tahun) {
        // Logika untuk menangani pemilihan tahun
        System.out.println("Tahun selected: " + tahun);
        ButtonTahun.setText("Berdasarkan Tahun: " + tahun);
    }
}
