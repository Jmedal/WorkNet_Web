package com.example.worknet.common.persistence.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController2 {
    @RequestMapping(value = "/exam/{eid}/")
    public String examDetail(@PathVariable Integer eid){
        return "exam_detail.html";
    }
}

