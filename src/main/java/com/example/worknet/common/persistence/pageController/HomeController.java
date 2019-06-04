package com.example.worknet.common.persistence.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * 所有get访问的页面都在该Controller下实现
 */
public class HomeController {
    @RequestMapping(value = {"/index","/"})
    public String index(){
        return "index.html";
    }
    @RequestMapping(value = "/courses")
    public String courses(){
        return "courses.html";
    }
    @RequestMapping(value = "/exam")
    public String exam(){
        return "exam.html";
    }
    @RequestMapping(value = "/course/{cid}/")
    public String course(@PathVariable String cid){
        return "/course_detail.html";
    }
    @RequestMapping(value = "/course/{cid}/moreComment")
    public String moreComment(@PathVariable Integer cid){
        return "comment.html";
    }
    @RequestMapping(value = "/course/{cid}/video/")
    public String video(@PathVariable Integer cid){
        return "video.html";
    }
    @RequestMapping(value = "/contact")
    public String contact(){
        return "contact.html";
    }
}
