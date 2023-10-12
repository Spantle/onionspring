package com.onionspring.app.api;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onionspring.app.database.repositories.SessionRepository;
import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.Session;
import com.onionspring.app.database.tables.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Login {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping("/api/login")
    public String login(@RequestBody LoginAccountForm details, HttpServletResponse response)
            throws InterruptedException, ExecutionException {
        User user = userRepository.findByEmail(details.email).get();
        System.out.println(user.getId() + " " + details.password + " " + user.equals(null) + " "
                + user.validatePassword(details.password));
        if (!user.equals(null) && user.validatePassword(details.password)) {
            Session session = new Session(user);
            sessionRepository.save(session);

            Cookie cookie = new Cookie("session", session.getId());
            response.addCookie(cookie);

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