package com.example.worknet.common.persistence.template.dao;

import com.example.worknet.common.persistence.template.modal.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
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

    @Select("select " +
            "sys_user.account," +
            "sys_user.head_path," +
            "sys_user.role," +
            "sys_user.activity," +
            "sys_teacher_info.user_id," +
            "sys_teacher_info.realname," +
            "sys_teacher_info.identity," +
            "sys_teacher_info.phone," +
            "sys_teacher_info.email," +
            "sys_teacher_info.tag," +
            "sys_teacher_info.introduction," +
            "sys_teacher_info.github " +
            "from sys_user join sys_teacher_info where sys_user.id=#{id} and sys_teacher_info.user_id=#{id}")
    @Results(id = "teacherInfoResultMap",value = {
            @Result(property = "account",column = "account"),
            @Result(property = "headPath",column = "head_path"),
            @Result(property = "role",column = "role"),
            @Result(property = "activity",column = "activity"),
            @Result(property = "uid",column = "user_id"),
            @Result(property = "realName",column = "realname"),
            @Result(property = "identity",column = "identity"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "email",column = "email"),
            @Result(property = "tag",column = "tag"),
            @Result(property = "introduction",column = "introduction"),
            @Result(property = "gits",column = "github"),
    })
    HashMap<String,Object> getTeacherInfo(@Param("id") Long id);

    @Select("select " +
            "sys_user.account," +
            "sys_user.head_path," +
            "sys_user.role," +
            "sys_user.activity," +
            "sys_learner_info.user_id," +
            "sys_learner_info.nickname," +
            "sys_learner_info.realname," +
            "sys_learner_info.sex," +
            "sys_learner_info.age," +
            "sys_learner_info.signature," +
            "sys_learner_info.vacation," +
            "sys_learner_info.phone," +
            "sys_learner_info.email," +
            "sys_learner_info.hobby," +
            "sys_learner_info.professional," +
            "sys_learner_info.github " +
            "from sys_user join sys_learner_info where sys_user.id=#{id} and sys_learner_info.user_id=#{id}")
    @Results(id = "learnerInfoResultMap",value = {
            @Result(property = "account",column = "account"),
            @Result(property = "headPath",column = "head_path"),
            @Result(property = "role",column = "role"),
            @Result(property = "activity",column = "activity"),
            @Result(property = "uid",column = "user_id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "realName",column = "realname"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            @Result(property = "signature",column = "signature"),
            @Result(property = "vacation",column = "vacation"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "email",column = "email"),
            @Result(property = "interest",column = "hobby"),
            @Result(property = "target",column = "professional"),
            @Result(property = "gits",column = "github"),
    })
    HashMap<String,Object> getLearnerInfo(@Param("id") Long id);

    @Select("select " +
            "sys_user.account," +
            "sys_user.head_path," +
            "sys_user.role," +
            "sys_user.activity," +
            "sys_company.user_id," +
            "sys_company.name," +
            "sys_company.introduction," +
            "sys_company.address," +
            "sys_company.register_time " +
            "from sys_user join sys_company where sys_user.id=#{id} and sys_company.user_id=#{id}")
    @Results(id = "companyInfoResultMap",value = {
            @Result(property = "account",column = "account"),
            @Result(property = "headPath",column = "head_path"),
            @Result(property = "role",column = "role"),
            @Result(property = "activity",column = "activity"),
            @Result(property = "uid",column = "user_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "introduction",column = "introduction"),
            @Result(property = "address",column = "address"),
            @Result(property = "registerTime",column = "register_time"),
    })
    HashMap<String,Object> getCompanyInfo(@Param("id") Long id);
}
