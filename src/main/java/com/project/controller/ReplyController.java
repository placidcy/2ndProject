package com.project.controller;

import com.project.model.ReplySO;
import com.project.model.response.LoginUserResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {

    private final ReplySO replySO;

    @Autowired
    public ReplyController(ReplySO replySO) {
        this.replySO = replySO;
    }

//    @PostMapping("/reply-like")
//    public String likeReply(int reply_id, HttpSession session, int post_id) {
//
//        LoginUserResponse auth = (LoginUserResponse) session.getAttribute("auth");
//        String user_id = auth.getUser_id();
//        replySO.likeReply(reply_id, user_id);
//        return "redirect:/detailPageProcess?post_id=" + post_id;
//    }
    
    @PostMapping("/reply-like")
    public String likeReply(int reply_id, HttpSession session, long post_id, long commentCount) {

        LoginUserResponse auth = (LoginUserResponse) session.getAttribute("auth");
        String user_id = auth.getUser_id();
        replySO.likeReply(reply_id, user_id);
        return "redirect:/detailPageProcess?post_id=" + post_id + "&commentCount=" + commentCount;
    }

}
