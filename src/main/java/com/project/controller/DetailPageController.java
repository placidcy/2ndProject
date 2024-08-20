package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.model.*;
import com.project.model.response.LoginUserResponse;

import jakarta.servlet.http.*;

@Controller
public class DetailPageController {

	@Autowired
	private PostDao postDao;
	@Autowired
	private ReplySO replySO;
	@Autowired
	private ReplyDao replyDao;

	
	@GetMapping("/detailPageProcess")
	public String detailPageView(@RequestParam(value="post_id") long post_id, Model model) {
		PostDO postInfo = postDao.getPostById(post_id);
		model.addAttribute("postInfo", postInfo);

		List<ReplyDO> repliesList = replySO.getRepliesByPostId(post_id);
		model.addAttribute("repliesList", repliesList);
		
		return "detailPage";
	}
	
	@PostMapping("/submitReply")
	public String submitReply(ReplyDO reply, HttpSession session, Model model) {

		LoginUserResponse auth = (LoginUserResponse) session.getAttribute("auth");
		String user_id = auth.getUser_id();
		if(user_id == null) {
			return "redirect:/login";
		}
		else {
			replyDao.insertReply(reply);
			
			PostDO postInfo = postDao.getPostById(reply.getPost_id());
			model.addAttribute("postInfo", postInfo);

			List<ReplyDO> repliesList = replySO.getRepliesByPostId(reply.getPost_id());
			model.addAttribute("repliesList", repliesList);
			
			return "detailPage";
		}
		
	}
	
	@GetMapping("/detailTest")
	public String detailPageView() {
		return "detailPage";
	}
	
	
}
