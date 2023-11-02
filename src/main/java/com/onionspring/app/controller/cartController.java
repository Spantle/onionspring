package com.onionspring.app.controller;

import java.util.Optional;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.tables.Item;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;

@Controller
public class cartController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/cart")
    public String showOrder(HttpServletResponse response, HttpSession session, Model model) {
        List<Item> items = new ArrayList<>();
        String cart = (String) session.getAttribute("cart");
        if (cart != null && !cart.equals("")) {
            String[] itemIDs = cart.split(",");
            for (String itemID : itemIDs) {
                Optional<Item> optionalItem = itemRepository.findById(Integer.parseInt(itemID));
                if (!optionalItem.isPresent()) {
                    continue;
                }
                items.add(optionalItem.get());
            }
        }

        List<CartItem> cartItems = new ArrayList<>();
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

        model.addAttribute("items", cartItems);
        return "cart";
    }
}

class CartItem {
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