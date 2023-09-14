package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewOrderController {
    @GetMapping("/viewOrder")
    public String showOrder() {
        return "viewOrder";
    }
}
