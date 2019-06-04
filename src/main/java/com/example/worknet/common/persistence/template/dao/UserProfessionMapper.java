package com.example.worknet.common.persistence.template.dao;

import com.example.worknet.common.persistence.template.modal.UserProfession;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户选择职业表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-06-04
 */
@Component
public interface UserProfessionMapper extends BaseMapper<UserProfession> {
}
