package com.project.controller;

import com.project.model.PostDO;
import com.project.model.PostSO;
import com.project.model.request.LoginRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	
	@GetMapping("/main")	 
	public String mainHandler(Model model) {
//		List<PostDO> postList = postService.getAllPost();
		return "main/main";
	}

}
