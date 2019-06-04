package com.example.worknet.common.persistence.affair.user.serviceImpl;

import com.example.worknet.common.constant.Const;
import com.example.worknet.common.persistence.affair.user.serivce.UserService;
import com.example.worknet.common.persistence.template.dao.CompanyMapper;
import com.example.worknet.common.persistence.affair.user.serivce.CompanyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.worknet.common.persistence.template.modal.Company;
import com.example.worknet.common.persistence.template.modal.User;
import com.example.worknet.core.utils.FileToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司信息表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-06
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    /**
     * 获取公司头像
     * @param companyId
     * @return
     */
    @Override
    public Resource getCompanyAvatar(long companyId, String strDirPath) {
       return userService.getAvatar(super.selectById(companyId).getUserId(),strDirPath);
    }


    @Autowired
    private UserService userService;

}
