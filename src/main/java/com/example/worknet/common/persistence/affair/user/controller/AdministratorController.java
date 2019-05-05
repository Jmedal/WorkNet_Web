package com.example.worknet.common.persistence.affair.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}

