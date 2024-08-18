package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelController {
	
	@GetMapping("/changePasswd")	 
	public String changePasswdHandler() {
		return "changePasswd";
	}
	
	@GetMapping("/postForm")	 
	public String postFormHandler() {
		return "postForm";
	}
	
	@PostMapping("/postFormProcess")
	public String postFormProcessHandler() {
		return "main/main";
	}
	
	@GetMapping("/login")	 
	public String loginHandler() {
		return "login/login";
	}
	
	@PostMapping("/loginProcess")	 
	public String loginProcessHandler() {
		return "main/main";
	}
	
	@GetMapping("/main")	 
	public String mainHandler() {
		return "main/main";
	}

	@GetMapping("/signup")
	public String signupHandler() {
		return "signup/signup";
	}

	@GetMapping("/editProfile")
	public String editProfileHandler() {
		return "profile/editProfile";
	}

	
	
	
	
	
}
