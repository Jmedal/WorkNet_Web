package com.example.worknet.common.persistence.affair.course.controller;


import com.alibaba.fastjson.JSON;
import com.example.worknet.common.persistence.affair.course.serivce.CourseRecommendService;
import com.example.worknet.common.persistence.affair.profession.serivce.UserProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 职业推荐课程表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
@Controller
@ResponseBody
public class CourseRecommendController {

    @Autowired
    private CourseRecommendService courseRecommendService;

    /**
     * 获取给用户的推荐课程
     * @param request
     * @return
     */
    @RequestMapping(value = "/personal/get/occupation-course", method = RequestMethod.GET)
    public String getMyContest(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            List<HashMap<String,Object>> list = courseRecommendService.getUserProfession(userId);
            map.put("returnObject",list);
            map.put("errorCode","00");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }
}

