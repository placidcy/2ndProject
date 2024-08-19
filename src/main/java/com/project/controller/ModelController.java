package com.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	public String changePasswdProcessHandler() {
		return "redirect:/main";
	}
	
	@GetMapping("/postForm")	 
	public String postFormHandler(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if(session != null) {
			String user_id = (String)session.getAttribute("user_id");
			model.addAttribute("postCount", postDao.countPost(user_id));	
			model.addAttribute("replyCount", replyDao.countReply(user_id));
		}
		return "postForm";
	}
	
	@PostMapping("/postFormProcess")
	public String postFormProcessHandler(PostDO postDO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			String user_id = (String)session.getAttribute("user_id");
			postDao.insertPost(postDO, user_id);
		}
		return "main";
	}
	
	@GetMapping("/login")	 
	public String loginHandler() {
		return "login";
	}
	
	@PostMapping("/loginProcess")	 
	public String loginProcessHandler(UserDO userInfo, HttpSession session, HttpServletResponse response) {
		String view = "redirect:/login";
		
		if(userSO.checkLogin(userInfo.getUser_id(), userInfo.getPassword())) {
			session.setAttribute("user_id", userInfo.getUser_id());
			if(userInfo.isRememberId()) {
				Cookie cookie = new Cookie("user_id", userInfo.getUser_id());
				response.addCookie(cookie);	
			}
			
			view = "redirect:/main";
		}
		return view;
	}
	
	@GetMapping("/main")	 
	public String mainHandler(Model model) {
//		List<PostDO> postList = postService.getAllPost();
		return "main";
	}
	
	@GetMapping("/detailPage")
	public String detailPageView() {
		return "detailPage";
	}
	
	@GetMapping("/findID")
	public String findIDHandler() {
		return "findID";
	}
	
	@GetMapping("/agreement")
	public String agreementHandler() {
		return "agreement";
	}
	
	
}
