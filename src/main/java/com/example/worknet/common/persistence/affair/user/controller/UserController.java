package com.example.worknet.common.persistence.affair.user.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.modal.LearnerInfo;
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
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 注册页面（检查帐号是否存在）
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUserName",method = RequestMethod.GET)
    public String checkUserName(@RequestParam(value = "username") String username){
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
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "rePassword") String rePassword){
        HashMap<String,String> map = new HashMap<>();
        if(!userService.checkAccount(username) && password.equals(rePassword)){
            User user = new User();
            user.setAccount(username);
            user.setPassword(password);
            user.setActivity(1);
            user.setRole(3);
            if(userService.userRegister(user))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "remember") boolean remember,
                        HttpServletRequest request){
        HashMap<String,String> map = new HashMap<>();
        if(userService.verify(username,password)){
            User user = userService.selectOne(new EntityWrapper<User>().eq("account",username));
            request.getSession().setAttribute("userId",user.getId());
            map.put("errorCode","00");
        }else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 获取用户昵称和id
     * @return
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public String getUid(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
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
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("userId");//登出
        response.sendRedirect("/index");
        return "";
    }

    /**
     * 获取个人信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/get/basicInfoAndCom",method = RequestMethod.GET)
    public String getPersonalInfo(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            HashMap<String,Object> userInfo = userService.getUserInfo(userService.selectById(userId));
            map.put("returnObject",userInfo);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 修改个人信息
     * @param nickname
     * @param realName
     * @param age
     * @param vocation
     * @param hobby
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/change/info",method = RequestMethod.POST)
    public String changeInfo(@RequestParam(value = "nickname")String nickname,
                             @RequestParam(value = "realName")String realName,
                             @RequestParam(value = "age")Integer age,
                             @RequestParam(value = "vocation")String vocation,
                             @RequestParam(value = "interest")String hobby,
                             HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            LearnerInfo learnerInfo = new LearnerInfo();
            learnerInfo.setUserId(userId);
            learnerInfo.setNickname(nickname);
            learnerInfo.setRealname(realName);
            learnerInfo.setAge(age);
            learnerInfo.setVacation(vocation);
            learnerInfo.setHobby(hobby);
            if(userService.updateLearnerInfo(learnerInfo))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 修改联系方式
     * @param phone
     * @param email
     * @param github
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/change/communication",method = RequestMethod.POST)
    public String changeComm(@RequestParam(value = "phone")String phone,
                             @RequestParam(value = "email")String email,
                             @RequestParam(value = "gits")String github,
                             HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            LearnerInfo learnerInfo = new LearnerInfo();
            learnerInfo.setUserId(userId);
            learnerInfo.setPhone(phone);
            learnerInfo.setEmail(email);
            learnerInfo.setGithub(github);
            if(userService.updateLearnerInfo(learnerInfo))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 修改个性签名
     * @param signature
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/change/signature",method = RequestMethod.POST)
    public String changeSignature(@RequestParam(value = "signature")String signature,
                                  HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            LearnerInfo learnerInfo = new LearnerInfo();
            learnerInfo.setUserId(userId);
            learnerInfo.setSignature(signature);
            if(userService.updateLearnerInfo(learnerInfo))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 修改头像
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/personal/change/myAvatar",method = RequestMethod.POST)
    public String upLoadPicture(MultipartHttpServletRequest request)throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            try {
                if(userService.updateAvatar(userId,request))
                    map.put("errorCode","00");
            } catch (Exception e) {
                map.put("errorCode", "error");
            }
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 获取头像
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/avatar/{id}",method = RequestMethod.GET)
    public ResponseEntity downLoadPicture(@PathVariable(value = "id") long userId ,
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

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/change/password",method = RequestMethod.POST)
    public String changePass(@RequestParam(value = "old_pass") String oldPassword,
                             @RequestParam(value = "new_pass") String newPassword,
                             @RequestParam(value = "confirm_pass") String confirmPassword,
                             HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(newPassword.equals(confirmPassword)
                && request.getSession(true).getAttribute("userId")!=null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            User user = userService.selectById(userId);
            if(user.getPassword().equals(oldPassword)
                    && !user.getPassword().equals(newPassword)){
                user.setPassword(newPassword);
                userService.updateUserInfo(user);
                map.put("errorCode","00");
            }else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 分页获取我学过的课程
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/get/myCourse", method = RequestMethod.GET)
    public String getMyCourse(@RequestParam(value = "page") Integer page,
                              HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            Page<HashMap<String,Object>> pager = userService.getUserStudiedPage(new Page<>(page,2), userId);//param:page,默认一页两个
            map.put("returnObject", pager);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 分页获取我笔试记录
     * @param page
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/get/myContest", method = RequestMethod.GET)
    public String getMyContest(@RequestParam(value = "page") Integer page,
                               HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            Page<HashMap<String,Object>> pager = userService.getUserContestPage(new Page<>(page,8), userId); //param:page,默认一页八个
            map.put("returnObject", pager);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }
}

