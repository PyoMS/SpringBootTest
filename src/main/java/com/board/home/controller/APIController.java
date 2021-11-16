package com.board.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class APIController { // Restful
	@RequestMapping(value = "/how", method = RequestMethod.POST)
	public String hi() {
		WebClient webclient;
		return "how";
	}
}
