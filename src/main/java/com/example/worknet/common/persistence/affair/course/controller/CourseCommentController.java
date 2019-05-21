package com.example.worknet.common.persistence.affair.course.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.course.serivce.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程评价表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
public class CourseCommentController {

    @Autowired
    CourseCommentService courseCommentService;

    /**
     * 获取课程评分评价
     * @param cid
     * @return
     */
    @RequestMapping(value = "/get/course/evaluation/{cid}", method =  RequestMethod.GET)
    public String getEvaluation(@PathVariable(value = "cid") long cid){
        HashMap<String,Object> map = new HashMap<>();
        HashMap<String,Object> obj = courseCommentService.getCourseStarCount(cid);
        Page<HashMap<String,Object>> commentsPage = courseCommentService.getCourseComments(new Page<>(1,3),cid);
        List<HashMap<String,Object>> list = commentsPage.getRecords();
        obj.put("evaluations",list);
        map.put("returnObject",obj);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 获取课程评价
     * @param cid
     * @return
     */
    @RequestMapping(value = "/get/course/comments/{cid}", method =  RequestMethod.GET)
    public String getComments(@PathVariable(value = "cid") long cid,
                              @RequestParam(value = "page") Integer page){
        HashMap<String,Object> map = new HashMap<>();
        Page<HashMap<String,Object>> commentsPage = courseCommentService.getCourseComments(new Page<>(page,10),cid);
        map.put("returnObject",commentsPage);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 评分评价课程
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "/course/comment/{cid}",  method =  RequestMethod.POST)
    public String comment(@PathVariable(value = "cid") long cid, HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            long userId = (long)request.getSession(true).getAttribute("userId");
            float star = Float.valueOf(request.getParameter("star"));
            String comment = (String)request.getParameter("comment");
            if(courseCommentService.insertCourseComment(userId,cid,star,comment))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }
}

