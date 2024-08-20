package com.project.controller;

import com.project.model.ReplySO;
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

    @PostMapping("/reply-like")
    public String likeReply(int reply_id, Session session, int post_id) {

        String user_id = (String) session.getUserProperties().get("user_id");
        replySO.likeReply(reply_id, user_id);

        return "redirect:/post/" + post_id;
    }

}
