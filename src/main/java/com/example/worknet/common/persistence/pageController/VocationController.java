package com.example.worknet.common.persistence.pageController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VocationController {

    //直接选择目标职业
    @RequestMapping(value = "/vocation/select")
    public String VS(){
        return "select.html";
    }

    //返回笔试测试页面
    @RequestMapping(value = "/exam/{examId}/do-exam")
    public String examing(@PathVariable Integer examId){
        return "examing.html";
    }
}