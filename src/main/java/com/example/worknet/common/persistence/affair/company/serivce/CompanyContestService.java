package com.example.worknet.common.persistence.affair.company.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.worknet.common.constant.ContestConst;
import com.example.worknet.common.persistence.template.modal.CompanyContest;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 公司笔试表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
public interface CompanyContestService extends IService<CompanyContest> {

    Page<HashMap<String,Object>> getContestPage(Page<HashMap<String, Object>> page, ContestConst type, String keyword);

    HashMap<String,Object> getContestInfo(Long eid, Long uid);
}
