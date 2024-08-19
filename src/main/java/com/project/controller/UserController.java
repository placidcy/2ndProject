package com.project.controller;

import com.project.model.UserSO;
import com.project.model.request.LoginRequest;
import com.project.model.response.LoginUserResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    final UserSO userService;

    @Autowired
    public UserController(UserSO userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginHandler() {
        return "login/login";
    }

    @PostMapping("/loginProcess")
    public String loginProcessHandler(LoginRequest request, HttpSession session) {
        String nickname = userService.login(request.getUser_id(), request.getPassword());
        if(nickname != null) {
            LoginUserResponse response = new LoginUserResponse(request.getUser_id(), nickname);

            session.setAttribute("auth", response);

            System.out.println("session = " + session.getAttribute("auth"));
            return "redirect:/main";
        } else {
            session.setAttribute("loginFailMsg", "로그인에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/login";
        }
    }
}
