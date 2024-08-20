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
	public String detailPageView(ReplyDO replyDO, @RequestParam(value="commentCount") long commentCount, Model model) {
		PostDO postInfo = postDao.getPostById(replyDO.getPost_id());
		model.addAttribute("postInfo", postInfo);
		
		List<ReplyDO> repliesList = replySO.getRepliesByPostId(replyDO.getPost_id());
		model.addAttribute("repliesList", repliesList);
		
		model.addAttribute("commentCount", commentCount);
		if(replyDO.getReply_id() != 0) {
			model.addAttribute("modifyReply", replyDao.getReplyById(replyDO.getReply_id()).getContent());	
		}
		
		
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
			
			return "redirect:/detailPageProcess?post_id=" + postInfo.getPost_id() + "&commentCount=0";
		}
		
	}

	
}
