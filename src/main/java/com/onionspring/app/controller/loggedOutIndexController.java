package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loggedOutIndexController {
    @GetMapping("/loggedOutIndex")
    public String loggedOutIndex() {
        return "loggedOutIndex";
    }
}