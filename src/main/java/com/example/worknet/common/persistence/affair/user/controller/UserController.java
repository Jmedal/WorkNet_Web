package com.example.worknet.common.persistence.affair.user.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.constant.Const;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.core.utils.FileToolsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/updateAvatar")
    public ResponseEntity upLoadPicture(@RequestParam(value = "id")long userId,
                                        MultipartHttpServletRequest request)throws Exception{
        try {
            return ResponseEntity.ok(userService.updateAvatar(userId,request));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAvatar/{id}")
    public ResponseEntity downLoadPicture(@PathVariable("id") long userId ,
                                          HttpServletRequest request){
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        logger.info(strDirPath);
        String pp = request.getRequestURI();
        logger.info(pp);
        String path=request.getServletContext().getContextPath();
        logger.info(path);
        String realPath=request.getServletContext().getRealPath("/static");
        logger.info(realPath);
        try {
            return ResponseEntity.ok(userService.getAvatar(userId,strDirPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

