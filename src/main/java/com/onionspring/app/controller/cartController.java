package com.onionspring.app.controller;

import com.onionspring.app.api.Cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;

@Controller
public class cartController {
    @GetMapping("/cart")
    public String showOrder(@RequestParam(name = "action", required = false, defaultValue = "menu") String action,
            Model model) {

        List<Cart> items = new ArrayList<>();
        items.add(new Cart(1, "abc1", "Spring", 9, 3));
        items.add(new Cart(2, "abc2", "Onion", 19, 1));
        items.add(new Cart(3, "abc3", "Soup", 29, 2));
        model.addAttribute("items", items);
        return "cart";
    }
}
