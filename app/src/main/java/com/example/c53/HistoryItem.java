package com.example.c53;

public class HistoryItem {
    private int id;
    private String name;
    private int image;
    private String address;
    private int quantity;

    public HistoryItem(int id, String name, int image, String address, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
