package com.onionspring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WarioController {
	@GetMapping("/wario") // the path
	public String showWario(
			@RequestParam(name = "action", required = false, defaultValue = "always winning") String action,
			Model model) {
		model.addAttribute("action", action);
		return "wario"; // the filename (wario.html)
	}
}
