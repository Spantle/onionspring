package com.onionspring.utils;

import com.onionspring.app.database.tables.Item;

public class CartItem {
    public Item item;
    public Integer num;
    public Integer qty;

    public CartItem(Item item, Integer num, Integer qty) {
        this.item = item;
        this.num = num;
        this.qty = qty;
    }

    public Integer getId() {
        return item.getId();
    }

    public String getName() {
        return item.getName();
    }

    public String getPrice() {
        return "$" + item.getPrice();
    }

    public String getNum() {
        return num + "";
    }

    public String getQty() {
        return qty + "";
    }
}