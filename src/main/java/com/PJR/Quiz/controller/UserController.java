package com.PJR.Quiz.controller;

import com.PJR.Quiz.entity.User;
import com.PJR.Quiz.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //go to "loginForm.html"
    @GetMapping("/loginForm")
    public String login() {return "loginForm";}

    //go to "signUpForm.html"
    @GetMapping("/signUpForm")
    public String signUpForm() {return "signUpForm";}

    @PostMapping("/signUpSave")
    public String signUp(User user){
        User u = userService.signUp(user);

        return "index";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(User user, HttpServletRequest request) {
        //회원 확인
        String loginResult= userService.loginCheck(user);
        HttpSession session = request.getSession();
        if(loginResult.equals("YES")){
            log.info("==회원임==");
            session.setAttribute("user_id",user.getUserName());
        } else {
            log.info("==회원아님==");
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }

}
