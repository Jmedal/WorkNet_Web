package com.example.worknet.common.persistence.affair.user.serivce;

import com.baomidou.mybatisplus.service.IService;
import com.example.worknet.common.persistence.template.modal.Company;
import org.springframework.core.io.Resource;

/**
 * <p>
 * 公司信息表 服务类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-06
 */
public interface CompanyService extends IService<Company> {

    Resource getCompanyAvatar(long companyId, String strDirPath);
}
