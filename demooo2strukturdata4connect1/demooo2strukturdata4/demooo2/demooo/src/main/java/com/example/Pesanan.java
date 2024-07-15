package com.example;

public class Pesanan {
    private String namaPembeli;
    private String alamatPembeli;
    private String produkDipesan;
    private int jumlah;
    private int totalHarga;
    private String status;

    public Pesanan(String namaPembeli, String alamatPembeli, String produkDipesan, int jumlah, int totalHarga, String status) {
        this.namaPembeli = namaPembeli;
        this.alamatPembeli = alamatPembeli;
        this.produkDipesan = produkDipesan;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    // Getter dan setter
    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getAlamatPembeli() {
        return alamatPembeli;
    }

    public void setAlamatPembeli(String alamatPembeli) {
        this.alamatPembeli = alamatPembeli;
    }

    public String getProdukDipesan() {
        return produkDipesan;
    }

    public void setProdukDipesan(String produkDipesan) {
        this.produkDipesan = produkDipesan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
