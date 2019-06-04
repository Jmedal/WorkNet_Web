package com.example.worknet.common.persistence.affair.company.serivce;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.CompanyContestApply;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 公司笔试报名表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
public interface CompanyContestApplyService extends IService<CompanyContestApply> {

    Page<HashMap<String, Object>> getUserContestPage(Page<HashMap<String, Object>> page, Long uid);

    boolean insertContestApply(Long uid, Long eid);
}
