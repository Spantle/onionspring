package com.onionspring.app.database.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "item_id")
    private int item_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "status")
    private String status;

    public Cart() {
    }

    public Cart(int user, int item, int quantity, float price, String status) {
        this.user_id = user;
        this.item_id = item;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getItemId() {
        return item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

}
