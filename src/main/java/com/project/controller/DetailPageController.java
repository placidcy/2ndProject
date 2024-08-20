package com.project.controller;

import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.model.*;

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
	public String submitReply(@RequestParam("post_id") long post_id,
			@RequestParam("user_id") String user_id,
			@RequestParam("content") String content,
			Model model) {

		ReplyDO reply = new ReplyDO();
		reply.setUser_id(user_id);
		reply.setPost_id(post_id);
		reply.setContent(content);
		reply.setLikes(0);
		
		replySO.addReply(reply);
		
		return "detailPage";
	}
	
	@GetMapping("/detailTest")
	public String detailPageView() {
		return "detailPage";
	}
	
	
}
