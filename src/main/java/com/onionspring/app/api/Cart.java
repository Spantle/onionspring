package com.onionspring.app.api;

public class Cart {

    private int no;
    private String code;
    private String name;
    private float price;
    private int quantity;

    public Cart(int no, String code, String name, float price, int quantity) {
        this.no = no;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getNo() {
        return no;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
