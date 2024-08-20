package com.project.controller;

import com.project.model.PostSO;
import com.project.model.response.PostMainResponse;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostSO postSO;

    public PostController(PostSO postSO) {
        this.postSO = postSO;
    }

    @GetMapping("/main")
    public String mainHandler(Model model) {
		PostMainResponse postList = postSO.getAllPost();
        model.addAttribute("postList", postList.getPostList());
        return "/main";
    }

    @GetMapping("/search")
    public String searchHandler(String keyword, Model model) {
        PostMainResponse postList = postSO.search(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("postList", postList.getPostList());
        return "/main";
    }

    @GetMapping("/search-position")
    public String searchPositionHandler(String position, Model model) {
        PostMainResponse postList = postSO.searchPosition(position);
        model.addAttribute("keyword", position);
        model.addAttribute("postList", postList.getPostList());
        return "/main";
    }


}
