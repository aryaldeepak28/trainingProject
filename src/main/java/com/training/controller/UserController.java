package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/register")
	public String register() {
        return "RegisterUser.html";
    }
	@GetMapping("/viewUsers")
	public String viewUsers() {
		return "ViewUsers.html";
	}
}
