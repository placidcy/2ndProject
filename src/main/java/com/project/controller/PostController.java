package com.project.controller;

import com.project.model.PostSO;
import com.project.model.response.PostMainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final PostSO postSO;

    @Autowired
    public PostController(PostSO postSO) {
        this.postSO = postSO;
    }

    @GetMapping("/main")
    public String mainHandler(Model model) {
		PostMainResponse postList = postSO.getAllPost();
        model.addAttribute("postList", postList.getPostList());
        return "main/main";
    }


}
