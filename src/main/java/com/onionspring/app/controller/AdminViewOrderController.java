package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewOrderController {
    @GetMapping("/adminViewOrder")
    public String showAdminOrder() {
        return "adminViewOrder";
    }

}
