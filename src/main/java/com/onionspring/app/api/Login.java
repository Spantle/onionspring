package com.onionspring.app.api;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.User;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class Login {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/login")
    public String login(@RequestBody LoginAccountForm details, HttpServletResponse response, HttpSession session)
            throws InterruptedException, ExecutionException {
        User user = userRepository.findByEmail(details.email).get();

        if (user != null && user.validatePassword(details.password)) {
            session.setAttribute("user", user.getId());
            session.setAttribute("userFirstname", user.getFirstName());

            return "ok";
        } else {
            return "error";
        }
    }
}

class LoginAccountForm {
    public String email;
    public String password;
}