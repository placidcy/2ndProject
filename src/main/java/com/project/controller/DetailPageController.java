package com.project.controller;

import java.util.*;

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
	private PostSO postSO;
	@Autowired
	private ReplySO replySO;
	@Autowired
	private ReplyDao replyDao;


	@GetMapping("/detailPageProcess")
	public String detailPageView(ReplyDO replyDO, @RequestParam(value="commentCount") long commentCount, Model model) {
		model.addAttribute("hotPostList", postDao.hotPost());

		PostDO postInfo = postDao.getPostById(replyDO.getPost_id());
		model.addAttribute("postInfo", postInfo);
		
		List<ReplyDO> repliesList = replySO.getRepliesByPostId(replyDO.getPost_id());
		model.addAttribute("repliesList", repliesList);

		
		model.addAttribute("commentCount", commentCount);
    
		if(replyDO.getReply_id() != 0) {
			model.addAttribute("modifyReply", replyDao.getReplyById(replyDO.getReply_id()).getContent());	
			model.addAttribute("modifyReply_id", replyDO.getReply_id());
		}
		
		model.addAttribute("commentCount", commentCount);

		model.addAttribute("postList", postSO.updateViewCount(replyDO.getPost_id()).getPostList());

		return "detailPage";
	}
	
	
	@PostMapping("/submitReply")
	public String submitReply(ReplyDO reply, @RequestParam long commentCount, HttpSession session, Model model) {

		LoginUserResponse auth = (LoginUserResponse) session.getAttribute("auth");
		if(auth == null) {
			return "redirect:/login";
		}
		else {
//			replyDao.insertReply(reply);
//
//			List<ReplyDO> repliesList = replySO.getRepliesByPostId(reply.getPost_id());
//			model.addAttribute("repliesList", repliesList);

			replyDao.insertReply(reply);	
			int replyCount = replySO.countReplyCountByUserId(auth.getUser_id());
			session.setAttribute("replyCount", replyCount);
			return "redirect:/detailPageProcess?post_id=" + reply.getPost_id() + "&commentCount=" + commentCount;
		}
	}		
}
	
	

