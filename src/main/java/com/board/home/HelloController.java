package com.board.home;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hi() {
		return "Hi!!";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("data", "Helloooooo!");
		return "home";
	}
}
