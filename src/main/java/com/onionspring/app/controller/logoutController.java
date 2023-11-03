package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class logoutController {
    @GetMapping("/logout")
    public String showLogout(HttpSession session) {
        session.invalidate();

        return "logout";
    }
}
