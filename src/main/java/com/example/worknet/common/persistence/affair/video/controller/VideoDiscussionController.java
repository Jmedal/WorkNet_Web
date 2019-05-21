package com.example.worknet.common.persistence.affair.video.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.video.serivce.VideoDiscussionService;
import com.example.worknet.common.persistence.template.modal.VideoDiscussion;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讨论表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
public class VideoDiscussionController {

    @Autowired
    private VideoDiscussionService videoDiscussionService;

    /**
     * 获取视频下方的评论，注意，要求按照时间降序排列,即最迟的评论在最前面
     * @param vid
     * @return
     */
    @RequestMapping(value = "/get/video/{vid}/comment", method =  RequestMethod.GET)
    public String getCourseVideoComments(@PathVariable(value = "vid") Long vid,
                                         @RequestParam(value = "page") Integer page){
        HashMap<String,Object> map = new HashMap<>();
        Page<HashMap<String,Object>> pager = videoDiscussionService.getCourseVideoComments(new Page<>(page,10),vid);
        map.put("returnObject",pager);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 获得视频下方对应问题的回复,要求按照时间升序排列，即最早的评论在最前面
     * @param commentId
     * @param page
     * @return
     */
    @RequestMapping(value = "/get/replies/{questionId}", method =  RequestMethod.GET)
    public String getReplies( @PathVariable(value = "questionId") Integer commentId,
                              @RequestParam(value = "page") Integer page){
        HashMap<String,Object> map = new HashMap<>();
        Page<HashMap<String,Object>> pager = videoDiscussionService.getCourseVideoSubComments(new Page<>(page,5), commentId);
        map.put("returnObject",pager);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 对视频进行评论
     * @param vid
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/video/{vid}/comment", method =  RequestMethod.POST)
    public String insertComment(@PathVariable(value = "vid") long vid,
                                @RequestParam(value = "content") String content,
                                HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            long userId = (long)request.getSession(true).getAttribute("userId");
            if(videoDiscussionService.insertComment(userId,content,vid,0,0))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }

    /**
     * 回复视频评论
     * @param replyId
     * @param replyToUserId
     * @param content
     * @param request
     * @return
     */
    @RequestMapping(value = "/video/replyTo/{replyId}/{replyToUserId}", method =  RequestMethod.POST)
    public String commentReply( @PathVariable(value = "replyId") long replyId,
                                @PathVariable(value = "replyToUserId") long replyToUserId,
                                @RequestParam(value = "content") String content,
                                HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            long userId = (long)request.getSession(true).getAttribute("userId");
            if(videoDiscussionService.insertComment(userId,content,0,replyId,replyToUserId))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }


}

