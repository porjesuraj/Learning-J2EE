package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @RestController = @Controller : at the class level
//+ @ResponseBody over all req handling methods annotated by @ReqMapping /@GetMapping 

@RequestMapping("/dummy")
public class DummyController {

	public DummyController() {
	
		System.out.println(" in ctor of dummy controller");
		// TODO Auto-generated constructor stub
	}
	
	// add req handling method to return representation(JSON) of list of nums  
	@GetMapping("/nums")
	public List<Integer> testMe()
	{
		System.out.println("in test me");
		
		return Arrays.asList(1,2,3,4,5,6,7,8); 
		
	}
	
}
