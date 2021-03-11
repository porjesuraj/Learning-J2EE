package com.app.controller;

import java.awt.Robot;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Component // mande
@RequestMapping("/user")
public class UserController {
    
	@Autowired
	private IVendorService vendorService;
	
	
	public UserController() {
	System.out.println(" in constr of" + getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	// add request handling method:  to show login form 
	
	@GetMapping("/login")
	public String showLogin() {
		
		System.out.println("in show login form ");

		return "/user/login"; 
		// acutal view name : /WEB-INF/views/user/login.jsp
	}
	
	@PostConstruct
	public void myInit() {
		
		System.out.println("in init of" + getClass().getName()  );
	}
	
	// add req handling method = post : to process the form 
	@PostMapping(value = "/login")
	public String processLoginForm(@RequestParam String email,@RequestParam String password,Model map,HttpSession session )
	{
		//String email = request.getParamter("email") 
		
		try {
			
		Vendor validatedUser	= vendorService.authenticateUser(email, password);
		// => valid login 
					// add validated user details under session scope
		
		session.setAttribute("user_details", validatedUser);
		
		
		// check role 
		
		if(validatedUser.getUserRole().equals(Role.ADMIN))
		return "redirect:/admin/list"; 
			// redirect view name 
						// controller send redirect view name to D.S
						// D.S : skips view resolver and invokes Url rewriting 
						// SC : response.sendRedirect(response.encodeRedirectURl("/admin/list")); 
						// SC gives it to WC and send redirect response packet  : 
						//Status code 302|location : /adm,in/list+jseesionId | body : empty
						// now client browser sends next request :
						// http://host:port/day13/admin/list; jSessionId="" 
						// and method will be get
			
		//id use  server pull   
		// return "/vendor/details"; 
		 // to avoid double submit issue  replace serve pull by client pull
		return "redirect:/vendor/details";
		// SC : will perform URL rewriting 
		// response.sendRedirect(response.encodeRedirectURL("/vendor/details")); 
		// and send response to client browser who will send a response to SC as 
		// /vendor/details  : at DS ---> ViewResolver , and normally process takes place
		
		
		
		} catch (RuntimeException e) {
			
			System.out.println(" err in process login form " + e);
			
			// forward to login form 
			
			map.addAttribute("msg", "Invalid Login,PLs retry ...");
			
			// default server pull, so same request send
			
			return "/user/login"; // logical view name
			
			//acutal view name : .WEB-INF/views/user/login/
			
		}
		
	}
	
	
	
}
