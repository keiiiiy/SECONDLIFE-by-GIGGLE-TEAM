package com.example;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CartItem {

    private final StringProperty itemName;
    private final DoubleProperty price;
    private final IntegerProperty quantity;
    private final DoubleProperty total;

    public CartItem(String itemName, double price, int quantity, double total) {
        this.itemName = new SimpleStringProperty(itemName);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.total = new SimpleDoubleProperty(total);
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public DoubleProperty totalProperty() {
        return total;
    }
}