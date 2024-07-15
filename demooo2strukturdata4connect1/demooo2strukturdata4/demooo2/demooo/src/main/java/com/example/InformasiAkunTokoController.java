package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InformasiAkunTokoController {
    @FXML
    private TableView<Pesanan> tableView;
    @FXML
    private TableColumn<Pesanan, String> tcNamaPembeli;
    @FXML
    private TableColumn<Pesanan, String> tcAlamatPembeli;
    @FXML
    private TableColumn<Pesanan, String> tcProdukDipesan;
    @FXML
    private TableColumn<Pesanan, Integer> tcJumlah;
    @FXML
    private TableColumn<Pesanan, Integer> tcTotalHarga;
    @FXML
    private Button statusDiizinkan;
    @FXML
    private Button statusMenunggu;
    @FXML
    private Button statusDitolak;

    private List<Pesanan> semuaPesanan;

    // Variabel untuk melacak status tombol
    private boolean diizinkanSelected = false;
    private boolean menungguSelected = true; // Default menunggu dipilih
    private boolean ditolakSelected = false;

    @FXML
    public void initialize() {
        tcNamaPembeli.setCellValueFactory(new PropertyValueFactory<>("namaPembeli"));
        tcAlamatPembeli.setCellValueFactory(new PropertyValueFactory<>("alamatPembeli"));
        tcProdukDipesan.setCellValueFactory(new PropertyValueFactory<>("produkDipesan"));
        tcJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tcTotalHarga.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));

        semuaPesanan = loadPesananFromCsv("C:\\Users\\BEST LAPTOP\\Documents\\EXPO GIGGLE TEAM\\demo1\\demooo2strukturdata4connect1\\demooo2strukturdata4\\demooo2\\demooo\\target\\pesanan.csv");

        // Inisialisasi filter tabel default
        filterTable("Menunggu");

        // Setup event handler untuk tombol status
        setupStatusButtons();
    }

    private void setupStatusButtons() {
        statusDiizinkan.setOnAction(e -> {
            filterTable("Diizinkan");
            diizinkanSelected = true;
            menungguSelected = false;
            ditolakSelected = false;
            updateButtonStyles();
        });

        statusMenunggu.setOnAction(e -> {
            filterTable("Menunggu");
            diizinkanSelected = false;
            menungguSelected = true;
            ditolakSelected = false;
            updateButtonStyles();
        });

        statusDitolak.setOnAction(e -> {
            filterTable("Ditolak");
            diizinkanSelected = false;
            menungguSelected = false;
            ditolakSelected = true;
            updateButtonStyles();
        });

        // Set style awal tombol berdasarkan status yang dipilih
        updateButtonStyles();
    }

    private List<Pesanan> loadPesananFromCsv(String csvFile) {
        List<Pesanan> pesananList = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                // Parsing data sesuai dengan urutan kolom di CSV
                String namaPembeli = data[0];
                String alamatPembeli = data[1];
                String produkDipesan = data[2];
                int jumlah = Integer.parseInt(data[3]);
                int totalHarga = Integer.parseInt(data[4]);
                String status = data[5];
                pesananList.add(new Pesanan(namaPembeli, alamatPembeli, produkDipesan, jumlah, totalHarga, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pesananList;
    }

    private void filterTable(String status) {
        ObservableList<Pesanan> filteredList = FXCollections.observableArrayList();
        for (Pesanan pesanan : semuaPesanan) {
            if (pesanan.getStatus().equals(status)) {
                filteredList.add(pesanan);
            }
        }
        tableView.setItems(filteredList);
    }

    private void updateButtonStyles() {
        // Mengatur gaya tombol berdasarkan status yang dipilih
        statusDiizinkan.setStyle(diizinkanSelected ? "-fx-font-weight: bold;" : "-fx-font-weight: normal;");
        statusMenunggu.setStyle(menungguSelected ? "-fx-font-weight: bold;" : "-fx-font-weight: normal;");
        statusDitolak.setStyle(ditolakSelected ? "-fx-font-weight: bold;" : "-fx-font-weight: normal;");
    }
}
