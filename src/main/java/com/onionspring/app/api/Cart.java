package com.onionspring.app.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.ItemRepository;
import com.onionspring.app.database.tables.Item;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class Cart {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/api/item/{itemID}")
    public String addItemToCart(@PathVariable String itemID, @RequestParam(value = "qty") String sQty,
            HttpServletResponse response, HttpSession session) {
        int id;
        int qty;
        try {
            id = Integer.parseInt(itemID);
            qty = Integer.parseInt(sQty);
        } catch (NumberFormatException e) {
            return "error";
        }
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            int added = 0;
            String items = "";
            Object cart = session.getAttribute("cart");
            if (cart != null && !cart.equals("")) {
                items = (String) cart + "," + optionalItem.get().getId();
            } else {
                items = optionalItem.get().getId() + "";
            }

            while (added < qty - 1) {
                items += "," + optionalItem.get().getId();
                added++;
            }
            session.setAttribute("cart", items);
            return "OK";
        }

        return "Error";
    }

    @DeleteMapping("/api/item/{itemID}")
    public String removeItemFromCart(@PathVariable String itemID, HttpServletResponse response, HttpSession session) {
        int id;
        try {
            id = Integer.parseInt(itemID);
        } catch (NumberFormatException e) {
            return "error";
        }
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            String cart = (String) session.getAttribute("cart");
            if (cart != null) {
                String[] itemIDs = cart.split(",");
                String newCart = "";
                for (String item : itemIDs) {
                    if (Integer.parseInt(item) != id) {
                        if (newCart.equals("")) {
                            newCart += item;
                        } else {
                            newCart += "," + item;
                        }
                    }
                }
                session.setAttribute("cart", newCart);
                // return a 204 no content
                response.setStatus(204);
                return "";
            }
        }

        return "Error";
    }
}
