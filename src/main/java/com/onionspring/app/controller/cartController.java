package com.onionspring.app.controller;

import java.util.Optional;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.tables.Item;
import com.onionspring.utils.CartItem;
import com.onionspring.utils.CartItems;

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

        List<CartItem> cartItems = new CartItems(items).cartItems;

        model.addAttribute("items", cartItems);
        return "cart";
    }
}
