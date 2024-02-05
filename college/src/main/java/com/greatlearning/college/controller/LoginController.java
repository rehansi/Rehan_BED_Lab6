package com.greatlearning.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	public String showLogin() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String accessdenaied() {
		return "access-denied";
	}


}
