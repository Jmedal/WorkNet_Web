package com.example.worknet.common.persistence.affair.user.controller;


import com.example.worknet.common.persistence.affair.user.serivce.CompanyService;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-06
 */
@Controller
@ResponseBody
public class CompanyController {

    private final static Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    /**
     * 公司头像预览
     * @param companyId
     * @param request
     * @return
     */
    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/get/company/avatar/{cid}", method = RequestMethod.GET)
    public ResponseEntity getCoursePic(@PathVariable(value = "cid") long companyId,
                                       HttpServletRequest request) {
        String strDirPath = request.getSession().getServletContext().getRealPath("/");
        logger.info(strDirPath);
        String pp = request.getRequestURI();
        logger.info(pp);
        String path=request.getServletContext().getContextPath();
        logger.info(path);
        String realPath=request.getServletContext().getRealPath("/static");
        logger.info(realPath);
        try {
            return ResponseEntity.ok(companyService.getCompanyAvatar(companyId,strDirPath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * 获取笔试公司的头像（作为笔试logo)
     * @param companyId
     * @param request
     * @return
     */
    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/get/company/logo/{cid}", method = RequestMethod.GET)
    public ResponseEntity getCompanyLogo(@PathVariable(value = "cid") long companyId,
                                         HttpServletRequest request) {
        return getCoursePic(companyId, request);
    }
}

