package com.project.controller;

import com.project.model.UserDO;
import com.project.model.UserSO;
import com.project.model.request.LoginRequest;
import com.project.model.request.SignupRequest;
import com.project.model.request.editProfileRequest;
import com.project.model.response.LoginUserResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    final UserSO userSO;
 
    public UserController(UserSO userSO) {
        this.userSO = userSO;
    }

    @GetMapping("/login")
    public String loginHandler() {
        return "login";
    }

    @PostMapping("/loginProcess")
    public String loginProcessHandler(LoginRequest request, HttpSession session, HttpServletResponse response) {
        try {
            LoginUserResponse auth = userSO.login(request.getUser_id(), request.getPassword());

            session.setAttribute("auth", auth);

            LoginUserResponse print = (LoginUserResponse) session.getAttribute("auth");
            System.out.println("session = " + print.getUser_id());
            Cookie cookie = new Cookie("user_id", request.getUser_id());
            if(request.isRememberId()) {
            	cookie.setMaxAge(24*60*60*30);
            }
            else {
            	cookie.setMaxAge(0);
            }
            response.addCookie(cookie);

            return "redirect:/main";
        } catch (Exception e) {
            session.setAttribute("loginFailMsg", "로그인에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/login";
        }
    }

    @GetMapping("/signup")
    public String signupHandler() {
        return "signup";
    }

    @PostMapping("/signupProgress")
    public String signupProgressHandler(SignupRequest request, HttpSession session) {
        try {
            userSO.SignupUser(request);
            return "redirect:/main";
        } catch (Exception e) {
            session.setAttribute("signupFailMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/signup";
        }
    }

    @GetMapping("/editProfile")
    public String editProfileHandler() {
        return "editProfile";
    }

    @PostMapping("/editProfileProgress")
    public String editProfileHandler(UserDO userDO, editProfileRequest request, HttpSession session) {
        try {
            LoginUserResponse user = (LoginUserResponse)session.getAttribute("auth");
            String user_id = user.getUser_id();
            userSO.editProfile(user_id, request);
            return "redirect:/editProfile";
        }
        catch(Exception e) {
            session.setAttribute("editProfileFailMsg", "프로필 수정에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/editProfile";
        }
    }

    @GetMapping("/logout")
    public String logoutHandler(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

//    @PostMapping("/loginProcess")
//    public String loginProcessHandler(UserDO userInfo, HttpSession session, HttpServletResponse response) {
//        String view = "redirect:/login";
//
//        if(userSO.checkLogin(userInfo.getUser_id(), userInfo.getPassword())) {
//            session.setAttribute("user_id", userInfo.getUser_id());
//            if(userInfo.isRememberId()) {
//                Cookie cookie = new Cookie("user_id", userInfo.getUser_id());
//                response.addCookie(cookie);
//            }
//
//            view = "redirect:/main";
//        }
//        return view;
//    }
}
