package com.chandra.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		//System.out.println("111111111111111");
		model.addAttribute("name", "chandra");
		//System.out.println("222222222222222222");
		return "welcome";
	}
}
