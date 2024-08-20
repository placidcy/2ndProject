package com.project.controller;

import com.project.model.PostDO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.PostDao;
import com.project.model.PostSO;
import com.project.model.ReplyDO;
import com.project.model.ReplyDao;
import com.project.model.ReplySO;
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
			model.addAttribute("hotPostList", postDao.hotPost());
		}
		return "postForm";
	}
	
	@GetMapping("/postModify")
	public String postModifyHandler(@RequestParam(value="post_id") long post_id, HttpSession session, Model model) {
		LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
		String user_id = user.getUser_id();
		PostDO post = postDao.getPostById(post_id);
		if(user_id != null && user_id.equals(post.getUser_id())) {
			model.addAttribute("postInfo", post);
			model.addAttribute("postCount", postDao.countPost(user.getUser_id()));	
			model.addAttribute("replyCount", replyDao.countReply(user.getUser_id()));
			model.addAttribute("hotPostList", postDao.hotPost());
			return "postForm";	
		}
		return "redirect:/detailPageProcess?post_id=" + post_id + "&commentCount=0";
		
	}
	
	@PostMapping("/postFormProcess")
	public String postFormProcessHandler(PostDO postDO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
			postDao.insertPost(postDO, user.getUser_id());
		}
		return "redirect:/main";
	}
	
	@PostMapping("/postUpdate")
	public String postUpdateHandler(PostDO postDO) {
		postDao.updatePost(postDO);
		return "redirect:/detailPageProcess?post_id=" + postDO.getPost_id() + "&commentCount=0";
	}
	
	@GetMapping("/findID")
	public String findIDHandler() {
		return "findID";
	}
	
	@GetMapping("/agreement")
	public String agreementHandler() {
		return "agreement";
	}
	
	@GetMapping("/postDelete")
	public String postDeleteHandler(PostDO postInfo, @RequestParam(value="user_id") String user_id, Model model) {
		
		return "redirect:/main";
	}
	
	
}
