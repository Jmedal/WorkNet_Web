package com.example.worknet.common.persistence.affair.company.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.persistence.affair.company.serivce.CompanyContestApplyService;
import com.example.worknet.common.persistence.template.modal.CompanyContestApply;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 公司笔试报名表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Controller
@ResponseBody
public class CompanyContestApplyController {

    @Autowired
    private CompanyContestApplyService companyContestApplyService;

    /**
     * 获取用户参加过的笔试用来展示个人页面
     * @param uid
     * @param page
     * @return
     */
    @RequestMapping(value = "/get/other/joinedExam/{uid}", method = RequestMethod.GET)
    public String getOtherExam(@PathVariable(value = "uid") long uid,
                               @RequestParam(value = "page") Integer page){
        HashMap<String,Object> map = new HashMap<>();
        Page<HashMap<String,Object>> pager = companyContestApplyService.getUserContestPage(new Page<>(page,8), uid); //param:page,默认一页八个
        map.put("returnObject",pager);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 报名参加笔试
     * 从session中获取uid，返回是否成功，成功errorCode==00，否则失败
     * @param examId
     * @param request
     * @return
     */
    @RequestMapping(value = "/exam/join/{examId}",method = RequestMethod.POST)
    public String joinExam(@PathVariable(value = "examId") long examId,
                           HttpServletRequest request){
        HashMap<String,String> map = new HashMap<>();
        if(request.getSession(true).getAttribute("userId") != null){
            Long userId = (long)request.getSession(true).getAttribute("userId");
            if(companyContestApplyService.insertContestApply(userId,examId))
                map.put("errorCode","00");
            else
                map.put("errorCode","error");
        }else{
            map.put("errorCode","error");
        }
        return JSON.toJSONString(map);
    }
}

