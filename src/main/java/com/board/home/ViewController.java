package com.board.home;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
//	@RequestMapping("/") 
//	public String indexpage() { return "/index"; }
	
	@RequestMapping(value="/analysis", method=RequestMethod.POST) //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public void analysis(HttpServletRequest request, HttpServletResponse response ) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		if(gender.equals("M")||gender=="M") gender="남성";
		else gender="여성";
		System.out.println(name+", " + age +", " + gender);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name", name);
		jsonobject.put("age", age);
		jsonobject.put("gender", gender);
		try {
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		return "/home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET) //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public String home(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("@home");
		return "/home";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.POST) //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public String error(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("error");
		return "/error";
	}
}
