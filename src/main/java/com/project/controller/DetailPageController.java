package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.PostDO;
import com.project.model.PostDao;
import com.project.model.PostSO;
import com.project.model.ReplyDO;
import com.project.model.ReplySO;

public class DetailPageController {

	@Autowired
	private PostSO postSo;
	@Autowired
	private ReplySO replySo;
	
//	@GetMapping("/detailPageProcess")
//	public String detailPageView(@RequestParam("post_id") long post_id, Model model) {
//		PostDO postInfo = postSo.getPostById(post_id);
//		model.addAttribute("postInfo", postInfo);
//
//		List<ReplyDO> repliesList = replySo.getRepliesByPostId(post_id);
//		model.addAttribute("repliesList", repliesList);
//		
//		return "detailPage";
//	}
	
	@GetMapping("/detailPage")
	public String clickPost2() {
		return "/detailPage";
	}
	
	
	
}
