package com.onionspring.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.User;

@RestController
public class CreateAccount {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/createAccount")
    public String createAccount(@RequestBody CreateAccountForm details) {
        User user = new User(details.email, details.firstName, details.lastName, details.address, details.password,
                false);
        userRepository.save(user);

        return "ok";
    }
}

class CreateAccountForm {
    public String firstName;
    public String lastName;
    public String email;
    public String address;
    public String password;
}