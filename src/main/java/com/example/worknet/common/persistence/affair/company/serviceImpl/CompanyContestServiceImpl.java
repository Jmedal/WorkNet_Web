package com.example.worknet.common.persistence.affair.company.serviceImpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.ContestConst;
import com.example.worknet.common.persistence.template.modal.CompanyContest;
import com.example.worknet.common.persistence.template.dao.CompanyContestMapper;
import com.example.worknet.common.persistence.affair.company.serivce.CompanyContestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;



/**
 * <p>
 * 公司笔试表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Service
public class CompanyContestServiceImpl extends ServiceImpl<CompanyContestMapper, CompanyContest> implements CompanyContestService {


    /**
     * 获取筛选的课程列表信息
     * @param page
     * @param type
     * @return
     */
    @Override
    public Page<HashMap<String,Object>> getContestPage(Page<HashMap<String, Object>> page, ContestConst type, String keyword){
        switch(type){
            case CONTEST_NEW:
                return page.setRecords(companyContestMapper.getNewContestPage(page,keyword));
            case CONTEST_MOST:
                return page.setRecords(companyContestMapper.getMostContestPage(page,keyword));
            case CONTEST_DEFAULT:
                return page.setRecords(companyContestMapper.getDefaultContestPage(page,keyword));
            default:
                return page.setRecords(new ArrayList<HashMap<String,Object>>());
        }
    }

    /**
     * 获取笔试详细信息
     * @param eid
     * @param uid
     * @return
     */
    @Override
    public HashMap<String,Object> getContestInfo(Long eid, Long uid){
        if (uid == null)
            uid = (long)0;
        return companyContestMapper.getContestInfo(eid,uid);
    }


    @Autowired
    private CompanyContestMapper companyContestMapper;
}
