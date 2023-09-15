package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateAccountController {
	@GetMapping("/createAccount")
	public String showCreateAccount() {
		return "createAccount";
	}
}
