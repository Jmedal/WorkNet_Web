package com.example.worknet.common.persistence.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(){
        return "/login/login.html";
    }
    @RequestMapping(value = "/sign-up")
    public String signUp(){
        return "/login/sign-up.html";
    }
    @RequestMapping(value = "/login/forgot")
    public String forget() {
        return "/login/forget.html";
    }
}
