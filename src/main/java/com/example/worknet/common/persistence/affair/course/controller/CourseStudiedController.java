package com.example.worknet.common.persistence.affair.course.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.course.serivce.CourseStudiedService;
import com.example.worknet.common.persistence.template.modal.CourseStudied;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 用户学习课程记录表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
public class CourseStudiedController {

    @Autowired
    private CourseStudiedService courseStudiedService;

    /**
     * 报名学习课程
     * @param cid
     * @param joinTime
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/study/course/{cid}", method = RequestMethod.GET)
    public String studyCourse(@PathVariable(value = "cid") long cid,
                              @RequestParam(value = "joinTime") String joinTime,
                              HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            CourseStudied courseStudied = new CourseStudied();
            courseStudied.setCourseId(cid);
            courseStudied.setUserId(userId);
            courseStudied.setStartTime(DateUtil.getSqlDateTime(joinTime,DateUtil.YMD_TIME));
            if(courseStudiedService.insert(courseStudied))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 获取是否报名参加该课程以及报名的时间
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/get/joinedCourse/{cid}", method = RequestMethod.GET)
    public String getStudied(@PathVariable(value = "cid") long cid,
                             HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            HashMap<String,Object> res = new HashMap<>();
            String joinTime = courseStudiedService.getStudiedTime(userId,cid);
            if(joinTime != null) {
                res.put("isJoined", true);
                res.put("joinTime",joinTime);
            }
            else
                res.put("isJoined",false);
            map.put("returnObject",res);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 获取用户参加过的课程用来展示个人页面
     * @param uid
     * @param page
     * @return
     */
    @RequestMapping(value = "/get/other/joinedCourse/{uid}",  method = RequestMethod.GET)
    public String getOtherCourse(@PathVariable(value = "uid") long uid,
                                 @RequestParam(value = "page") Integer page){
        HashMap<String,Object> map = new HashMap<>();
        Page<HashMap<String,Object>> pager = courseStudiedService.getUserStudiedPage(new Page<>(page,2), uid);//param:page,默认一页两个
        map.put("returnObject", pager);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }






}

