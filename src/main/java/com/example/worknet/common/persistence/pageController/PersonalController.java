package com.example.worknet.common.persistence.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * 所有前缀为personal的路径访问静态资源
 */
@RequestMapping(value = "/personal")
public class PersonalController {
    @RequestMapping(value = "/index")
    public String index(){
        return "/personal/index.html";
    }
    @RequestMapping(value = "/indexInner")
    public String indexInner(){
        return "/personal/indexInner.html";
    }
    @RequestMapping(value = "/myProjectInner")
    public String myProjectInner(){
        return "/personal/myProjectInner.html";
    }
    @RequestMapping(value = "/myMsgInner")
    public String myMsgInner(){
        return "/personal/myMsgInner.html";
    }
    @RequestMapping(value = "/gearInner")
    public String gearInner(){
        return "/personal/gearInner.html";
    }

    @RequestMapping(value = "/myMsg_reply")
    public String myMsg_reply(){
        return "/personal/myMsg_reply.html";
    }
    @RequestMapping(value = "/myMsg_write")
    public String myMsg_write(){
        return "/personal/myMsg_write.html";
    }
    @RequestMapping(value = "/myMsg_system")
    public String myMsg_system(){
        return "/personal/myMsg_system.html";
    }

}
