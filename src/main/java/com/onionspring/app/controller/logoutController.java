package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class logoutController {
    @GetMapping("/logout")
    public String showLogout() {
        return "logout";
    }
}
