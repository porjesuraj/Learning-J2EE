package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller //  mandetory 
@RequestMapping("/user") // optional but recommended
public class UserController {

	// dependency : service layer
	 
	@Autowired
	private IVendorService vendorService; 
	
	public UserController() {
	
		System.out.println("in contsr of " + getClass().getName() + vendorService); //null
		
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("in user controller init " + vendorService); // not null 
		}
	
	//add request handling method : to show login form  
	@GetMapping("/login")
	public String showLogin() {
		System.out.println("in show login form");
		return "/user/login"; // actual view name  : /WEB-INF/user/login.jsp
	}
	

	// add req handling method = post : to process the form 
	@PostMapping(value = "/login")
	public String processLoginForm(@RequestParam String email,@RequestParam String password,
			Model map,HttpSession session, RedirectAttributes flashMap ) {
		//String email = request.getParamter("email") 
		// RedirectAttributes : i/f => used in redirect scenario to store the attributes, till the next request 
		
		
		System.out.println("in process login form" + email + " " + password);
		// invoke service layer method for execute B.L
		
		try {
			Vendor validatedUser = vendorService.authenticateUser(email, password); 	
			// => valid login 
			// add validated user details under session scope 
			session.setAttribute("user_details", validatedUser);
			
			//scope : til the next reuqest
		  flashMap.addFlashAttribute("message", "Login Successfully : " + validatedUser.getUserRole()); 
			// check the role 
			
			if(validatedUser.getUserRole().equals(Role.ADMIN))
				return "redirect:/admin/list"; // redirect view name 
			// controller send redirect view naem to D.S
			// D.S : skips view resolver and invokes Url rewriting 
			// SC : response.sendRedirect(response.encodeRedirectURl(".admin.list")); 
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
			
			System.out.println("err in process login form " + e); // NOResultException 
			// in case of a failure :FORWAD client to login form : highlighted with error message
			
			map.addAttribute("msg", "Invalid Login ,Pls retry..."); 
			// default server pull : so same request sent 
			return "/user/login"; // logical view name
			//acutal view name : .WEB-INF/views/user/login/  	
		}	
	}
	
	
	
// add request handling method for user logout 
	
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map, HttpServletResponse response
			, HttpServletRequest request) {
		
		System.out.println(" in users  logout");
		
		// get user details from HttpSession and add it to the model map 
		map.addAttribute("user", hs.getAttribute("user_details"));
		
		// discard HttpSession 
		hs.invalidate();
		// To navigate client from logout page to index page : after a delay 
		// set Http response header : name ==> refresh, value = 10; url = http://host:port/day14_boot (context path)
		// where 10 = delay 
		System.out.println("ctx path " + request.getContextPath()); // /day14_boot
		
		response.setHeader("refresh", "5;url=" + request.getContextPath());
		// response code : SC 200 | refresh :  location/day_boot | body contents : not EMPTY (hello user ... from jsp)
		// after delay of 5 second : client browser :  generates a new request 
		
		
		return "/user/logout";   // user controller --> D.S : logocal view name ---> view Resolver
		// actual view name : /WEB_INF/views/user/logout.js
	}
	
}











