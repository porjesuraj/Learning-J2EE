package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller // mandetory
@RequestMapping("/admin")
public class AdminController {

	//dependency : vendor service
	
	@Autowired
	private IVendorService vendorService; 
	
	public AdminController() {
	System.out.println("in contr of " + getClass().getName());
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
	public String showVendorList(Model map)
	{
		System.out.println("in show vendor list");

		List<Vendor> list = vendorService.listAllVendors();
		// save current vendor list under model map --> auto saved under current request scope
		map.addAttribute("vendor_list",list); 
		return "/admin/list"; // forward 
		// actual view name retuned by view resolver : /WEB-INF/views/admin/list.jsp
		
	}
	
	// add request handing method 
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid, RedirectAttributes flashMap) {
		
		String deleteMessage = vendorService.deleteVendorDetails(vid); 
		flashMap.addFlashAttribute("deleteMsg", deleteMessage);
		
		
		// client pull : redirect scenario
		return "redirect:/admin/list"; 
	}
	
	// add req handling method to show vendor registeration form 
	@GetMapping("/register")
	public String showRegForm(Vendor vendor) {
		// add empty vendor POJO instance in model map
		
		System.out.println(" in show reg form");
		// add empty vendor POJO instance in model map 
		//map.addAttribute("vendor_dtls", new Vendor()); 
		return "/admin/register"; // actual view name : /WEB-INF/views/admin/register.jsp
	}
	
	@PostMapping("/register")
	public String processRegForm(@Valid Vendor v,BindingResult result,RedirectAttributes flashMap) {
		
		// SC: by def: modelmap,getAttribute("vendor") -- empty POJO -- setters + apply validation rules --- populated transient POJo
	// results of data binding are stored under BindingResult 
		System.out.println("in process reg form " + v); // v: TRANSIENT 
	
		v.setUserRole(Role.VENDOR);
		// check for P.L validtion error 
		if(result.hasErrors())
		{
			System.out.println("P.L error in Data Binding " + result);
		 // navigate the client back to reg form : highlighted with errors 
			// forward : Server Pull 
			return "/admin/register"; 
		
		}
		System.out.println("NO P.L errors ... continuing with B.L");
		
		flashMap.addFlashAttribute("message", vendorService.addVendor(v)); 
		
		return "redirect:/admin/list"; // redirect view name 
		
	}

	
	
	
}
