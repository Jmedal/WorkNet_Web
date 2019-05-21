package com.example.worknet.common.persistence.affair.video.controller;


import com.alibaba.fastjson.JSON;
import com.example.worknet.common.persistence.affair.user.controller.UserController;
import com.example.worknet.common.persistence.affair.video.serivce.CourseVideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程视频表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
public class CourseVideoController {

    private final static Logger logger = LoggerFactory.getLogger(CourseVideoController.class);

    @Autowired
    private CourseVideoService courseVideoService;

    /**
     * 获取课程视频目录
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/video/menu/{cid}", method =  RequestMethod.GET)
    public String getVideoMenu(@PathVariable(value = "cid") Long cid, HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null && cid != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            List<HashMap<String,Object>> list = courseVideoService.getCourseVideoMenu(cid,userId);
            map.put("returnObject",list);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","503");
        return JSON.toJSONString(map);
    }


    /**
     * 获取课程视频
     * @param vId
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/video/{vid}",method = RequestMethod.GET)
    public ResponseEntity downLoadVideo(@PathVariable("vid") long vId ,
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
            return ResponseEntity.ok(courseVideoService.getCourseVideo(vId,strDirPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

