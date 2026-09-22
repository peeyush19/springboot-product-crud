package com.itvedant.basics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello everyone";
	}
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hi everyone";
	}
	
	@GetMapping
	public String home() {
		return "Welcome home";
	}
}
