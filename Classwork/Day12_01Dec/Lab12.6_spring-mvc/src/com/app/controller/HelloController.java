package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandetory to tell SC: whatever follows is a req handling controller bean 
//spring bean : singleton and eager 
public class HelloController {

	public HelloController() {
	
		System.out.println("in constr of "  + getClass().getName());
		
		// TODO Auto-generated constructor stub
	}
	
	// to tell SC about request handling method : 
		// entry in Handler Mapping bean 
		// key = /hello 
		//value = com.app.controller.HelloController:sayHello()
	@RequestMapping("/test")
	public String sayHello() {
		
		System.out.println(" hello , its test 1");
		
		return "/welcome";
		// req handling controller returns 
		//: logical view name (forward view ) to D.S(Dispatcher Servlet)		
		
	}
}
