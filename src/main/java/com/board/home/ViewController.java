package com.board.home;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
public class ViewController {
	
	@RequestMapping(value="/analysis", method=RequestMethod.POST) //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public String home(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("@@@");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		if(gender=="M") gender="남성";
		else gender="여성";
		System.out.println(name+", " + age +", " + gender);
		return "/home";
	}
}
