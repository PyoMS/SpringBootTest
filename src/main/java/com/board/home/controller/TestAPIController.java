package com.board.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.home.service.TestAPIService;

@RestController
public class TestAPIController {
	private static final Logger logger = LoggerFactory.getLogger(TestAPIController.class);
	final TestAPIService testAPIService;
	
	@Autowired
	public TestAPIController(TestAPIService testAPIService) {
		this.testAPIService = testAPIService;
	}
	
	@GetMapping("/darttest")
	public String TestDart(Model model) {
		String response = testAPIService.getDartTest();
		model.addAttribute("response", response);
		logger.info(response);
		return response;
	}
}
