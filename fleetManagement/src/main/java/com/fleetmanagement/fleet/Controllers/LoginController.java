package com.fleetmanagement.fleet.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController 
{

	@GetMapping("/usera")
	public String getUser() {
		return "Welcome, User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() 
    {
		return "Welcome, Admin";
	}
	
}
