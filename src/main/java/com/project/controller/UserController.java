package com.project.controller;

import com.project.model.PostSO;
import com.project.model.ReplySO;
import com.project.model.UserDO;
import com.project.model.UserSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    final PostSO postSO;
    final ReplySO replySO;

    @Autowired
    public UserController(UserSO userSO, PostSO postSO, ReplySO replySO) {
        this.userSO = userSO;
        this.postSO = postSO;
        this.replySO = replySO;
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

            int postCount = postSO.countPostCountByUserId(request.getUser_id());
            int replyCount = replySO.countReplyCountByUserId(request.getUser_id());
           
            session.setAttribute("postCount", postCount);
            session.setAttribute("replyCount", replyCount);

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
    public String editProfileHandler(HttpSession session, Model model) {
        LoginUserResponse user = (LoginUserResponse) session.getAttribute("auth");

        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("user_id", user.getUser_id());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("name", user.getName());

        return "editProfile";
    }

    @PostMapping("/editProfileProgress")
    public String editProfileHandler(editProfileRequest request, HttpSession session) {
        try {
            userSO.editProfile(request);

            LoginUserResponse auth = (LoginUserResponse) session.getAttribute("auth");

            UserDO updatedUser = userSO.getUserById(auth.getUser_id());
            LoginUserResponse updatedAuth = new LoginUserResponse(
                    updatedUser.getUser_id(),
                    updatedUser.getNickname(),
                    updatedUser.getName(),
                    updatedUser.getEmail()
            );

            session.setAttribute("auth", updatedAuth);
            return "redirect:/main";
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
