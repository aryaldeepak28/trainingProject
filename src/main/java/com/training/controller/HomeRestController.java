package com.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeRestController {
	
	@GetMapping("/message") //localhost:8089/api/message
	public String getMessage() {
		return "Hello World";
	}
}