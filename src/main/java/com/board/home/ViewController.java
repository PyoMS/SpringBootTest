package com.board.home;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.home.VO.UserVO;

@Controller
public class ViewController {
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	
	@RequestMapping(value="/analysis", method=RequestMethod.POST) //RequsetMapping은 기본적으로 GET 방식으로 교환한다. method 설정 시 POST 전환.
	public void analysis(HttpServletRequest request, HttpServletResponse response ) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		System.out.println(name+", " + age +", " + gender);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name", name);
		jsonobject.put("age", age);
		jsonobject.put("gender", gender);
		try {
//			logger.info(jsonobject.toString()); // test
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		
//		return "/home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST) 
	public String home(HttpServletRequest request, Model model ) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		try {
			model.addAttribute("name", name);
			model.addAttribute("age", age);
			model.addAttribute("gender", gender);
		} catch (Exception e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		return "/home";
	}
	
	// @ModelAttribute 가 형변환도 알아서 처리함.
	@RequestMapping(value="/enrollment", method=RequestMethod.POST)
	public String enrollment(@ModelAttribute("userInfo")UserVO userVO, Model model ) {
		System.out.println("@enrollment");
		try {
			model.addAttribute("name", userVO.getName());
			model.addAttribute("age", userVO.getAge());
			model.addAttribute("gender", userVO.getGender());
		} catch (Exception e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
		return "/home";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.POST) 
	public String error(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("error");
		return "/error";
	}
}
