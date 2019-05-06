package com.example.worknet.common.persistence.template.dao;

import com.example.worknet.common.persistence.template.modal.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where id=#{id}")
    HashMap<String,Object> getUserInfo(@Param("id") Long id);
}
