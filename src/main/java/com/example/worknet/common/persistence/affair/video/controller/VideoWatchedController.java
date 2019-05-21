package com.example.worknet.common.persistence.affair.video.controller;


import com.alibaba.fastjson.JSON;
import com.example.worknet.common.persistence.affair.video.serivce.VideoWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 播放记录表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Controller
@ResponseBody
public class VideoWatchedController {

    @Autowired
    private VideoWatchedService videoWatchedService;

    /**
     * 获得视频观看历史进度
     * @param vid
     * @param percent
     * @return
     */
    @RequestMapping(value = "/video/{vid}/update-progress", method = RequestMethod.POST)
    public String progress(@PathVariable(value = "vid") long vid,
                           @RequestParam(value = "percent") String percent,
                           HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            long userId = (long)request.getSession(true).getAttribute("userId");
            if(videoWatchedService.insertWatched(userId,vid,percent))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }
        else
            map.put("errorCode","error");
        return JSON.toJSONString(map);
    }
}

