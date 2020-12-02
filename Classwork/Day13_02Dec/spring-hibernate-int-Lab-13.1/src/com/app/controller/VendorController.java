package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	
	public VendorController() {
	System.out.println("in contr of " + getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/details")
	public String showVendorDetails()
	{
		System.out.println("in show vendor details ");
		
		return "/vendor/details"; // forward
		
		// acutal view name : /WEB-INF/views/vendor/details.jsp 
	}
}
