package com.example;

public class Product {
    private String name;
    private String category;
    private double price;
    private String imageUrl;
    private String description;
    private String keywords;

    public Product(String name, String category, double price, String imageUrl, String description, String keywords) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getKeywords() {
        return keywords;
    }

    
}