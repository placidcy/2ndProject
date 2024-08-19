package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.*;

@Controller
public class DetailPageController {

	@Autowired
	private PostSO postSO;
	@Autowired
	private ReplySO replySO;
	
	@GetMapping("/detailPageProcess")
	public String detailPageView(@RequestParam("post_id") long post_id, Model model) {
		PostDO postInfo = postSO.getPostById(post_id);
		model.addAttribute("postInfo", postInfo);

		List<ReplyDO> repliesList = replySO.getRepliesByPostId(post_id);
		model.addAttribute("repliesList", repliesList);
		
		return "detailPage";
	}
	
	
	
}
