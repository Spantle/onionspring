package com.onionspring.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @GetMapping("/api/login")
    public String login(@RequestParam(value = "name", defaultValue = "Default Name") String name) {
        return String.format("Pretending to login %s", name);
    }
}
