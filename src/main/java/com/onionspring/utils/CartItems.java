package com.onionspring.utils;

import java.util.List;

import com.onionspring.app.database.tables.Item;

public class CartItems {
    public List<CartItem> cartItems;

    public CartItems(List<Item> items) {
        cartItems = new java.util.ArrayList<>();

        for (Item item : items) {
            int num = 0;
            for (Item item2 : items) {
                if (item.getId() == item2.getId()) {
                    num++;
                }
            }
            boolean found = false;
            for (CartItem cartItem : cartItems) {
                if (cartItem.item.getId() == item.getId()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                cartItems.add(new CartItem(item, cartItems.size() + 1, num));
            }
        }
    }
}
