package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cartController {
    @GetMapping("/cart")
    public String showOrder() {
        return "cart";
    }
}
