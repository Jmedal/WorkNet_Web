package com.example.worknet.common.persistence.affair.user.controller;



import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.modal.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 注册页面（检查帐号是否存在）
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUserName")
    public String checkUserName(@RequestParam("username") String username){
        HashMap<String,String> map = new HashMap<>();
        if(userService.checkAccount(username)) //帐号存在返回true/帐号不存在返回false
            map.put("errorCode","error");
        else
            map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param rePassword
     * @return
     */
    @PostMapping(value = "/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("rePassword") String rePassword){
        HashMap<String,String> map = new HashMap<>();
        if(!userService.checkAccount(username) && password!=rePassword){
            User user = new User();
            user.setAccount(username);
            user.setPassword(password);
            user.setActivity(1);
            user.setRole(3);
            if(userService.userRegister(user))
                map.put("errorCode","error");
            else
                map.put("errorCode","00");
        }else{
            map.put("errorCode","error");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param remember
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("remember") boolean remember,
                        HttpServletRequest request){
        HashMap<String,String> map = new HashMap<>();
        if(userService.verify(username,password)){
            User user = userService.selectOne(new EntityWrapper<User>().eq("account",username));
            request.getSession().setAttribute("userId",user.getId());
            map.put("errorCode","00");
        }else
            map.put("errorCode","error");
        logger.info("account:"+username);
        logger.info("password:"+password);
        return JSON.toJSONString(map);
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "/getUserInfo")
    public String getUid(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId")!=null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            HashMap<String,Object> userInfo = new HashMap<>();
            userInfo.put("uid",userId);
            userInfo.put("nickname",userService.getNickname(userId));
            map.put("returnObject",userInfo);
            map.put("errorCode","00");
        }
       else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 登出
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("userId");//登出
        response.sendRedirect("/index");
        return "";
    }









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

