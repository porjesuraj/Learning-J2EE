package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mande
public class HomeController {

	public HomeController() {
	
		System.out.println(" in constr of " + getClass().getName());

	}
	
	// add a req handling method to return home page(index.jsp
	
	@RequestMapping("/")
	public String showHomePage(Model map) {
		
		System.out.println("in show home page");
		
		map.addAttribute("time", LocalDateTime.now()); 
		
		return "/index"; 
	}
	
}
