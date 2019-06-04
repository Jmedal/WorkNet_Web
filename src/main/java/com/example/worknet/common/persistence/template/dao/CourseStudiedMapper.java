package com.example.worknet.common.persistence.template.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.worknet.common.persistence.template.modal.CourseStudied;
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
 * 用户学习课程记录表 Mapper 接口
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Component
public interface CourseStudiedMapper extends BaseMapper<CourseStudied> {


    @Select("SELECT\n" +
            "\tsys_course.id,\n" +
            "\tsys_course.NAME,\n" +
            "\tsys_course_studied.start_time, \n" +
            "\t( SELECT AVG( stars ) AS avgStar FROM sys_course_comment WHERE sys_course_comment.course_id = sys_course.id ) AS avgStar,\n" +
            "\tsys_course.introduction\n" +
            "FROM\n" +
            "\tsys_course_studied\n" +
            "\tJOIN sys_course \n" +
            "WHERE\n" +
            "\tsys_course_studied.user_id = #{id} \n" +
            "\tAND sys_course_studied.course_id = sys_course.id\n" +
            "ORDER BY sys_course_studied.start_time DESC")
    @Results(id = "teacherInfoResultMap",value = {
            @Result(property = "cid",column = "id"),
            @Result(property = "title",column = "NAME"),
            @Result(property = "startTime",column = "start_time"),
            @Result(property = "avgStar",column = "avgStar"),
            @Result(property = "abstract",column = "introduction"),
    })
    List<HashMap<String,Object>> getUserStudiedPage(Pagination pagination, @Param("id") Long id);
}
