package com.project.controller;

import com.project.model.PostDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.PostDao;
import com.project.model.ReplyDao;
import com.project.model.UserSO;
import com.project.model.UserDO;
import com.project.model.response.LoginUserResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ModelController {
	
	@Autowired
	private UserSO userSO;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@GetMapping("/changePasswd")	 
	public String changePasswdHandler() {
		return "changePasswd";
	}
	
	@PostMapping("/changePasswdProcess")
	public String changePasswdProcessHandler(UserDO userDO, HttpSession session) {
		try {
			LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
			String user_id = user.getUser_id();
			userSO.changePassword(user_id, userDO.getOldPasswd(), userDO.getNewPasswd());
			return "redirect:/main";
		}
		catch(Exception e) {
			return "redirect:/changePasswd";
		}

	}
	
	@GetMapping("/postForm")	 
	public String postFormHandler(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(session != null) {
			LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
			model.addAttribute("postCount", postDao.countPost(user.getUser_id()));	
			model.addAttribute("replyCount", replyDao.countReply(user.getUser_id()));
		}
		return "postForm";
	}
	
	@PostMapping("/postFormProcess")
	public String postFormProcessHandler(PostDO postDO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
			postDao.insertPost(postDO, user.getUser_id());
		}
		return "main";
	}
	
	
	@GetMapping("/detailPage")
	public String detailPageView() {
		return "detailPage";
	}

	@GetMapping("/editProfile")
	public String editProfileHandler() {
		return "profile/editProfile";
	}
	
	
}
