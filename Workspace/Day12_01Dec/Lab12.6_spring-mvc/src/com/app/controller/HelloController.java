package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	// add request handling method to test o.s.w.s.ModelAndView 	
	@RequestMapping("/test2")
	public ModelAndView sayhello2() {
		System.out.println("in test 2 ");
		//o.s.w.s.Model and View  :holder for holding ModelAttribute  + logical view name  :class
		// consructor ModelAndView(String logicalViewName,String modelAttrName,Object modelAttrValue)
		// def scope model attr : current request only 
		
		return new ModelAndView("/welcome", "time", LocalDateTime.now()); 
		// request handling controller returning logical view name + 1 model Attr ---> DS 
	}
	// add request handling methods to Test Map 
		// o.s.ui.Model: i/f => holder of Model attributes
		// How to add attributes  ? Model addAttribute(String modelAttrName,Object modelAttrVal)
		// IOC : simply tell SC : to inject EMPTY model map in the request handling method : D.I by 
		// : by adding an argument to req handling method
	@RequestMapping("/test3")
	public String sayhello3(Model map) {
		System.out.println("in test 3");
		
		map.addAttribute("date", LocalDate.now())
		.addAttribute("list", Arrays.asList(10,20,30,40,50)); 
		
		return "/welcome"; 
		
		
	}
	
}
