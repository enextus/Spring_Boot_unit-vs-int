package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	static {
		System.out.println("0. class HelloController() called...");
	}

	public HelloController() {
		System.out.println("constructor HelloController() called...");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Hello, %s!", name);
	}

	@GetMapping("/goodbye")
	public String goodbye(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Goodbye, %s!", name);
	}

	@GetMapping("/checkname")
	public String checkName(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Your name is, %s!", name);
	}

	@GetMapping("/")
	public String home(@RequestParam(name = "name", defaultValue = "Nobody") String name) {
		return String.format("Welcome at home, %s!", name);
	}

}
