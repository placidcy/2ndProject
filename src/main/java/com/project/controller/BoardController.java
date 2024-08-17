package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/login") 		// http://localhost:8080/login
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/detailPage")
	public String detailPageView() {
		return "detailPage";
	}
}
