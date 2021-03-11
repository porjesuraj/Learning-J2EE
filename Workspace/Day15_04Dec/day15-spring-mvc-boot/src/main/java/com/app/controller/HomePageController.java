package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandetory
public class HomePageController {
	
	public HomePageController() {
		
		System.out.println("in constructor of " + getClass().getName()); 
}
	
	// add a req handling method to return home page(index page)
	
	@RequestMapping("/")
	public String showHomePage(Model map) {
		
		System.out.println("in show home page");
		
		map.addAttribute("time", LocalDateTime.now()); 
		
		return "/index"; 
		
	}
	

}
