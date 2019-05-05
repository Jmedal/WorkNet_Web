package com.example.worknet.common.persistence.affair.user.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.worknet.common.persistence.template.modal.Administrator;
import com.example.worknet.common.persistence.template.dao.AdministratorMapper;
import com.example.worknet.common.persistence.affair.user.serivce.AdministratorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {

    @Autowired
    AdministratorService administratorService;

    /**
     * 获取超级管理员帐号信息
     * @param account
     * @return
     */
    @Override
    public Administrator getAdministratorInfo(String account){
        List<Administrator> administratorList = administratorService.selectList(new EntityWrapper<Administrator>().eq("account",account));
        if(administratorList.size() != 0){
            return administratorList.get(0);
        }
        return null;
    }

    /**
     * 验证超级管理员帐号密码
     * @param account
     * @param password
     * @return
     */
    @Override
    public boolean verify(String account,String password){
        List<Administrator> administratorList = administratorService.selectList(new EntityWrapper<Administrator>().eq("account",account));
        if(administratorList.size() != 0 &&
                administratorList.get(0).getPassword().equals(password)){
                return true;
        }
        return false;
    }

    /**
     * 检查超级管理员帐号是否存在
     * @param account
     * @return
     */
    @Override
    public boolean checkAccount(String account){
        List<Administrator> administratorList = administratorService.selectList(new EntityWrapper<Administrator>().eq("account",account));
        if(administratorList.size() != 0)
            return true;
        return false;
    }

}
