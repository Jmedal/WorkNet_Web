package com.example.worknet.common.persistence.affair.company.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.ContestConst;
import com.example.worknet.common.persistence.affair.company.serivce.CompanyContestApplyService;
import com.example.worknet.common.persistence.affair.company.serivce.CompanyContestService;
import com.example.worknet.common.persistence.template.modal.CompanyContest;
import com.example.worknet.common.persistence.template.modal.CompanyContestApply;
import com.example.worknet.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 * 公司笔试表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Controller
@ResponseBody
public class CompanyContestController {

    @Autowired
    private CompanyContestService companyContestService;

    /**
     * 筛选获得笔试
     * param:page,keyword,order(['new'|'most'|'']),对应最新发布，最多人参加和默认排序
     * @param page
     * @param keyword
     * @param order
     * @return
     */
    @RequestMapping(value = "/get/exams")
    @SuppressWarnings("Duplicates")
    public String getCompanyContest(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "order", required = false) String order){
        if(keyword == null) keyword = "";
        if(order == null) order = "";
        if(page == null) page = 1;
        Page<HashMap<String,Object>> pager = null;
        switch (order){
            case "new":
                pager = companyContestService.getContestPage(new Page<>(page, 16), ContestConst.CONTEST_NEW,keyword);//一页16个
                break;
            case "most":
                pager = companyContestService.getContestPage(new Page<>(page, 16), ContestConst.CONTEST_MOST,keyword);
                break;
            default:
                pager = companyContestService.getContestPage(new Page<>(page, 16), ContestConst.CONTEST_DEFAULT,keyword);
                break;
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("returnObject",pager);
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }

    /**
     * 获取笔试详细信息
     * @param examId
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/exam-detail/{examId}", method = RequestMethod.GET)
    public String getExamDetail(@PathVariable("examId") long examId,
                                HttpServletRequest request){
        HashMap<String,Object> examDetail = null;
        if(request.getSession(true).getAttribute("userId")!=null)
            examDetail = companyContestService.getContestInfo(examId,(long)request.getSession(true).getAttribute("userId"));
        else
            examDetail = companyContestService.getContestInfo(examId,(long)0);
        HashMap<String,Object> map = new HashMap<>();
        map.put("errorCode","00");
        map.put("returnObject",examDetail);
        return JSON.toJSONString(map);
    }

}

