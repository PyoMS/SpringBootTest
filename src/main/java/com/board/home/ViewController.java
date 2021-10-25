package com.board.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@GetMapping("/hello")
	public String hi() {
		return "Hi!!";
	}
	
	@RequestMapping("/") //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public String home(Model model) {
		model.addAttribute("data", "HEY!"); // model을 통해서 Attr 값 반환 가능.
		return "/home";
	}
}
