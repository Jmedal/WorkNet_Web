package com.example.worknet.common.persistence.affair.course.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.CourseConst;
import com.example.worknet.common.persistence.affair.course.serivce.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-30
 */
@Controller
@ResponseBody
public class CourseController {

    private final static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    /**
     * 筛选获得课程列表
     * page,keyword,order(['new'|'star'|'most'|'']),对应最新发布，评分最高，最多人学和默认排序
     * @param page
     * @param keyword
     * @param order
     * @return
     */
    @RequestMapping(value = "/get/courses",method = RequestMethod.GET)
    public String getCourses(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "order", required = false) String order){
        if(keyword == null) keyword = "";
        if(order == null) order = "";
        if(page == null) page = 1;
        Page<HashMap<String,Object>> questionPage = null;
        if(order.equals("new"))
            questionPage = courseService.getCoursePage(new Page<>(page, 9), CourseConst.COURSE_NEW,keyword);
        else if(order.equals("star"))
            questionPage = courseService.getCoursePage(new Page<>(page, 9), CourseConst.COURSE_STAR,keyword);
        else if(order.equals("most"))
            questionPage = courseService.getCoursePage(new Page<>(page, 9), CourseConst.COURSE_MOST,keyword);
        else
            questionPage = courseService.getCoursePage(new Page<>(page, 9), CourseConst.COURSE_DEfAULT,keyword);
        HashMap<String,Object> map = new HashMap<>();
        map.put("errorCode","00");
        map.put("returnObject",questionPage);
        return JSON.toJSONString(map);
    }

    /**
     * 课程预览图片
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/course/view/{cid}", method =  RequestMethod.GET)
    public ResponseEntity getCoursePicture(@PathVariable("cid") Long cid ,
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
            return ResponseEntity.ok(courseService.getCoursePicture(cid,strDirPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     *获取课程基本信息
     * @param cid
     * @return
     */
    @RequestMapping(value = "/get/course/basicInfo/{cid}", method = RequestMethod.GET)
    public String getCourseBasicInfo(@PathVariable("cid") Long cid){
        HashMap<String,Object> map = new HashMap<>();
        map.put("errorCode","00");
        HashMap<String,Object> obj = courseService.getCourseInfo(cid);
        map.put("returnObject",obj);
        return JSON.toJSONString(map);
    }

    /**
     *获取课程目录
     * @param cid
     * @return
     */
    @RequestMapping(value = "/get/course/menu/{cid}", method =  RequestMethod.GET)
    public String getCourseMenu(@PathVariable("cid") Long cid){
        HashMap<String,Object> map = new HashMap<>();
        if(cid==null){
            map.put("errorCode","error");
        } else {
            map.put("returnObject",courseService.getCourseMenu(cid));
            map.put("errorCode","00");
        }
        return JSON.toJSONString(map);
    }

}
