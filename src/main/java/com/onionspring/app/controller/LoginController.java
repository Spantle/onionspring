package com.onionspring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.onionspring.app.database.repositories.UserRepository;
import com.onionspring.app.database.tables.User;

import jakarta.annotation.PostConstruct;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostConstruct
	public void addDummyValues() {
		try {
			User existingUser = userRepository.findByEmail("admin@admin.com").get();
			if (existingUser == null) {
				User user = new User("admin@admin.com", "Admin", "User", "Admin", "admin",
						true);
				userRepository.save(user);
			}
		} catch (Exception e) {
		}
	}
}
