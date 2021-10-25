package com.board.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController { // Restful
	@RequestMapping(value = "/how", method = RequestMethod.POST)
	public String hi() {
		return "how";
	}
}
